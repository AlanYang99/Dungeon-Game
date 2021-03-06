/**
 *
 */
package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

/**
 * A dungeon in the interactive dungeon player.
 *
 * A dungeon can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 *
 * @author Robert Clifton-Everest
 *
 */
public class Dungeon implements Observer {

    private int width, height;
    // private List<Entity> entities;
    private Player player;
    private List<Entity>[][] map;
    private List<Enemy> enemies;
    private List<Treasure> treasure;
    private List<Switch> switches;
    private List<Boulder> boulders;
    private List<Potion> potions;
    private Exit exit;
    private Goal mainGoal;
    
    @SuppressWarnings("unchecked")
	public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        // this.entities = new ArrayList<>();
        this.player = null;
        this.map = new ArrayList[width][height];
        
        this.enemies = new ArrayList<Enemy>();
        this.treasure = new ArrayList<Treasure>();
        this.switches = new ArrayList<Switch>();
        this.boulders = new ArrayList<Boulder>();
        this.potions = new ArrayList<Potion>();
        
        for (int x = 0; x < width; x++) {
        	for (int y = 0; y < height; y++) {
        		this.map[x][y] = new ArrayList<Entity>();
        	}
        }
    }
    
    
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public List<Entity>[][] getMap() {
        return map;
    }
    
    public List<Enemy> getEnemies() {
    	return enemies;
    }
    
    public List<Switch> getSwitches() {
    	return switches;
    }
    
    public Exit getExit() {
    	return exit;
    }

    public void addEntity(Entity entity) {
    	if (entity == null) return;
        // entities.add(entity);

    	map[entity.getX()][entity.getY()].add(entity);
    	
    	//entity.attach(this);
    	
    	if (entity.isEnemy())
    		enemies.add((Enemy)entity);
    	if (entity.isTreasure())
    		treasure.add((Treasure)entity);
    	if (entity.isSwitch())
    		switches.add((Switch)entity);
    	if (entity.isBoulder())
    		boulders.add((Boulder)entity);
    	if (entity.isPotion())
    		potions.add((Potion)entity);
    	if (entity.isExit())
    		exit = (Exit)entity;
    	
    }
    
    public void removeEntity(Entity entity) {
    	map[entity.getX()][entity.getY()].remove(entity);
    	
    	
    	if (entity.isEnemy())
    		enemies.remove((Enemy)entity);
    	if (entity.isTreasure())
    		treasure.remove((Treasure)entity);
    	if (entity.isSwitch())
    		switches.remove((Switch)entity);
    	if (entity.isBoulder())
    		boulders.remove((Boulder)entity);
    	
    }
    
    public List<Treasure> getTreasure() {
    	return treasure;
    }
    
    public void setGoal(Goal goal) {
    	this.mainGoal = goal;
    }
    
    public boolean evaluateGoal() {
    	return this.mainGoal.evaluate();
    }
    
    public void attachEntities() {
    	
    	for (Potion p : this.potions) {
    		// Attach each enemy to each potion.
    		for (Enemy e : this.enemies) {
            	p.attach((Observer) e);
            }
    		// Attach the player to each potion.
    		p.attach((Observer)this.player);
    	}
    	
    	
    	for (Boulder b : this.boulders) {
    		// Attach each switch to each boulder.
	    	for (Switch s : this.switches) {
				b.attach(s);
			}
    	}
    	
    	// Attach the player and enemy to the dungeon.
    	this.player.attach(this);
    	for (Enemy e : this.enemies) {
    		e.attach(this);
    	}
    	
    	
    	
    	
    	
    	
    	
    }
    
    /**
     *  Returns true if the given coordinate exists, otherwise  false.
     *  @inv	width > 0 && height > 0
     *  	
     *  @param	x
     *  @param	y
     */
    public boolean check(int x, int y) {
    	if (x >= 0 && x < width && y >= 0 && y < height) return true;
    	return false;	
    }
    
    /**
     *  Returns item found at the coordinate (x,y), otherwise null.
     *  @inv 	width > 0 && height > 0
     *  @inv	only one entity can be on the coordinate
     *  
     *  @param 	x
     *  @param 	y
     */
    public List<Entity> getEntities (int x, int y) {
    	
    	if (check(x,y) == false || map[x][y] == null) return null;
    	return map[x][y];
    }
    
    // Is called when:
    // - Enemy moves
	@Override
	public void update(Subject subject, String tag) {
		
		if (tag.equals("PlayerMove") || tag.equals("EnemyMove")) {
			Enemy enemyClashed = null;
			for (Enemy e : this.enemies) {
				if (checkPlayerEnemyClash(this.player, e)) enemyClashed = e;
			}
			
			if (enemyClashed != null) handlePlayerEnemyClash(this.player, enemyClashed);
			
			if (this.evaluateGoal()) {
				System.out.println("YOU WIN");
				// Finish game as player completed the goals.
				// TODO
			}
			
		}
		
		// Prints out the entities at the same square as the player.
		//System.out.println(getEntities(getPlayer().getX(),getPlayer().getY()));
	}
	
	private boolean checkPlayerEnemyClash(Player player, Enemy enemy) {
		// Check if the player and enemy are in the same square.
		boolean contact = false;
		if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
			contact = true;
		}
		
		return contact;
	}
	
	private void handlePlayerEnemyClash(Player player, Enemy enemy) {
		// Check if the player and enemy are in the same square.
		boolean contact = false;
		if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
			contact = true;
		}
		
		if (contact) {
			// If the player is invulnerable or has a sword, kill the enemy.
			if (player.isInvulnerable()) {
				enemy.kill();
			} else if (player.getSword() != null) {
				player.getSword().use();
				enemy.kill();
			} else {
				player.gameOver();
			}
		}
	}
    
}
