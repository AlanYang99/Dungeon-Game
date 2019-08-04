package unsw.dungeon;

public class OpenIndefinitely implements State {
	
	@Override
    public boolean isOpenIndefinitely(Entity e) {
    	return true;
    }

}
