package unsw.dungeon;

public class DoorOpen implements State {

    public State setDoorOpen() { // already open, so return open door
    	return new DoorOpen();
    }

}