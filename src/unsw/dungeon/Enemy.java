package unsw.dungeon;

public class Enemy extends MovableEntity {


    /**
     * Create an enemy positioned in square (x,y)
     * @param x
     * @param y
     */
    public Enemy(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }

}
