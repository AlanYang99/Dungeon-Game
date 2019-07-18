package unsw.dungeon;

public class Potion extends StaticEntity {

    /**
     * Create a potion positioned in square (x,y)
     * @param x
     * @param y
     */
    public Potion(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }
    
	@Override
	public void setState(State state) {
		//TODO
		
	}

}