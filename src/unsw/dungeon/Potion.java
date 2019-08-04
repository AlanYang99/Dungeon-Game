package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Potion extends Collectibles implements Subject {
	
	private final int length = 10;
	private List<Observer> observers;
	
    /**
     * Create a potion positioned in square (x,y)
     * @param x
     * @param y
     */
    public Potion(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        observers = new ArrayList<Observer>();
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
	
	@Override
	public boolean isPotion() {
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