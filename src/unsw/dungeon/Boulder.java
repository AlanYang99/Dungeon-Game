package unsw.dungeon;

import java.util.List;

public class Boulder extends MovableEntity {

	/**
	 * Create an boulder positioned in square (x,y)
	 * 
	 * @param x
	 * @param y
	 */
	public Boulder(Dungeon dungeon, int x, int y) {
		super(dungeon, x, y);
	}

	@Override
	public boolean share(Entity item) {
		if (item instanceof Switch)
			return true;
		return super.share(item);
	}

    @Override
    public void moveUp() {
    	// trigger update all switches
    }
    
    @Override
    public void moveDown() {
    	// trigger update all switches
    }
    
    @Override
    public void moveLeft() {
    	// trigger update all switches	
    }
    
    @Override
    public void moveRight() {
    	// trigger update all switches	
    }
    

}
