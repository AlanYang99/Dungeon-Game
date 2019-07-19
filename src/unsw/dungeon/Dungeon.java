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
    private List<Entity> entities;
    private Player player;
    private Entity[][] map;

    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.player = null;
        this.map = new Entity[width][height];
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

    // this sucks, use map
    public void addEntity(Entity entity) {
        entities.add(entity);
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
    public Entity getEntity (int x, int y) {
    	if (check(x,y) == false || map[x][y] == null) return null;
    	return map[x][y];
    }
    
    /**
     *  Returns item can be collected.
     *  @inv 	width > 0 && height > 0
     *  @inv	only one entity can be on the coordinate
     *  
     *  @param 	x
     *  @param 	y
     */
    private Entity collectableEntity (Entity item) {
    	if (check(x,y) == false || map[x][y] == null) return null;
    	return map[x][y];
    }
}
