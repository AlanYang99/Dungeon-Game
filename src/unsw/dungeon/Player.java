package unsw.dungeon;


public class Player extends MovableEntity {

    private Dungeon dungeon;

    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }
    
	@Override
	public void setState(State state) {
		throw new UnsupportedOperationException("Entity does not have a state.");
		
	}


}
