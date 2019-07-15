package unsw.dungeon;

public class Sword implements StaticEntity {
	
	private Dungeon dungeon;
	private int hitsRemaining;
	
    /**
     * Create an sword positioned in square (x,y)
     * @param x
     * @param y
     */
    public Sword(Dungeon dungeon, int x, int y) {
        setup(x, y);
        hitsRemaining = 5;
    }

}
