package unsw.dungeon;

public interface MovableEntity extends StaticEntity {
	
    default public void moveUp(Dungeon dungeon) {
        if (getY() > 0)
            y().set(getY() - 1);
    }

    default public void moveDown(Dungeon dungeon) {
        if (getY() < dungeon.getHeight() - 1)
            y().set(getY() + 1);
    }

    default public void moveLeft(Dungeon dungeon) {
        if (getX() > 0)
            x().set(getX() - 1);
    }

    default public void moveRight(Dungeon dungeon) {
        if (getX() < dungeon.getWidth() - 1)
            x().set(getX() + 1);
    }
}
