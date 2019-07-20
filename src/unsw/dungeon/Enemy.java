package unsw.dungeon;

public class Enemy extends MovableEntity {


    /**
     * Create an enemy positioned in square (x,y)
     * @param x
     * @param y
     */
    public Enemy(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }
    
	@Override
    public boolean share(Entity item) {
    	if (item instanceof Switch || item instanceof Player) return true;
		return super.share(item);
    }
	
}
