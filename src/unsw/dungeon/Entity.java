package unsw.dungeon;

import java.util.*;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Entity {
    
	Dungeon dungeon;
	SimpleIntegerProperty x,y;
	State state;
	
    /**
     *  Create an entity positioned in square (x,y)
     *  Use this method in all implementing class constructors
     *  @param x
     *  @param y
     */
    public Entity (Dungeon dungeon, int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.dungeon = dungeon;
        this.state = new Closed();
    }

    public IntegerProperty x() {
        return x;
    }

    public IntegerProperty y() {
        return y;
    }

    public int getY() {
        return y().get();
    }

    public int getX() {
        return x().get();
    }
    /**
     * Returns a list of items in order of up/down/left/right. If there is no coordinate in a given direction, or no entity, it returns null
     * @inv		width > 0 && height > 0
     * 
     * @return	surroundings 	Dictionary of Entity to the immediate up/down/left/right of the reference
     */
    public Dictionary<String, Entity> getSurrounding() {
    	Dictionary<String, Entity> surroundings = new Hashtable<String, Entity>();
    	int x = getX();
    	int y = getY();
    	
    	surroundings.put("up", 		dungeon.getEntity(x,y-1));
    	surroundings.put("down", 	dungeon.getEntity(x,y+1));
    	surroundings.put("left", 	dungeon.getEntity(x-1,y));
    	surroundings.put("right", 	dungeon.getEntity(x+1,y));
    	
    	return surroundings;
    }
    
    /**
     * Returns a boolean based on whether an item has been collected by a player
     * Item 	|	Collectable
     * Wall		|	No
     * Exit		|	No
     * Door		|	No
     * Switch	|	No
     * Boulder	| 	No
     * Sword	|	No/Yes		if the player does not already have a sword, it is collectable, otherwise it is not
     * Potion	|	Yes		
     * Key		|	Yes			all keys are collectable, if already has a key, it will collect the new key and drop the older one in the same cell
     * Treasure	|	Yes
     * Bomb		|	Yes
     * Enemy	| 	No
     * Player	|	No			this will never occur; there will never be >1 player
     * 
     * @inv		width > 0 && height > 0
     */
    public boolean collect() {
    	return false;
    }

	/**
	 * Returns a boolean based on whether share a grid with any other entity.
	 * Item 	|	Sharable
	 * Wall		|	No
	 * Exit		|	Player only
	 * Door		|	No
	 * Switch	|	Sword, Potion, Key, Treasure, Bomb, Player, Enemy and Boulder only
	 * Boulder	|	Switch only
	 * Sword	|	Switch only
	 * Potion	|	Switch only
	 * Key		|	Switch only
	 * Treasure	|	Switch only
	 * Bomb		|	Switch only
	 * Enemy	|	Switch and Player only
	 * Player	| 	Exit, Switch and Enemy only
	 * 
	 * @inv		width > 0 && height > 0
	 */

	public boolean drop() {
		return false;
	}
	
    
}
