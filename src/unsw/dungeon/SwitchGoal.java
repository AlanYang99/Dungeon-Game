package unsw.dungeon;

import java.util.List;

public class SwitchGoal implements Goal {
	
	private int switchesLeft;
	private List<Switch> switches;
	
	public SwitchGoal(Dungeon dungeon) {
		this.switchesLeft = dungeon.getSwitches().size();
		this.switches = dungeon.getSwitches();
		
		for (Switch s : switches) {
			s.attach(this);
		}
		
	}
	
	@Override
	public void update(Subject subject, String tag) {
		if (tag.equals("SwitchUpdate")) {
			
			int count = 0;
			for (Switch s : switches) {

				if (s.getState() instanceof Open)
					count++;
			}
			
			switchesLeft = count;
			
			/*
			//Switch s = (Switch) subject;
			if (tag.equals("SwitchOpened")) {
				switchesLeft--;
			} else if (tag.equals("SwitchClosed")) {
				switchesLeft++;
			}
			*/
			
			evaluate();
			notifyObservers("ReEvaluate");
		}
		
	}
	
	@Override
	public boolean evaluate() {
		if (switchesLeft > 0)
			return false;
		else
			return true;
	}

}
