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
	@Override
	public boolean collect() {
		Key oldKey = dungeon.getPlayer().getKey();
		if(oldKey != null) {
			oldKey.setX(getX());
			oldKey.setY(getY());
			dungeon.getMap()[getX()][getY()].remove(this);
			dungeon.getPlayer().setKey(this);
			dungeon.addEntity(oldKey);
		} else {
			dungeon.getPlayer().setKey(this);
			// remove from dungeon map
			
			dungeon.getMap()[getX()][getY()].remove(this);			
		}
		setX(-1);
		setY(-1);
//		// check player isn't already holding a key
//		if (dungeon.getPlayer().getKey() != null) {
//			// set map coordinates for old key
//			dungeon.getPlayer().getKey().setX(getX());
//			dungeon.getPlayer().getKey().setX(getY());
//		}
//		
//		//give to player
//		dungeon.getPlayer().setKey(this);
//		// remove from dungeon map
//		
//		dungeon.getMap()[getX()][getY()].remove(this);
//		// set entity coordinates to null
//		setX(-1);
//		setY(-1);
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
		
		boolean doorOpen = false;
		
		// If the door is already open.
		if (door.getState() instanceof Open) {
			doorOpen = true;
		} else {
			// Check IDs of key and door match
			if (door.getId() == id) {
				// Unlock door
				door.getState().changeToOpenIndefinitely();
				
				doorOpen = true;
				
				// Move player.
				if (dx == 1 && dy == 0)
					player.moveRight();
				else if(dx == -1 && dy == 0)
					player.moveLeft();
				else if(dx == 0 && dy == 1)
					player.moveDown();
				else if(dx == 0 && dy == -1)
					player.moveUp();
				
				dungeon.getPlayer().setKey(null);
			}
		}
		
		return doorOpen;
	}
	
	@Override
    public boolean share(Entity item) {
    	if (item instanceof Switch || item instanceof Player) return true;
		return super.share(item);
    }

}
