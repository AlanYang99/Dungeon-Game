package unsw.dungeon;

public class ORGoal implements Goal {
	
	ORGoal(Goal subgoal1, Goal subgoal2) {
		// Attach itself to each subgoal to be updated when they do.
		subgoal1.attach(this);
		subgoal2.attach(this);
		
		// Add the subgoals to a stored array.
		addSubgoal(subgoal1);
		addSubgoal(subgoal2);
	}
	
	@Override
	public void update(Subject subject) {
		evaluate();
		notifyObservers();
	}
	
	@Override
	public boolean evaluate() {
		boolean result = false;
		for (Goal goal : subgoals) {
			result = result || goal.evaluate();
		}
		
		return result;
	}
	
}
