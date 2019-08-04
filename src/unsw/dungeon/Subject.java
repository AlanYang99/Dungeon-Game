package unsw.dungeon;

import java.util.*;

public interface Subject {
	public void attach(Observer o);
	public void detach(Observer o);
	public void notifyObservers(String tag);
}
