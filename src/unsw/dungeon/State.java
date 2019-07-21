package unsw.dungeon;

public interface State {
	
	/**
	 * ========================================================
	 * Open Indefinitely (door) / Open / Close states
	 * ========================================================
	 */

    default public State changeToOpenIndefinitely() {
    	throw new UnsupportedOperationException();
    }
    
    default public State changeToOpen() {
    	throw new UnsupportedOperationException();
    }
    
	default public State changeToClosed() {
		throw new UnsupportedOperationException();
	}

	
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