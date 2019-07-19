package unsw.dungeon;

public class Sword extends Entity {
	private int hits_remaining;
	
    /**
     * Create an sword positioned in square (x,y)
     * @param x
     * @param y
     */
    public Sword(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        hits_remaining = 5;
    }

	@Override
	public boolean collect() {
		return true;
	}

	@Override
	public boolean drop(Entity item) {
		// TODO Auto-generated method stub
		return false;
	}

}
