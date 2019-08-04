package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class TreasureGoal implements Goal {
	
	private int treasureLeft;
	private List<Observer> observers;
	
	public TreasureGoal(Dungeon dungeon) {
		this.treasureLeft = dungeon.getTreasure().size();
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void update(Subject subject, String tag) {
		if (subject instanceof Treasure && tag.equals("TreasureCollected")) {
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
	
}
