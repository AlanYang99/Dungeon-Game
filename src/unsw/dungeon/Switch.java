package unsw.dungeon;

public class Switch implements StaticEntity, StatefulEntity {
	
	private Dungeon dungeon;

    /**
     * Create an switch positioned in square (x,y)
     * @param x
     * @param y
     */
    public Switch(Dungeon dungeon, int x, int y) {
        setup(x, y);
        this.dungeon = dungeon;
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
