package unsw.dungeon;

public class Treasure extends ImmovableEntity {
	
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
	
	@Override
    public boolean share(Entity item) {
		if(item.isSwitch()||item.isPlayer()) return true;
		return super.share(item);
    }
	
	@Override
	public boolean isTreasure() {
		return true;
	}


}
