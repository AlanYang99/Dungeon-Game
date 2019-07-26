package unsw.dungeon;

public class Door extends Entity implements State {

    private int id;
    private State state;

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
    }
    
	@Override
    public boolean share(Entity item) {
    	if (item instanceof Player) return true;
		return super.share(item);
    }
	
	public int getId() {
		return id;
	}
	
	public State getState() {
		return state;
	}
	
}
