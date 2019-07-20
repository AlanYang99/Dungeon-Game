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

	@SuppressWarnings("null")
	@Override
	public boolean collect() {
		//give to player
		dungeon.getPlayer().addTreasures(this);
		// remove from dungeon map
		dungeon.getMap()[getX()][getY()].remove(this);
		// set entity coordinates to null
		setX((Integer)null);
		setY((Integer)null);
		return true;
	}

	@Override
	public boolean drop(Entity item) {
		// TODO Auto-generated method stub
		return false;
	}

}
