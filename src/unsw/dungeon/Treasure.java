package unsw.dungeon;

public class Treasure extends Entity {
	
    /**
     * Create a treasure positioned in square (x,y)
     * @param x
     * @param y
     */
    public Treasure(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
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
