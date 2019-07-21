package unsw.dungeon;

public class SwitchGoal implements Goal {
	
	private int switchesLeft;
	
	public SwitchGoal(int totalSwitchesInDungeon) {
		this.switchesLeft = totalSwitchesInDungeon;
	}
	
	@Override
	public void update(Subject subject, String tag) {
		if (subject instanceof Switch) {
			//Switch s = (Switch) subject;
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
