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

    @SuppressWarnings("unchecked")
	public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        // this.entities = new ArrayList<>();
        this.player = null;
        this.map = new ArrayList[width][height];
        this.enemies = new ArrayList<Enemy>();
        this.treasure = new ArrayList<Treasure>();
        
        int row, col;
        for (row = 0; row < height; row++) {
        	for (col = 0; col < width; col++) {
        		this.map[row][col] = new ArrayList<Entity>();
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

    public void addEntity(Entity entity) {
        // entities.add(entity);
    	map[entity.getX()][entity.getY()].add(entity);
    	
    	entity.attach(this);
    	
    	if (entity instanceof Enemy)
    		enemies.add((Enemy)entity);
    	if (entity instanceof Treasure)
    		treasure.add((Treasure)entity);
    	
    }
    
    public List<Treasure> getTreasure() {
    	return treasure;
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
		if (subject instanceof Enemy && tag.equals("EnemyMove"))
			handlePlayerEnemyClash(player, (Enemy)subject);
		
	}
	
	private void handlePlayerEnemyClash(Player player, Enemy enemy) {
		// Check if the player and enemy are in the same square.
		boolean contact = false;
		if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
			contact = true;
		}
		
		if (contact) {
			if (player.isInvulnerable()) {
				enemy.kill();
			} else {
				// End game as player dies.
				// TODO
			}
		}
	}
    
}
