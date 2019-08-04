package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Wall extends ImmovableEntity {
	
	private List<Observer> observers;
	
    public Wall(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        observers = new ArrayList<Observer>();
    }
    
    @Override
    public boolean share(Entity Item) {
    	return false;
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
