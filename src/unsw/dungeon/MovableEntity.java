package unsw.dungeon;

import java.util.*;

public abstract class MovableEntity extends Entity {
	
	
	public MovableEntity(Dungeon dungeon, int x, int y) {
		super(dungeon, x, y);
	}
	

	/*=====================================================================================================
	 * Methods below move any time of movable entity, with additional functionality in individual classes.
	 * Note that it is possible that an entity may not move after one of the functions are called due to
	 * surrounding entities.
	 * =====================================================================================================
	 */
	
	/**
	 * Moves an entity upwards if it is legal to do so
	 */
    public boolean moveUp() {
    	boolean sharable = true;
    	List<Entity> entities = getSurrounding().get("up");
    	for (Entity e : entities) {
    		if ((!share(e))) {
    			sharable = false;
    		}
    		if (e.isExit()) {
    			((Exit)e).checkGoal();
    		}
    	}
    	if (sharable && getY() > 0) {
    		this.getDungeon().removeEntity(this);
            y().set(getY() - 1);
            this.getDungeon().addEntity(this);
    	}
    	
    	if (this.isBoulder())
    		notifyObservers("BoulderMove");
    	
    	return sharable;
    }

	/**
	 * Moves an entity downwards if it is legal to do so
	 */
    public boolean moveDown() {
    	boolean sharable = true;
    	List<Entity> entities = getSurrounding().get("down");
    	for (Entity e : entities) {
    		if ((!share(e))) {
    			sharable = false;
    		}
    		if (e.isExit()) {
    			((Exit)e).checkGoal();
    		}
    	}
    	if (sharable && getY() < dungeon.getHeight() - 1) {
    		this.getDungeon().removeEntity(this);
    		y().set(getY() + 1);
    		this.getDungeon().addEntity(this);
    	}
    	
    	if (this.isBoulder())
    		notifyObservers("BoulderMove");
    	
    	return sharable;
    }

	/**
	 * Moves an entity to the left if it is legal to do so
	 */
    public boolean moveLeft() {
    	boolean sharable = true;
    	List<Entity> entities = getSurrounding().get("left");
    	for (Entity e : entities) {
    		if ((!share(e))) {
    			sharable = false;
    		}
    		if (e.isExit()) {
    			((Exit)e).checkGoal();
    		}
    	}
        if (sharable && getX() > 0) {
        	this.getDungeon().removeEntity(this);
            x().set(getX() - 1);
            this.getDungeon().addEntity(this);
        }
        
        if (this.isBoulder())
    		notifyObservers("BoulderMove");
        
        return sharable;
    }

	/**
	 * Moves an entity to the right if it is legal to do so
	 */
    public boolean moveRight() {
    	boolean sharable = true;
    	List<Entity> entities = getSurrounding().get("right");
    	for (Entity e : entities) {
    		if ((!share(e))) {
    			sharable = false;
    		}
    		if (e.isExit()) {
    			((Exit)e).checkGoal();
    		}
    	}
        if (sharable && getX() < dungeon.getWidth() - 1) {
        	this.getDungeon().removeEntity(this);
            x().set(getX() + 1);
            this.getDungeon().addEntity(this);
        }
        
        if (this.isBoulder())
    		notifyObservers("BoulderMove");
        
        return sharable;
    }
    
}
