package unsw.dungeon;

public class Potion extends Entity {

    /**
     * Create a potion positioned in square (x,y)
     * @param x
     * @param y
     */
    public Potion(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }

	@SuppressWarnings("null")
	@Override
	public boolean collect() {
		//give to player
		dungeon.getPlayer().setPotion(this);
		// remove from dungeon map
		dungeon.getMap()[getX()][getY()].remove(this);
		// set entity coordinates to null
		setX(-1);
		setY(-1);
		
		// TODO: USE FUNCTIONALITY
		return true;
	}
	
	@Override
    public boolean share(Entity item) {
    	if (item instanceof Switch || item instanceof Player) return true;
		return super.share(item);
    }

}