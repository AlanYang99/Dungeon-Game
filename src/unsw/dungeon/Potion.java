package unsw.dungeon;

public class Potion implements StaticEntity {
	
	private Dungeon dungeon;

    /**
     * Create a potion positioned in square (x,y)
     * @param x
     * @param y
     */
    public Potion(Dungeon dungeon, int x, int y) {
        setup(x, y);
        this.dungeon = dungeon;
    }

}