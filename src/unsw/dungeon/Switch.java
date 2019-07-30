package unsw.dungeon;

import java.util.List;

public class Switch extends Entity implements Observer {

    /**
     * Create an switch positioned in square (x,y)
     * @param x
     * @param y
     */
    public Switch(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
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
		if (tag.equals("EntityMove")) {
			checkTriggered();
		}
	}
	
	@Override
	public boolean isSwitch() {
		return true;
	}
	
}
