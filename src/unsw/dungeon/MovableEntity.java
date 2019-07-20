package unsw.dungeon;

import java.util.*;

public abstract class MovableEntity extends Entity {
	
	
	public MovableEntity(Dungeon dungeon, int x, int y) {
		super(dungeon, x, y);
		
	}
	
    public void moveUp() {
    	boolean sharable = true;
    	List<Entity> above = getSurrounding().get("up");
    	for (Entity e : above) {
    		if ((!share(e))) {
    			sharable = false;
    		}
    	}
    	if (sharable && getY() > 0)
            y().set(getY() - 1);
    }

    public void moveDown() {
    	boolean sharable = true;
    	List<Entity> above = getSurrounding().get("up");
    	for (Entity e : above) {
    		if ((!share(e))) {
    			sharable = false;
    		}
    	}
    	if (sharable && getY() < dungeon.getHeight() - 1)
    		y().set(getY() + 1);
    }

    public void moveLeft() {
    	boolean sharable = true;
    	List<Entity> above = getSurrounding().get("up");
    	for (Entity e : above) {
    		if ((!share(e))) {
    			sharable = false;
    		}
    	}
        if (sharable && getX() > 0)
            x().set(getX() - 1);
    }

    public void moveRight() {
    	boolean sharable = true;
    	List<Entity> above = getSurrounding().get("up");
    	for (Entity e : above) {
    		if ((!share(e))) {
    			sharable = false;
    		}
    	}
        if (sharable && getX() < dungeon.getWidth() - 1)
            x().set(getX() + 1);
    }
    
}
