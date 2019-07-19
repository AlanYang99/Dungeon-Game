package unsw.dungeon;

public class Sword extends Entity {
	private int hitsRemaining;
	
    /**
     * Create an sword positioned in square (x,y)
     * @param x
     * @param y
     */
    public Sword(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        hitsRemaining = 5;
    }

}
