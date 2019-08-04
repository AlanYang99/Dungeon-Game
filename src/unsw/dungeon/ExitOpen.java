package unsw.dungeon;

public class ExitOpen implements State {
	
    public State setExitOpen() { // already open, so return open
    	return new ExitOpen();
    }

}
