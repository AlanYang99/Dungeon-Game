package unsw.dungeon;

public class Sword extends StaticEntity {
	
	private int hitsRemaining;
	
    /**
     * Create an sword positioned in square (x,y)
     * @param x
     * @param y
     */
    public Sword(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        hitsRemaining = 5;
    }
    
	@Override
	public void setState(State state) {
		throw new UnsupportedOperationException("Entity does not have a state.");
		
	}

}
