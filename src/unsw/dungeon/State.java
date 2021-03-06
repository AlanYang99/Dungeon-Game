package unsw.dungeon;


public interface State {
	
	/**
	 * ========================================================
	 * Open Indefinitely (door) / Open / Close states
	 * ========================================================
	 */

    default public void changeToOpenIndefinitely(Entity e) {
    	throw new UnsupportedOperationException();
    }
    
    default public void changeToOpen(Entity e) {
    	
    }
    
	default public void changeToClosed(Entity e) {
		
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
	
	
	/**
	 * ==============
	 * State boolean checks
	 * ==============
	 */	
	
    default public boolean isOpenIndefinitely(Entity e) {
    	return false;
    }
    
    default public boolean isOpen(Entity e) {
    	return false;
    }
    
	default public boolean isClosed(Entity e) {
		return false;
	}
	
}