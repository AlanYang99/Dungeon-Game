package unsw.dungeon;

public class Exit extends StaticEntity {


    /**
     * Create an exit positioned in square (x,y)
     * @param x
     * @param y
     */
    public Exit(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }

	@Override
	public void setState(State state) {
		// TODO Auto-generated method stub
		
	}

}
