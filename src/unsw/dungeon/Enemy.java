package unsw.dungeon;

import java.util.Timer;
import java.util.TimerTask;

import unsw.dungeon.enemyStates.*;

public class Enemy extends MovableEntity implements Observer {
	
	MovementBehaviour movement;
	Player playerTracking;
	
    /**
     * Create an enemy positioned in square (x,y)
     * @param x
     * @param y
     */
    public Enemy(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        playerTracking = dungeon.getPlayer();
        movement = new enemyAttacking();
        
        Timer timer = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask() {
        	@Override
        	public void run() {
        	  move();
        	}
        }, 0, 2*1000);
        
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
    	
    	dungeon.getEnemies().remove(this);
    	dungeon.getMap()[this.getX()][this.getY()].remove(this);
    }
    
	@Override
    public boolean share(Entity item) {
    	if (item.isPlayer()||item.isPlayer()) return true;
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
	
	
	
	
	
}
