package unsw.dungeon;

public class Open implements State {
	
	@Override
	public void changeToClosed(Entity e) {
		 e.state = new Closed();
	}

}