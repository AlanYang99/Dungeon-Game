package unsw.dungeon;

public class Door extends Entity {

    private int id;

    /**
     * Create an door positioned in square (x,y)
     * @param x
     * @param y
     * @param id 
     */
    public Door (Dungeon dungeon, int x, int y, int id) {
        super(dungeon, x, y);
        this.id = id;
    }

	@Override
	public boolean collect() {
		return false;
	}

	@Override
	public boolean drop(Entity item) {
		// TODO Auto-generated method stub
		return false;
	}

}
