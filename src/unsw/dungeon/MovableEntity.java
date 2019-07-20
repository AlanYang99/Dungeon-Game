package unsw.dungeon;

import java.util.*;

public abstract class MovableEntity extends Entity {
	
	
	public MovableEntity(Dungeon dungeon, int x, int y) {
		super(dungeon, x, y);
		
	}
	
    public void moveUp() {
    	Dictionary<String,Entity> surrondings = getSurrounding();
    	// TODO
        if (getY() > 0)
            y().set(getY() - 1);
    }

    public void moveDown() {
        if (getY() < dungeon.getHeight() - 1)
            y().set(getY() + 1);
    }

    public void moveLeft() {
        if (getX() > 0)
            x().set(getX() - 1);
    }

    public void moveRight() {
        if (getX() < dungeon.getWidth() - 1)
            x().set(getX() + 1);
    }
    
}
