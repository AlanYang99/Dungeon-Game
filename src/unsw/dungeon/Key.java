package unsw.dungeon;

import java.util.List;

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
	@SuppressWarnings("null")
	@Override
	public boolean collect() {
		// check player isn't already holding a sword
		if (dungeon.getPlayer().getKey() != null) {
			// set map coordinates for old key
			dungeon.getPlayer().getKey().setX(getX());
			dungeon.getPlayer().getKey().setX(getY());
		}
		
		//give to player
		dungeon.getPlayer().setKey(this);
		// remove from dungeon map
		dungeon.getMap()[getX()][getY()].remove(this);
		// set entity coordinates to null
		setX((Integer)null);
		setY((Integer)null);
		return true;
	}
	
	@Override
	public boolean use(int dx, int dy) {
		Player player = dungeon.getPlayer();
		List<Entity> doorPos = dungeon.getMap()[player.getX()+dx][player.getY()+dy];
		Door door = null;
		for (Entity e : doorPos) {
			if (e instanceof Door)
				door = (Door) e;
		}
		
		
		
		
		dungeon.getPlayer().setKey(null);
	}
	
	@Override
    public boolean share(Entity item) {
    	if (item instanceof Switch || item instanceof Player) return true;
		return super.share(item);
    }

}
