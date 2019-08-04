package unsw.dungeon;

public class Closed implements State {
	
	@Override
	public void changeToOpen(Entity e) {
		e.state = new Open();
	}
	
	@Override
	public void changeToOpenIndefinitely(Entity e) {
		e.state = new OpenIndefinitely();
	}
	
	@Override
    public boolean isClosed(Entity e) {
    	return true;
    }

}
