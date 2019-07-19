package unsw.dungeon;

public class Boulder extends MovableEntity {

    /**
     * Create an boulder positioned in square (x,y)
     * @param x
     * @param y
     */
    public Boulder (Dungeon dungeon, int x, int y) {
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
