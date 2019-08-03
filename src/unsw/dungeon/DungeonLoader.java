package unsw.dungeon;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javafx.scene.image.Image;

/**
 * Loads a dungeon from a .json file.
 *
 * By extending this class, a subclass can hook into entity creation. This is
 * useful for creating UI elements with corresponding entities.
 *
 * @author Robert Clifton-Everest
 *
 */
public abstract class DungeonLoader {

    private JSONObject json;

    public DungeonLoader(String filename) throws FileNotFoundException {
        json = new JSONObject(new JSONTokener(new FileReader("dungeons/" + filename)));
    }

    /**
     * Parses the JSON to create a dungeon.
     * @return
     */
    public Dungeon load() {
        int width = json.getInt("width");
        int height = json.getInt("height");

        Dungeon dungeon = new Dungeon(width, height);

        JSONArray jsonEntities = json.getJSONArray("entities");
        
        for (int i = 0; i < jsonEntities.length(); i++) {
            loadEntity(dungeon, jsonEntities.getJSONObject(i));
        }
        
        JSONObject jsonGoals = json.getJSONObject("goal-condition");
        loadGoals(dungeon, jsonGoals);
        
        
        return dungeon;
    }
    
    private void loadGoals(Dungeon dungeon, JSONObject json) {
    	System.out.println(json);
    	
    	// First get the subgoals.
//    	JSONArray subgoals = json.getJSONArray("subgoals");
//    	
//    	Goal sub1 = getSubgoal(dungeon, subgoals, 0);
//    	Goal sub2 = getSubgoal(dungeon, subgoals, 1);
    	
    	
    	
    	String type = json.getString("goal");
    	
    	
    	
    	Goal mainGoal = null;
    	switch (type) {
    	case "AND":
    		
    		break;
    	case "OR":
    		
    		break;
    	}
    	
    }
    
    private Goal getSubgoal(Dungeon dungeon, JSONArray subgoals, int subgoalIndex) {
    	
    	
    	
    	return null;
    }

    private void loadEntity(Dungeon dungeon, JSONObject json) {
        String type = json.getString("type");
        int x = json.getInt("x");
        int y = json.getInt("y");

        Entity entity = null;
        switch (type) {
        case "player":
            Player player = new Player(dungeon, x, y);
            dungeon.setPlayer(player);
            onLoad(player);
            entity = player;
            break;
        case "wall":
            Wall wall = new Wall(dungeon, x, y);
            onLoad(wall);
            entity = wall;
            break;
        case "exit":
            Exit exit = new Exit(dungeon, x, y);
            onLoad(exit);
            entity = exit;
            break;
        case "door":
            int id = json.getInt("id");
            Door door = new Door(dungeon, x, y, id); // TODO door id
            onLoad(door);
            entity = door;
            break;
        case "switch":
            Switch plate = new Switch(dungeon, x, y);
            onLoad(plate);
            entity = plate;
            break;
        case "boulder":
            Boulder boulder = new Boulder(dungeon, x, y);
            onLoad(boulder);
            entity = boulder;
            break;
        case "enemy":
            Enemy enemy = new Enemy(dungeon, x, y);
            onLoad(enemy);
            entity = enemy;
            break;
        case "key":
            id = json.getInt("id");
            Key key = new Key(dungeon, x, y, id); // TODO key id
            onLoad(key);
            entity = key;
            break;
        case "treasure":
            Treasure treasure = new Treasure(dungeon, x, y);
            onLoad(treasure);
            entity = treasure;
            break;
        case "bomb":
            Bomb bomb = new Bomb(dungeon, x, y);
            onLoad(bomb);
            entity = bomb;
            break;
        case "invincibility":
            Potion potion = new Potion(dungeon, x, y);
            onLoad(potion);
            entity = potion;
            break;
        case "sword":
            Sword sword = new Sword(dungeon, x, y);
            onLoad(sword);
            entity = sword;
            break;
            
            
        // TODO Handle other possible entities
        }
        
    }

    
    public abstract void onLoad(Entity player);

    public abstract void onLoad(Wall wall);
    
    public abstract void onLoad(Exit exit);
    
    public abstract void onLoad(Door door);
    
    public abstract void onLoad(Switch plate);
    
    public abstract void onLoad(Boulder boulder);
    
    public abstract void onLoad(Enemy enemy);
    
    public abstract void onLoad(Key key);
    
    public abstract void onLoad(Treasure treasure);
    
    public abstract void onLoad(Bomb bomb);
    
    public abstract void onLoad(Potion potion);
    
    public abstract void onLoad(Sword sword);
    
    // TODO Create additional abstract methods for the other entities

}
