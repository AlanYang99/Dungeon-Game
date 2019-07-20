package unsw.dungeon;

public class SwitchGoal implements Goal {
	
	private int switchesLeft;
	
	SwitchGoal(int totalSwitchesInDungeon) {
		this.switchesLeft = totalSwitchesInDungeon;
	}
	
	@Override
	public void update(Subject subject) {
		if (subject instanceof Switch) { // Switch will change to whichever class holds all switch information
			Switch s = (Switch) subject;
			if (s.getState() instanceof Open) {
				switchesLeft--;
			} else if (s.getState() instanceof Closed) {
				switchesLeft++;
			}
		}
		evaluate();
		notifyObservers();
	}
	
	@Override
	public boolean evaluate() {
		if (switchesLeft > 0)
			return false;
		else
			return true;
	}

}
