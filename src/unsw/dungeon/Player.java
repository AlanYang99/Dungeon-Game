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
	 * 
	 * @pre		Player is on the board
	 * @post	Player is either in the same original position or moves 1 space to the adjacent upper cell
	 * @inv		Player remains on the board (unless killed by bomb or enemy)
	 */
    @Override
    public boolean moveUp() {
    	List<Entity> entities = getSurrounding().get("up");
    	Boulder b = null;
    	for (Entity e : entities) {
    		if (e.isBoulder()) {
    			// attempt to move boulder first
    			b = (Boulder) e;
    		}
    	}
    	if (b != null) b.moveUp();
    	
    	if (super.moveUp()) {
    		List<Entity> entitiesToDelete = new ArrayList<Entity>();
    		Key tempkey = null;
    		boolean haveKey = key != null;
    		Key prevKey = key;
    		for (Entity e : entities) {
    			if(collectItem(e)) {
    				if (e.isKey() && haveKey) {
    					tempkey = (Key)prevKey;
    				}
					entitiesToDelete.add(e);
    			}
    		}
    		if(tempkey != null) getDungeon().addEntity(tempkey);
    		for (Entity a : entitiesToDelete) {

    			getDungeon().getMap()[a.getX()][a.getY()].remove(a);
    			a.setX(-1);
    			a.setY(-1);    			
    		}
    		return true;
    	}
    	return false;
    }
    
	/**
	 * Moves an player downwards if it is legal to do so. If a boulder can be moved in the same direction,
	 * the boulder will be moved before the player is moved.
	 * 
	 * @pre		Player is on the board
	 * @post	Player is either in the same original position or moves 1 space to the adjacent bottom cell
	 * @inv		Player remains on the board (unless killed by bomb or enemy)
	 */
    @Override
    public boolean moveDown() {
    	List<Entity> entities = getSurrounding().get("down");
    	Boulder b = null;
    	for (Entity e : entities) {
    		if (e.isBoulder()) {
    			// attempt to move boulder
    			b = (Boulder) e;
    		}
    	}
    	if (b != null) b.moveDown();
    	
    	if (super.moveDown()) {
    		List<Entity> entitiesToDelete = new ArrayList<Entity>();
    		Key tempkey = null;
    		boolean haveKey = key != null;
    		Key prevKey = key;
    		for (Entity e : entities) {
    			if(collectItem(e)) {
    				if (e.isKey() && haveKey) {
    					tempkey = (Key)prevKey;
    				}
					entitiesToDelete.add(e);
    			}
    		}
    		if(tempkey != null) getDungeon().addEntity(tempkey);
    		for (Entity a : entitiesToDelete) {
    			getDungeon().getMap()[a.getX()][a.getY()].remove(a);
    			a.setX(-1);
    			a.setY(-1);    			
    		}
    		return true;
    	}
    	return false;
    }
    
	/**
	 * Moves an player right if it is legal to do so. If a boulder can be moved in the same direction,
	 * the boulder will be moved before the player is moved.
	 * 
	 * @pre		Player is on the board
	 * @post	Player is either in the same original position or moves 1 space to the adjacent right cell
	 * @inv		Player remains on the board (unless killed by bomb or enemy)
	 */
    
    @Override
    public boolean moveRight() {
    	List<Entity> entities = super.getSurrounding().get("right");
    	Boulder b = null;
    	for (Entity e : entities) {
    		if (e.isBoulder()) {
    			// attempt to move boulder
    			b = (Boulder) e;
    		}
    	}
    	if (b != null) b.moveRight();
    	
    	if (super.moveRight()) {
    	
    		List<Entity> entitiesToDelete = new ArrayList<Entity>();
    		Key tempkey = null;
    		boolean haveKey = key != null;
    		Key prevKey = key;
    		for (Entity e : entities) {
    			if(collectItem(e)) {
    				if (e.isKey() && haveKey) {
    					tempkey = (Key)prevKey;
    				}
					entitiesToDelete.add(e);
    			}
    		}
    		if(tempkey != null) getDungeon().addEntity(tempkey);
    		for (Entity a : entitiesToDelete) {
    			if(a.isBomb()) {
    				Bomb tempBomb = (Bomb)a;
    				if(!(tempBomb.isDestroyable())) continue;
    			}
    			getDungeon().getMap()[a.getX()][a.getY()].remove(a);
    			a.setX(-1);
    			a.setY(-1);  

    		}
    		return true;
    		
    	}
    	return false;
    }    
    
	/**
	 * Moves an player left if it is legal to do so. If a boulder can be moved in the same direction,
	 * the boulder will be moved before the player is moved.
	 * 
	 * @pre		Player is on the board
	 * @post	Player is either in the same original position or moves 1 space to the adjacent left cell
	 * @inv		Player remains on the board (unless killed by bomb or enemy)
	 */
    @Override
    public boolean moveLeft() {
    	List<Entity> entities = super.getSurrounding().get("left");
    	Boulder b = null;
    	for (Entity e : entities) {
    		if (e.isBoulder()) {
    			// attempt to move boulder
    			b = (Boulder) e;
    		}
    	}
    	if (b != null) b.moveLeft();
    	
    	if (super.moveLeft()) {
    	
    		List<Entity> entitiesToDelete = new ArrayList<Entity>();
    		Key tempkey = null;
    		boolean haveKey = key != null;
    		Key prevKey = key;
    		for (Entity e : entities) {
    			if(collectItem(e)) {
    				if (e.isKey() && haveKey) {
    					tempkey = (Key)prevKey;
    				}
					entitiesToDelete.add(e);
    			}
    		}
    		if(tempkey != null) getDungeon().addEntity(tempkey);
    		for (Entity a : entitiesToDelete) {
    			if(a.isBomb()) {
    				Bomb tempBomb = (Bomb)a;
    				if(!(tempBomb.isDestroyable())) continue;
    			}
    			getDungeon().getMap()[a.getX()][a.getY()].remove(a);
    			a.setX(-1);
    			a.setY(-1);    			
    		}
    		return true;
    		
    	}
    	return false;
    }
    
    public void attack() {
    	if(sword != null)
    		sword.use();
    }
    
    public void plantBomb() {
    	if(!(bombs.isEmpty())) 
    		bombs.get(0).use();
    	
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
		invulnerable = true;
		this.potion = potion;
	}
	
	public void losePotion() {
		invulnerable = false;
		this.potion = null;
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
	 * 
	 * @pre		Player has 0 or more treasure collected
	 * @post	Player has an additional treasure collected, the dungeon has one less treasure
	 * @inv		The sum of treasure collected and remaining on the board remains the same
	 */

	public void addTreasures(Treasure treasure) {
		treasures.add(treasure);
	}
	
	/**
	 * Adds bomb to the player's bomb collection
	 * 
	 * @pre		Player has 0 or more bombs collected
	 * @post	Player has 1 or more bombs collected (in total)
	 * @inv		
	 */
	public void addBomb(Bomb bomb) {
		bombs.add(bomb);
	}
	
	/**
	 * Removes bomb to the player's bomb collection
	 * 
	 * @pre		Player has 1 or more bombs collected
	 * @post	Player has 0 or more bombs collected
	 * @inv
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
    
	/**
	 * Checks the entities that the player can share a cell with a given entity
	 * 
	 * @return 	Boolean value of whether cell can be shared
	 */
    
	@Override
    public boolean share(Entity item) {
    	if (item.isSwitch() ||item.isEnemy() || 
    			item.isKey() || item.isTreasure() || item.isBomb() ||
    			item.isPotion() || item.isSword()) return true;
    	
    	// an open exit can be shared
    	if (item.isExit() && ((Exit)item).getState().isOpen(item)) return true;
    	
		return super.share(item);
    }

	@Override
	public void update(Subject subject, String tag) {
		// If the potion updates the player, it has either started or run out.
		if (((Entity)subject).isPotion()) {
			if (tag.equals("PotionActivate"))
				invulnerable = true;
			if (tag.equals("PotionDeactivate"))
				invulnerable = false;
		}
		
	}
	
	@Override
	public boolean isPlayer() {
		return true;
	}
	
}
