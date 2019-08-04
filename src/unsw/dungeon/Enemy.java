package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import unsw.dungeon.enemyStates.*;

public class Enemy extends MovableEntity implements Observer {
	
	MovementBehaviour movement;
	private Player playerTracking;
	Timer timer;
	private int speed;
	
	private List<Observer> observers;
	
    /**
     * Create an enemy positioned in square (x,y)
     * @param x
     * @param y
     */
    public Enemy(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        
        observers = new ArrayList<Observer>();
        playerTracking = dungeon.getPlayer();
        movement = new enemyAttacking();
        speed = 1000;
        
        timer = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask() {
        	@Override
        	public void run() {
        	  move();
        	}
        }, 0, speed);
        
        
        
    }
    
    public void setState(MovementBehaviour state) {
    	this.movement = state;
    }
    
    public void move() {
    	movement.move(playerTracking, this);
    	
    	notifyObservers("EnemyMove");
    }
    
    public void kill() {
    	notifyObservers("EnemyDeath");
    	
    	timer.cancel();
    	this.setExist(false);
    	
    	dungeon.removeEntity(this);
    }
    
	@Override
    public boolean share(Entity item) {
		if (item instanceof Switch || item instanceof Enemy || item instanceof Player ||
    			item instanceof Key || item instanceof Treasure || item instanceof Bomb ||
    			item instanceof Potion || item instanceof Sword) return true;
    	
    	
		return super.share(item);
    }

	@Override
	public void update(Subject subject, String tag) {
		if (tag.equals("PotionActivate")) {
			this.setState(new enemyDefending());
		} else if (tag.equals("PotionDeactivate")) {
			this.setState(new enemyAttacking());
		}
	}
	
	@Override
	public boolean isEnemy() {
		return true;
	}
	
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
