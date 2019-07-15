package unsw.dungeon;

public class Door implements StaticEntity, StatefulEntity {
	  
    private Dungeon dungeon;
    private int id;

    /**
     * Create an door positioned in square (x,y)
     * @param x
     * @param y
     * @param id 
     */
    public Door (Dungeon dungeon, int x, int y, int id) {
        setup(x, y);
        this.dungeon = dungeon;
        this.id = id;
    }

	@Override
	public void setOpen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClose() {
		// TODO Auto-generated method stub
		
	}

}
