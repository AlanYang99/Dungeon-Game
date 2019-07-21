package unsw.dungeon;

import java.util.List;
import java.util.ArrayList;


public class Player extends MovableEntity implements Observer {

    private Dungeon dungeon;
    
    private Sword sword;
    private Potion potion;
    private Key key;
    private List<Treasure> treasures;
    private List<Bomb> bombs;
    private boolean invulnerable;

	/**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        dungeon.setPlayer(this);
        bombs = new ArrayList <Bomb>(); //changed this
        treasures = new ArrayList <Treasure>(); //changed this
        invulnerable = false;
    }
    
	/**
	 * Moves an player upwards if it is legal to do so. If a boulder can be moved in the same direction,
	 * the boulder will be moved before the player is moved.
	 */
    @Override
    public boolean moveUp() {
    	List<Entity> entities = getSurrounding().get("up");
    	for (Entity e : entities) {
    		if (e instanceof Boulder) {
    			// attempt to move boulder first
    			((Boulder) e).moveUp();
    		}
    	}
    	if (super.moveUp()) {
    		for (Entity e : entities) {
    			collectItem(e);
    		}
    		return true;
    	}
    	return false;
    }
    
	/**
	 * Moves an player downwards if it is legal to do so. If a boulder can be moved in the same direction,
	 * the boulder will be moved before the player is moved.
	 */
    @Override
    public boolean moveDown() {
    	List<Entity> entities = getSurrounding().get("down");
    	for (Entity e : entities) {
    		if (e instanceof Boulder) {
    			// attempt to move boulder
    			((Boulder) e).moveUp();
    		}
    	}
    	if (super.moveDown()) {
    		for (Entity e : entities) {
    			collectItem(e);
    		}
    		return true;
    	}
    	return false;
    }
    
	/**
	 * Moves an player to the left if it is legal to do so. If a boulder can be moved in the same direction,
	 * the boulder will be moved before the player is moved.
	 */
    @Override
    public boolean moveLeft() {
    	List<Entity> entities = getSurrounding().get("down");
    	for (Entity e : entities) {
    		if (e instanceof Boulder) {
    			// attempt to move boulder
    			((Boulder) e).moveUp();
    		}
    	}
    	if (super.moveLeft()) {
    		for (Entity e : entities) {
    			collectItem(e);
    		}
    		return true;
    	}
    	return false;
    }
    
	/**
	 * Moves an player to the right if it is legal to do so. If a boulder can be moved in the same direction,
	 * the boulder will be moved before the player is moved.
	 */
    @Override
    public boolean moveRight() {
    	List<Entity> entities = getSurrounding().get("down");
    	for (Entity e : entities) {
    		if (e instanceof Boulder) {
    			// attempt to move boulder
    			((Boulder) e).moveUp();
    		}
    	}
    	if (super.moveRight()) {
    		for (Entity e : entities) {
    			System.out.println(e instanceof Potion);
    			collectItem(e);
    		}
    		return true;
    	}
    	return false;
    }
    
	/** ==============================================
	 *  Getters and setters
	 *  ==============================================
	 */

    public Sword getSword() {
		return sword;
	}

	public void setSword(Sword sword) {
		this.sword = sword;
	}

	public Potion getPotion() {
		return potion;
	}

	public void setPotion(Potion potion) {
		this.potion = potion;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}
	
	public boolean isInvulnerable() {
		return this.invulnerable;
	}
	
	/**
	 * Adds treasure to the player's treasure collection
	 */

	public void addTreasures(Treasure treasure) {
		treasures.add(treasure);
	}
	
	/**
	 * Adds bomb to the player's bomb collection
	 */
	public void addBomb(Bomb bomb) {
		bombs.add(bomb);
	}
	
	/**
	 * Removes bomb from the player's bomb collection
	 */
	public void dropBomb(Bomb bomb) {
		bombs.remove(bomb);
	}
	
	/** ==============================================
	 *  Get quantities of items collected
	 *  ==============================================
	 */


	/**
	 * @return number of treasure in player's treasure collection
	 */

	public int getNumTreasures() {
		return treasures.size();
	}
	
	/**
	 * @return number of bombs in player's bomb collection
	 */
	public int getNumBombs() {
		return bombs.size();
	}
	
    
	/** ==============================================
	 *  Player specific functions
	 *  ==============================================
	 */
    
	/**
	 * @return whether a player was able to collect an item
	 */
    public boolean collectItem(Entity item) {
    	if(item.collect()) return true;
    	return false;
    }
    
	/**
	 * @return whether a player was able to use an item
	 */
    public boolean useItem(Entity item) {
    	if (item.use()) return true;
    	return false;
    }
    
	/** ==============================================
	 *  Override Entity/MovableEntity functions
	 *  ==============================================
	 */
    
	@Override
    public boolean share(Entity item) {
    	if (item instanceof Switch || item instanceof Exit || item instanceof Enemy ) return true;
		return super.share(item);
    }

	@Override
	public void update(Subject subject) {
		// If the potion updates the player, it has either started or run out.
		if (subject instanceof Potion) {
			invulnerable = !invulnerable;
		}
		
	}
	
}
