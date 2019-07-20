package unsw.dungeon;

import java.util.List;

public class Player extends MovableEntity implements Observer {

    private Dungeon dungeon;
   /*
    * Collectables
    * 	Sword
    * 	Potion	
    * 	Key	
    * 	Treasure	
    * 	Bomb	
    */
    
    private Sword sword;
    private Potion potion;
    private Key key;
//    private List<Treasure> treasures;
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
        invulnerable = false;

    }
    
    @Override
    public void moveUp() {
    	Boulder potentialBoulder = boulderAhead(0, -1);
    	if (potentialBoulder != null) {
    		if (potentialBoulder.canMove(0, -1)) {
    			potentialBoulder.moveUp();
    		}
    	}
    	
    	
    	if (getY() > 0)
            y().set(getY() - 1);
    }
    @Override
    public void moveDown() {
    	Boulder potentialBoulder = boulderAhead(0, 1);
    	if (potentialBoulder != null) {
    		if (potentialBoulder.canMove(0, 1)) {
    			potentialBoulder.moveDown();
    		}
    	}
    	
    	
        if (getY() < dungeon.getHeight() - 1)
            y().set(getY() + 1);
    }
    @Override
    public void moveLeft() {
    	Boulder potentialBoulder = boulderAhead(-1, 0);
    	if (potentialBoulder != null) {
    		if (potentialBoulder.canMove(-1, 0)) {
    			potentialBoulder.moveUp();
    		}
    	}
    	
    	
        if (getX() > 0)
            x().set(getX() - 1);
    }
    @Override
    public void moveRight() {
    	Boulder potentialBoulder = boulderAhead(1, 0);
    	if (potentialBoulder != null) {
    		if (potentialBoulder.canMove(1, 0)) {
    			potentialBoulder.moveUp();
    		}
    	}
    	
    	
        if (getX() < dungeon.getWidth() - 1)
            x().set(getX() + 1);
    }
    
    public Boulder boulderAhead(int dx, int dy) {
    	List<Entity> entities = dungeon.getMap()[getX()+dx][getY()+dy];
    	for (Entity e : entities) {
    		if (e instanceof Boulder)
    			return (Boulder) e;
    	}
    	return null;
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
	
//	public void addTreasures(Treasure treasure) {
//		treasures.add(treasure);
//	}
	
	public void addBomb(Bomb bomb) {
		bombs.add(bomb);
	}
	
	public void dropBomb(Bomb bomb) {
		bombs.remove(bomb);
	}
	
	/** ==============================================
	 *  Get quantities of items collected
	 *  ==============================================
	 */

//	public int getNumTreasures() {
//		return treasures.size();
//	}
	
	public int getNumBombs() {
		return bombs.size();
	}
    
	/** ==============================================
	 *  Player specific functions
	 *  ==============================================
	 */
    
    public boolean collectItem(Entity item) {
    	if(item.collect()) return true;
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
