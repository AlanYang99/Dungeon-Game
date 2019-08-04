package unsw.dungeon;

public class Exit extends ImmovableEntity {


    /**
     * Create an exit positioned in square (x,y)
     * @param x
     * @param y
     */
    public Exit(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        this.state = new Closed();
    }
    
	@Override
    public boolean share(Entity item) {
    	if (item.isPlayer()) return true;
		return super.share(item);
	}
	
	public State getState() {
		return state;
	}
	
	public boolean openExit() {
		notifyObservers("ExitReached");
		if (dungeon.evaluateGoal()) {
				this.state = this.state.setExitOpen();
				return true;
		}
		return false;
	}
	
	public boolean isExit() {
		return true;
	}
	
}
