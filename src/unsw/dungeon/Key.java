package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Key extends Collectibles {
	
    private int id;
    private List<Observer> observers;

    /**
     * Create an key positioned in square (x,y)
     * @param x
     * @param y
     * @param id 
     */
    public Key (Dungeon dungeon, int x, int y, int id) {
        super(dungeon, x, y);
        this.id = id;
        observers = new ArrayList<Observer>();
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
			oldKey.setExist(true);
			dungeon.getPlayer().setKey(this);
		} else {
			dungeon.getPlayer().setKey(this);			
		}
		setExist(false);

		return true;
	}
	
	@Override
	public boolean use(int dx, int dy) {
		Player player = dungeon.getPlayer();
		List<Entity> doorPos = dungeon.getMap()[player.getX()+dx][player.getY()+dy];
		Door door = null;
		for (Entity e : doorPos) {
			if (e.isDoor())
				door = (Door) e;
		}
		if(door == null) return false;
		boolean doorOpen = false;
		
		// If the door is already open.
		if (door.getState() instanceof Open) {
			doorOpen = true;
		} else {
			// Check IDs of key and door match
			if (door.getId() == id) {
				// Unlock door
				door.getState().changeToOpenIndefinitely(this);
				
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
	public boolean isKey() {
		return true;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public void attach(Observer o) {
		observers.add(o);
	}
	
	@Override
	public void notifyObservers(String tag) {
		if (observers == null) return;
		for (Observer o : observers) {
			o.update(this, tag);
		}
	}
	
	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}
	

}
