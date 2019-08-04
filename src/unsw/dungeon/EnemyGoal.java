package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class EnemyGoal implements Goal {
	
	private int livingEnemies;
	private List<Observer> observers;
	
	public EnemyGoal(Dungeon dungeon) {
		observers = new ArrayList<Observer>();
		this.livingEnemies = dungeon.getEnemies().size();
		for (Enemy e : dungeon.getEnemies()) {
			e.attach(this);
		}
	}
	
	@Override
	public void update(Subject subject, String tag) {
		if (tag.equals("EnemyDeath")) {
			livingEnemies--;
			evaluate();
			notifyObservers("ReEvaluate");
		}
		
	}

	@Override
	public boolean evaluate() {
		if (livingEnemies > 0)
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
