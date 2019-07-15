package unsw.dungeon;

public class Bomb implements StaticEntity { 
	// [BC] not sure if I should add more states specifically for bomb, can handle using switch?

    private Dungeon dungeon;

    /**
     * Create an bomb positioned in square (x,y)
     * @param x
     * @param y
     */
    public Bomb(Dungeon dungeon, int x, int y) {
        setup(x, y);
        this.dungeon = dungeon;
    }

}
