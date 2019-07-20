package unsw.dungeon;

public class SwitchGoal implements Goal {
	
	int switchesLeft;
	
	SwitchGoal(int totalSwitchesInDungeon) {
		this.switchesLeft = totalSwitchesInDungeon;
	}
	
	@Override
	public void update(Subject subject) {
		if (subject instanceof Switch) { // Switch will change to whichever class holds all switch information
			Switch s = (Switch) subject;
			if (s.state == On) {
				switchesLeft--;
			} else (s.state == Off) {
				switchesLeft++;
			}
		}
		evaluate();
		notifyObservers();
	}

	@Override
	public boolean evaluate() {
		if (livingEnemies > 0)
			return false;
		else
			return true;
	}

}
