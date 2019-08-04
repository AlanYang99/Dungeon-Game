package unsw.dungeon;

import java.util.*;

public interface Goal extends Subject, Observer {
	
	public boolean evaluate();
	public boolean baseGoal();
	public List<Goal> getSubgoals();
	
}
