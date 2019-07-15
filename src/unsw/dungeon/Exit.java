package unsw.dungeon;

public class Exit implements StaticEntity, StatefulEntity {
	
	private Dungeon dungeon;

    /**
     * Create an exit positioned in square (x,y)
     * @param x
     * @param y
     */
    public Exit(Dungeon dungeon, int x, int y) {
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
