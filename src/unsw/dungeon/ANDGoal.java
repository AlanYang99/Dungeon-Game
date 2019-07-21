package unsw.dungeon;

public class ANDGoal implements Goal {
	
	public ANDGoal(Goal subgoal1, Goal subgoal2) {
		// Attach itself to each subgoal to be updated when they do.
		subgoal1.attach(this);
		subgoal2.attach(this);
		
		// Add the subgoals to a stored array.
		addSubgoal(subgoal1);
		addSubgoal(subgoal2);
	}
	
	@Override
	public void update(Subject subject, String tag) {
		if (!tag.equals("ReEvaluate")) return;
		evaluate();
		notifyObservers("ReEvaluate");
	}
	
	@Override
	public boolean evaluate() {
		boolean result = true;
		for (Goal goal : subgoals) {
			result = result && goal.evaluate();
		}
		
		return result;
	}
	
}
