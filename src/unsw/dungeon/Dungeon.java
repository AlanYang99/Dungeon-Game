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
public class Dungeon {

    private int width, height;
    // private List<Entity> entities;
    private Player player;
    private List<Entity>[][] map;

    @SuppressWarnings("unchecked")
	public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        // this.entities = new ArrayList<>();
        this.player = null;
        this.map = new ArrayList[width][height];
        
        int row, col;
        for (row = 0; row < height; row++) {
        	for (col = 0; col < width; row++) {
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

    public void addEntity(Entity entity) {
        // entities.add(entity);
    	map[entity.getX()][entity.getY()].add(entity);
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
    
}
