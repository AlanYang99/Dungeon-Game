package unsw.dungeon;


public class Player implements MovableEntity {

    private Dungeon dungeon;

    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        setup(x, y);
        this.dungeon = dungeon;
    }


}
