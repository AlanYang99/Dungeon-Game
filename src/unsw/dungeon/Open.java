package unsw.dungeon;

public class Open implements State {
	
	@Override
	public State changeToClosed() {
		return new Closed();
	}

}