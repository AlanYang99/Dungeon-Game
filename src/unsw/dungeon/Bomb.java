package unsw.dungeon;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.property.SimpleIntegerProperty;


public class Bomb extends Collectibles { 
	
	private static int seconds = 0;
	private static Timer timer = new Timer();
	private List<Observer> observers;
	private SimpleIntegerProperty form;
	private State state;
	
    /**
     * Create an bomb positioned in square (x,y)
     * @param x
     * @param y
     */
    public Bomb(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        observers = new ArrayList<Observer>();
        form = new SimpleIntegerProperty(0);
    }
    
//    public static void main(String[] args) {
//		Dungeon dungeon = new Dungeon(20,20);
//		Player player1 = new Player(dungeon,10,10);
//		Bomb bomb1 = new Bomb(dungeon,10,12);
//		bomb1.collect();
//        bomb1.use();
//    }

	@Override
	public boolean collect() {
		//give to player
		if(isDestroyable()) {
			dungeon.getPlayer().addBomb(this);
			setExist(false);
			return true;
		}

		return false;
	}
	
    public void MyTimer() {
    	System.out.println(state);

        TimerTask task;
        state = new Unlit();

		dungeon.getPlayer().dropBomb(this);

    	int x = dungeon.getPlayer().getX();
		int y = dungeon.getPlayer().getY();
		
		this.setX(x);
		this.setY(y);


		dungeon.getMap()[x][y].add(this);
        task = new TimerTask() {
        	
        	private final int LIT1_SECONDS = 2;
        	private final int LIT2_SECONDS = 3;
        	private final int EXPLODE_SECONDS = 4;
            @Override
            public void run() { 
            	if (seconds == 0) {
                	setExist(true);
            	} else if (seconds < LIT1_SECONDS){
                    form.set(2);
                } else if (seconds < LIT2_SECONDS) {
                    form.set(3);
                	state = state.changeToLit1();
                } else if (seconds < EXPLODE_SECONDS) {
                    form.set(4);

                	state = state.changeToLit2();
                } else if (seconds == EXPLODE_SECONDS) {
                	state = state.changeToExploded();
                    destroySurroundings();
                	setExist(false);
                } else {
                	cancel();
                }
                seconds++;

            }
        };
        timer.schedule(task, 0, 1000);

    }
    
    public SimpleIntegerProperty getState() {
    	return form;
    }
	
	/**
	 *  Only ever called when there exists a bomb to be used by the player
	 */
	@Override
	public boolean use() {
		if (dungeon.getPlayer().getNumBombs() == 0) return false;

        /**
         * Bomb timer, controls the state of the bomb after it has been "dropped".
         * The bomb will go through unlit, lit1, lit2, and exploded states.
         */
        MyTimer();

		return true;
	}

	public boolean isDestroyable() {
		if(state == null)
			return true;
		return false;
	}

	

    
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
    	entities.addAll(surroundings.get("at")); //Minor error for at, because the "at" location also involves the bomb so
    											//the bomb's
    	
		List<Entity> entitiesToDelete = new ArrayList<Entity>();
		

    	for (Entity e : entities) {
    		if (e.isImmovable()) continue;
    		if (e.isPlayer()) {
    			Player tempPlayer = (Player)e;
    			if (tempPlayer.isInvulnerable())continue;
    		}
    		if(e.isBomb())continue;
			entitiesToDelete.add(e);
    	}
    	for (Entity a : entitiesToDelete) {
    		if (a instanceof Enemy) {
    			((Enemy) a).kill();
    		} else if (a instanceof Player) {
    			((Player) a).gameOver();
    		} else {
	    		a.setExist(false);
				dungeon.removeEntity(a);
				a.setX(-2);
				a.setY(-2);
    		}
		}
		dungeon.getMap()[this.getX()][this.getY()].remove(this);
		setX(-2);
		setY(-2);
	}
    
    @Override
    public boolean isBomb() {
    	return true;
    }
    
    @Override
	public void attach(Observer o) {
		observers.add(o);
	}
	
	@Override
	public void notifyObservers(String tag) {
		if (observers == null) return;
		for (Observer o : observers) {
			o.update(this, tag);
		}
	}
	
	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}


}

