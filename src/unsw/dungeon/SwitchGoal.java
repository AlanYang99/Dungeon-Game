package unsw.dungeon;

public class SwitchGoal implements Goal {
	
	private int switchesLeft;
	
	SwitchGoal(int totalSwitchesInDungeon) {
		this.switchesLeft = totalSwitchesInDungeon;
	}
	
	@Override
	public void update(Subject subject, String tag) {
		if (subject instanceof Switch) { // Switch will change to whichever class holds all switch information
			Switch s = (Switch) subject;
			if (tag.equals("SwitchOpened")) {
				switchesLeft--;
			} else if (tag.equals("SwitchClosed")) {
				switchesLeft++;
			}
		}
		evaluate();
		notifyObservers("ReEvaluate");
	}
	
	@Override
	public boolean evaluate() {
		if (switchesLeft > 0)
			return false;
		else
			return true;
	}

}
