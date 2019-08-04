package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class SwitchGoal implements Goal {
	
	private List<Observer> observers;
	
	private int switchesLeft;
	private List<Switch> switches;
	
	public SwitchGoal(Dungeon dungeon) {
		observers = new ArrayList<Observer>();
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
	
	@Override
	public void attach(Observer o) {
		observers.add(o);
	}
	
	@Override
	public void notifyObservers(String tag) {
		if (observers == null) return;
		for (Observer o : observers) {
			o.update(this, tag);
		}
	}
	
	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}
	
	@Override
	public boolean baseGoal() {
		return true;
	}
	
	@Override
	public List<Goal> getSubgoals() {
		return null;
	}
	
}
