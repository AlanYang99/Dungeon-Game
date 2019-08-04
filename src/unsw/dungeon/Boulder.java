package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Boulder extends MovableEntity {
	
	private List<Observer> observers;
	
	/**
	 * Create an boulder positioned in square (x,y)
	 * 
	 * @param x
	 * @param y
	 */
	public Boulder(Dungeon dungeon, int x, int y) {
		super(dungeon, x, y);
		observers = new ArrayList<Observer>();
	}
	
	@Override
    public boolean share(Entity item) {
    	if (item.isSwitch()) return true;
		return super.share(item);
	}
	
	@Override
	public boolean isBoulder() {
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
