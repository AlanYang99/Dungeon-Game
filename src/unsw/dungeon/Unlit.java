package unsw.dungeon;

public class Unlit implements State {
	
	@Override
	public State changeToLit1() {
		return new Lit1();
	}
	
}
