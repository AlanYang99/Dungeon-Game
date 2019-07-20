package unsw.dungeon;

public class Lit1 implements State {
	
	@Override
	public State changeToLit2() {
		return new Lit2();
	}

}
