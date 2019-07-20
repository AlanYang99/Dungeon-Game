package unsw.dungeon;

import java.util.List;

public class Boulder extends MovableEntity {

    /**
     * Create an boulder positioned in square (x,y)
     * @param x
     * @param y
     */
    public Boulder (Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }
    
	@Override
    public boolean share(Entity item) {
    	if (item instanceof Switch) return true;
		return super.share(item);
    }
	
	public boolean canMove(int dx, int dy) {
		List<Entity> entities = dungeon.getMap()[getX()+dx][getY()+dy];
		
		boolean canMoveTo = true;
		for (Entity e : entities) {
			canMoveTo = canMoveTo && this.share(e);
		}
		
		return canMoveTo;
	}
	
}
