package unsw.dungeon;

public interface State {
	
	/**
	 * ========================================================
	 * Door states Open / Close states
	 * ========================================================
	 */

    default public State setDoorOpen() {
    	throw new UnsupportedOperationException();
    }
    
    default public State setDoorClose() {
    	throw new UnsupportedOperationException();	
    }
    
	/**
	 * ========================================================
	 * Exit states Open / Close states
	 * ========================================================
	 */
    
    default public State setExitOpen() {
    	throw new UnsupportedOperationException();
    }
    
    default public State setExitClose() {
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