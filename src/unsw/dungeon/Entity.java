package unsw.dungeon;

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
    
}
