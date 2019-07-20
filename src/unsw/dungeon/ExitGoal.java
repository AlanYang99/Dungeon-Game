package unsw.dungeon;

import java.util.*;

public class ExitGoal implements Goal {
	
	public Goal mainGoal;
	public boolean exitReached;
	
	public void setMainGoal(Goal goal) {
		this.mainGoal = goal;
		exitReached = false;
	}
	
	@Override
	public void update(Subject subject) {
		if (subject instanceof Exit) {
			exitReached = true;
		}
		evaluate();
		notifyObservers();
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
			result =  true;
		}
		
		return result;
	}
	
}
