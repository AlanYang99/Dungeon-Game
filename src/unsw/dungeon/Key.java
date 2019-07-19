package unsw.dungeon;

public class Key extends Entity {
	
    private int id;

    /**
     * Create an key positioned in square (x,y)
     * @param x
     * @param y
     * @param id 
     */
    public Key (Dungeon dungeon, int x, int y, int id) {
        super(dungeon, x, y);
        this.id = id;
    }
    /**	If player is already holding a key, drop that key onto the current grid 
     * 	Player holds new key
     * 
     * @pre		
     * @post	Player holds new key. If player held an older key, that key is in the new key's original spot
     * @inv		Player holds maximum 1 key
     */
	@Override
    public boolean collect() { 
		if (dungeon.getPlayer().getKey() != null) {
			// Drop old key and set new coordinates
			dungeon.getMap()[this.getX()][this.getY()] = dungeon.getPlayer().getKey();		
			dungeon.getPlayer().getKey().x().set(this.getX());
			dungeon.getPlayer().getKey().y().set(this.getY());

			// Replace old key and set new coordinates
			dungeon.getPlayer().setKey(this);
			x().set(null);
			y().set(null);
			
		}
    	return true;
    }
	
	@Override
	public boolean use() {
		if (dungeon.getPlayer().)
		dungeon.getPlayer().setKey(null);
	}
	
	@Override
    public boolean share(Entity item) {
    	if (item instanceof Switch) return true;
		return super.share(item);
    }

}
