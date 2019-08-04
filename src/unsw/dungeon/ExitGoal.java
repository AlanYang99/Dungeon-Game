package unsw.dungeon;

import java.util.*;

import unsw.dungeon.Observer;

public class ExitGoal implements Goal {
	
	public Goal mainGoal;
	public boolean exitReached;
	private List<Observer> observers;
	
	public ExitGoal(Dungeon dungeon) {
		exitReached = false;
		observers = new ArrayList<Observer>();
		dungeon.getExit().attach(this);
	}
	
	public void setMainGoal(Goal goal) {
		this.mainGoal = goal;
	}
	
	@Override
	public void update(Subject subject, String tag) {
		if (tag.equals("ExitReached")) {
			exitReached = true;
		}
		evaluate();
		notifyObservers("ReEvaluate");
	}

	@Override
	public boolean evaluate() {
		if (!exitReached) return false;
		
		boolean result = false;
		
		// Check if the main goal is true if the exit is true.
		// This implies that the exit goal was the last completed.
		boolean mainResult = mainGoal.evaluate();
		
		// If false, the exit condition is false as it must be completed last.
		if (!mainResult) {
			exitReached = false;
			// Re-evaluate the main goal with the updated exit goal value.
			mainGoal.evaluate();
		} else {
		// If true, the exit goal must've been completed last so set it to true.
			result = true;
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
		return true;
	}
	
	@Override
	public List<Goal> getSubgoals() {
		return null;
	}
	
}
