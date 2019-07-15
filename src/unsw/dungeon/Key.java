package unsw.dungeon;

public class Key implements StaticEntity {
	
    private Dungeon dungeon;
    private int id;

    /**
     * Create an key positioned in square (x,y)
     * @param x
     * @param y
     * @param id 
     */
    public Key (Dungeon dungeon, int x, int y, int id) {
        setup(x, y);
        this.dungeon = dungeon;
        this.id = id;
    }

}
