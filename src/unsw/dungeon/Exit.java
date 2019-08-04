package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Exit extends ImmovableEntity {
	
	State state;
	private List<Observer> observers;
	Dungeon dungeon;

    /**
     * Create an exit positioned in square (x,y)
     * @param x
     * @param y
     */
    public Exit(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        this.dungeon = dungeon;
        this.state = new Closed();
        observers = new ArrayList<Observer>();
    }
    
    @Override
    public boolean isExit() {
    	return true;
    }
    
    public void openExit() {
    	this.state.changeToOpenIndefinitely(this);
    }
    
    public boolean checkGoal() {
    	notifyObservers("ExitReached");
    	
    	return (dungeon.evaluateGoal());
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


    
    public State getState() {
    	return this.state;
    }

}
