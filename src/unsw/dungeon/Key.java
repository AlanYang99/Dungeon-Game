package unsw.dungeon;

public class Key extends StaticEntity {
	
    private int id;

    /**
     * Create an key positioned in square (x,y)
     * @param x
     * @param y
     * @param id 
     */
    public Key (Dungeon dungeon, int x, int y, int id) {
        super(dungeon, x, y);
        this.id = id;
    }

	@Override
	public void setState(State state) {
		throw new UnsupportedOperationException("Entity does not have a state.");
		
	}

}
