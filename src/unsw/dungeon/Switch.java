package unsw.dungeon;

import java.util.List;

public class Switch extends Entity {

	private State state;
    /**
     * Create an switch positioned in square (x,y)
     * @param x
     * @param y
     */
    public Switch(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        this.state = new Closed(); // assumes board cannot be initialized with boulder already on top of a switch
    }

	@Override
    public boolean share(Entity item) {
		if (item instanceof Door || item instanceof Exit || item instanceof Wall || item instanceof Switch) return false;
		return true;
    }
	
	public void checkTriggered() {
		List<Entity> entities = dungeon.getMap()[getX()][getY()];
		
		for (Entity e : entities) {
			if (e instanceof Boulder) {
				this.state.setTriggered();
				break;
			} else {
				this.state.setUntriggered();
			}
		}
	}


}
