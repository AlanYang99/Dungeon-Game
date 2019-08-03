package unsw.dungeon;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Bomb extends Collectibles { 
	
	private static int seconds = 0;
	private static Timer timer = new Timer();

	private State state;
	
    /**
     * Create an bomb positioned in square (x,y)
     * @param x
     * @param y
     */
    public Bomb(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }
    
    public static void main(String[] args) {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Bomb bomb1 = new Bomb(dungeon,10,12);
		bomb1.collect();
        bomb1.use();
    }

	@Override
	public boolean collect() {
		//give to player
		dungeon.getPlayer().addBomb(this);
		setExist(false);

		// remove from dungeon map
//		dungeon.getMap()[getX()][getY()].remove(this);
		// set entity coordinates to null
//		setX(-1);
//		setY(-1);
		return true;
	}
	
    public void MyTimer() {

        TimerTask task;
        state = new Unlit();

        task = new TimerTask() {
        	
        	private final int LIT1_SECONDS = 2;
        	private final int LIT2_SECONDS = 3;
        	private final int EXPLODE_SECONDS = 4;
        	
            @Override
            public void run() { 
            	if (seconds < LIT1_SECONDS){
                    System.out.println("Seconds = " + seconds);
                } else if (seconds < LIT2_SECONDS) {
                	state = state.changeToLit1();
                	System.out.println(state);
                    System.out.println("Seconds = " + seconds);
                } else if (seconds < EXPLODE_SECONDS) {
                	state = state.changeToLit2();
                    System.out.println("Seconds = " + seconds);
                } else if (seconds == EXPLODE_SECONDS) {
                	state = state.changeToExploded();
                	System.out.println("Explode");
                } else {
                	cancel();
                }
                seconds++;

            }
        };
        timer.schedule(task, 0, 1000);

    }
	
	/**
	 *  Only ever called when there exists a bomb to be used by the player
	 */
	@Override
	public boolean use() {
		if (dungeon.getPlayer().getNumBombs() == 0) return false;
		// TODO
		// remove bomb from player
		dungeon.getPlayer().dropBomb(this);
		
		// put bomb in player coordinates 
		int x = dungeon.getPlayer().getX();
		int y = dungeon.getPlayer().getX();
		
		this.setX(x);
		this.setY(y);
		dungeon.getMap()[x][y].add(this);
		
        /**
         * Bomb timer, controls the state of the bomb after it has been "dropped".
         * The bomb will go through unlit, lit1, lit2, and exploded states.
         */
       // MyTimer();
       // System.out.println(state);
		// remove bomb from map after exploded
        destroySurroundings();
		dungeon.getMap()[x][y].remove(this);
		setX(-2);
		setY(-2);
		
		return true;
	}

//	@Override
//    public boolean share(Entity item) {
//    	if (item instanceof Switch || item instanceof Player) return true;
//		return super.share(item);
//    }
	

    
    /**
     * Destroy method, used when bomb is exploding.
     * Will not destroy doors/walls/switches to the immediate top/bottom/left/right of the bomb.
     */
    protected void destroySurroundings() {
    	Dictionary<String, List<Entity>> surroundings = getSurrounding();
    	List<Entity> entities = surroundings.get("down");
    	entities.addAll(surroundings.get("up"));
    	entities.addAll(surroundings.get("left"));
    	entities.addAll(surroundings.get("right"));
		List<Entity> entitiesToDelete = new ArrayList<Entity>();
		
//		System.out.println(entities);

    	for (Entity e : entities) {
//    		System.out.println(e);
    		if (e.isImmovable()) continue;
			entitiesToDelete.add(e);
    	}
    	for (Entity a : entitiesToDelete) {
			getDungeon().getMap()[a.getX()][a.getY()].remove(a);
			a.setX(-2);
			a.setY(-2);    			
		}
	}

	


}
