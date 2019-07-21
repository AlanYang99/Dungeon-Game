package unsw.dungeon;

public class Lit2 implements State {

	@Override
	public State changeToExploded() {
		return new Exploded();
	}
}
