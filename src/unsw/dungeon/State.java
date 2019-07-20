package unsw.dungeon;

public interface State {
	
	/**
	 * ==============
	 * Bomb states
	 * ==============
	 */
    default public State changeToUnlit() {
    	throw new UnsupportedOperationException();
    }
    
	default public State changeToLit1() {
		throw new UnsupportedOperationException();
	}
	
	default public State changeToLit2() {
		throw new UnsupportedOperationException();
	}
	
	default public State changeToExploded() {
		throw new UnsupportedOperationException();	
	}
	
}