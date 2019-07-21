package unsw.dungeon;

import java.util.*;

public interface Subject {
	public List<Observer> observers = new ArrayList<Observer>();
	
	default public void attach(Observer o) {
		observers.add(o);
	}
	
	default public void notifyObservers(String tag) {
		for (Observer o : observers) {
			o.update(this, tag);
		}
	}
}
