package unsw.dungeon;

public class Exit extends ImmovableEntity {

	State state;
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
    public boolean isExit() {
    	return true;
    }
    
    public void openExit() {
    	this.state.changeToOpenIndefinitely(this);
    }

}
