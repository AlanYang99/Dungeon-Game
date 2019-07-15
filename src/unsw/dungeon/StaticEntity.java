package unsw.dungeon;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public interface StaticEntity{
    
    /**
     *  Create an entity positioned in square (x,y)
     *  Use this method in all implementing class constructors
     *  @param x
     *  @param y
     */
    default public void setup(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    default public IntegerProperty x() {
        return x;
    }

    default public IntegerProperty y() {
        return y;
    }

    default public int getY() {
        return y().get();
    }

    default public int getX() {
        return x().get();
    }

}
