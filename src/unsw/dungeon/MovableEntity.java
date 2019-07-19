package unsw.dungeon;

public abstract class MovableEntity extends Entity {
	
	
	public MovableEntity(Dungeon dungeon, int x, int y) {
		super(dungeon, x, y);
		
	}
	
    public void moveUp(Dungeon dungeon) {
        if (getY() > 0)
            y().set(getY() - 1);
    }

    public void moveDown(Dungeon dungeon) {
        if (getY() < dungeon.getHeight() - 1)
            y().set(getY() + 1);
    }

    public void moveLeft(Dungeon dungeon) {
        if (getX() > 0)
            x().set(getX() - 1);
    }

    public void moveRight(Dungeon dungeon) {
        if (getX() < dungeon.getWidth() - 1)
            x().set(getX() + 1);
    }
    
}
