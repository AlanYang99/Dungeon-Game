package unsw.dungeon;

import java.util.List;

public class Player extends MovableEntity {

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

	/**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
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

//	public void addTreasures(Treasure treasure) {
//		treasures.add(treasure);
//	}
	
	public void addBomb(Bomb bomb) {
		bombs.add(bomb);
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

}
