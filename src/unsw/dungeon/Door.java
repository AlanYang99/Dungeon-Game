package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Door extends ImmovableEntity implements State {

    private int id;
    private State state;
    private List<Observer> observers;

    /**
     * Create an door positioned in square (x,y)
     * @param x
     * @param y
     * @param id 
     */
    public Door (Dungeon dungeon, int x, int y, int id) {
        super(dungeon, x, y);
        this.id = id;
        this.state = new Closed();
        observers = new ArrayList<Observer>();
    }
    
	
	public int getId() {
		return id;
	}
	
	public State getState() {
		return state;
	}
	
	@Override
	public boolean isDoor() {
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
