package unsw.dungeon;

public class Treasure extends Collectibles {
	
    /**
     * Create a treasure positioned in square (x,y)
     * @param x
     * @param y
     */
    public Treasure(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }

	@SuppressWarnings("null")
	@Override
	public boolean collect() {
		//give to player
		dungeon.getPlayer().addTreasures(this);

		setExist(false);

		// Update the treasure goal
		notifyObservers("TreasureCollected");
		
		return true;
	}
	


}
