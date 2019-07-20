package unsw.dungeon;

import java.util.*;

public interface Goal extends Subject, Observer {
	
	public boolean evaluate();
	
	public List<Goal> subgoals = new ArrayList<Goal>();
	
	default public void addSubgoal(Goal goal) {
		subgoals.add(goal);
	}
	
}
