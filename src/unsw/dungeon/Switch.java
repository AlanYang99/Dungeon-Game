package unsw.dungeon;

public class Switch extends StaticEntity {
	
	private Dungeon dungeon;

    /**
     * Create an switch positioned in square (x,y)
     * @param x
     * @param y
     */
    public Switch(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }

}
