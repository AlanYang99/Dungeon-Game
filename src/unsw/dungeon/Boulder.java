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
	public void setState(State state) {
		throw new UnsupportedOperationException("Entity does not have a state.");
		
	}

}
