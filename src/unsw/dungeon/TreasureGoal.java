package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class TreasureGoal implements Goal {
	
	private int treasureLeft;
	private List<Observer> observers;
	
	public TreasureGoal(Dungeon dungeon) {
		this.treasureLeft = dungeon.getTreasure().size();
		for (Treasure t : dungeon.getTreasure()) {
			t.attach(this);
		}
		
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void update(Subject subject, String tag) {
		if (tag.equals("TreasureCollected")) {
			treasureLeft--;
		}
		evaluate();
		notifyObservers("ReEvaluate");
	}

	@Override
	public boolean evaluate() {
		if (treasureLeft > 0)
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
