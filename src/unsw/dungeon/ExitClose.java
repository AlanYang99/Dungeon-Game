package unsw.dungeon;

public class ExitClose implements State {
	
	@Override
    public State setExitClose() {
    	return new ExitClose();
    }
	
	@Override
    public State setExitOpen() {
    	return new ExitOpen();
    }
}
