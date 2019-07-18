package unsw.dungeon;

public class Wall extends StaticEntity {

    public Wall(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }
    
	@Override
	public void setState(State state) {
		throw new UnsupportedOperationException("Entity does not have a state.");
		
	}

}
