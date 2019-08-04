package unsw.dungeon;

import java.util.Timer;
import java.util.TimerTask;

public class Potion extends Collectibles implements Subject {
	
	private final int length = 10;
	
    /**
     * Create a potion positioned in square (x,y)
     * @param x
     * @param y
     */
    public Potion(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        
        for (Enemy e : dungeon.getEnemies()) {
        	this.attach((Observer) e);
        }
    }

	@Override
	public boolean collect() {
		//give to player
		dungeon.getPlayer().setPotion(this);
		setExist(false);
		activate();
		return true;
	}
	
	
	public void activate() {
		System.out.println("Yo");
		notifyObservers("PotionActivate");
		
		Timer timer = new Timer();
		
        timer.schedule(new TimerTask() {
        	@Override
        	public void run() {
        	  deactivate();
        	}
        }, length*1000);
        
	}
	
	public void deactivate() {
		dungeon.getPlayer().losePotion();
		notifyObservers("PotionDeactivate");
	}
	

}