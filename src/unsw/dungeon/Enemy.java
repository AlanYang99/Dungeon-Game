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

	@Override
	public boolean collect() {
		return false;
	}

	@Override
	public boolean drop(Entity item) {
		// TODO Auto-generated method stub
		return false;
	}

}
