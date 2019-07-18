package unsw.dungeon;

public class Door extends StaticEntity {

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
	public void setState(State state) {
		// TODO Auto-generated method stub
		
	}

}
