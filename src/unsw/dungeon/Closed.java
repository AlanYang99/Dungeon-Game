package unsw.dungeon;

public class Closed implements State {
	
	@Override
	public State changeToOpen() {
		return new Open();
	}

}
