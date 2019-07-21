package unsw.dungeon;

import java.util.Dictionary;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Bomb extends Entity { 
	private final int UNLIT_SECONDS = 3;
	private final int LIT1_SECONDS = 3;
	private final int LIT2_SECONDS = 3;
	private final int EXPLODE_SECONDS = 3;
	
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

	@Override
	public boolean collect() {
		//give to player
		dungeon.getPlayer().addBomb(this);
		// remove from dungeon map
		dungeon.getMap()[getX()][getY()].remove(this);
		// set entity coordinates to null
		setX(-1);
		setY(-1);
		return true;
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
		this.setX(y);
		dungeon.getMap()[x][y].add(this);
		
		// set subsequent states with timer
		setBombTimer();
		// remove bomb from map after exploded
		dungeon.getMap()[x][y].remove(this);
		setX(-2);
		setY(-2);
		
		return true;
	}

	@Override
    public boolean share(Entity item) {
    	if (item instanceof Switch || item instanceof Player) return true;
		return super.share(item);
    }
	
    /**
     * Bomb timer, controls the state of the bomb after it has been "dropped".
     * The bomb will go through unlit, lit1, lit2, and exploded states.
     */
    public void setBombTimer() {

        new TimerTask() {
        	@Override
	        public void run() { 
	            if (seconds < UNLIT_SECONDS) {
	                state.changeToUnlit();
	            } else if (seconds < LIT1_SECONDS) {
	            	state.changeToLit1();
	            } else if (seconds < LIT2_SECONDS) {
	            	state.changeToLit2();
	            } else if (seconds < EXPLODE_SECONDS) {
	            	state.changeToExploded();
	            	destroySurroundings();
	            } else {
	                cancel();	
	            }
	            seconds++;
	        }
        };

    }
    
    /**
     * Destroy method, used when bomb is exploding.
     * Will not destroy doors/walls/switches to the immediate top/bottom/left/right of the bomb.
     */
    protected void destroySurroundings() {
    	Dictionary<String, List<Entity>> surroundings = getSurrounding();
    	List<Entity> entities = surroundings.get("up");
    	entities.addAll(surroundings.get("down"));
    	entities.addAll(surroundings.get("left"));
    	entities.addAll(surroundings.get("right"));
    	
    	
    	for (Entity e : entities) {
    		if (e instanceof Door || e instanceof Switch || e instanceof Wall) continue;
    		
    		int x = e.getX();
    		int y = e.getY();
    		
    		dungeon.getMap()[x][y].remove(e);
    		
    		e.setX(-2);
    		e.setY(-2);
    	}
	}


}
