package unsw.dungeon;

public class Enemy implements MovableEntity {

    private Dungeon dungeon;

    /**
     * Create an enemy positioned in square (x,y)
     * @param x
     * @param y
     */
    public Enemy(Dungeon dungeon, int x, int y) {
        setup(x, y);
        this.dungeon = dungeon;
    }

}
