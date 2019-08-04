package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class ANDGoal implements Goal {
	
	private List<Observer> observers;
	public List<Goal> subgoals;
	
	public ANDGoal(Goal subgoal1, Goal subgoal2) {
		observers = new ArrayList<Observer>();
		subgoals = new ArrayList<Goal>();
		// Attach itself to each subgoal to be updated when they do.
		subgoal1.attach(this);
		subgoal2.attach(this);
		
		// Add the subgoals to a stored array.
		addSubgoal(subgoal1);
		addSubgoal(subgoal2);
	}
	
	public void addSubgoal(Goal goal) {
		subgoals.add(goal);
	}
	
	@Override
	public void update(Subject subject, String tag) {
		if (!tag.equals("ReEvaluate")) return;
		evaluate();
		if (observers.size() > 0) notifyObservers("ReEvaluate");
	}
	
	@Override
	public boolean evaluate() {
		boolean result = true;
		for (Goal goal : subgoals) {
			result = result && goal.evaluate();
		}
		
		return result;
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
		return false;
	}
	
	@Override
	public List<Goal> getSubgoals() {
		return subgoals;
	}
	
}
