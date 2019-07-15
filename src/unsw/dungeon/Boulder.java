package unsw.dungeon;

public class Boulder implements MovableEntity {

    private Dungeon dungeon;

    /**
     * Create an boulder positioned in square (x,y)
     * @param x
     * @param y
     */
    public Boulder (Dungeon dungeon, int x, int y) {
        setup(x, y);
        this.dungeon = dungeon;
    }

}
