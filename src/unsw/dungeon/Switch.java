package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Switch extends Entity implements Observer {
	
	private List<Observer> observers;
	
    /**
     * Create an switch positioned in square (x,y)
     * @param x
     * @param y
     */
    public Switch(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        observers = new ArrayList<Observer>();
        this.state = new Closed(); // assumes board cannot be initialized with boulder already on top of a switch
        
    }

	@Override
    public boolean share(Entity item) {
		if (item.isImmovable()) return false;
		return true;
    }
	
	//TOD0: add to each boulder movement
	
	public void checkTriggered() {
		List<Entity> entities = dungeon.getMap()[getX()][getY()];
		notifyObservers("SwitchUpdate");
		for (Entity e : entities) {
			
			if (e.isBoulder()) {
				this.state.changeToClosed(this);
				break;
			} else {
				this.state.changeToOpen(this);
			}
		}
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public State getState() {
		return state;
	}

	@Override
	public void update(Subject subject, String tag) {
		if (tag.equals("BoulderMove")) {
			checkTriggered();
		}
	}
	
	@Override
	public boolean isSwitch() {
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
