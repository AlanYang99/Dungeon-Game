package unsw.dungeon;

public class DoorClose implements State {

	@Override
	public State setDoorClose() {
		 return new DoorClose();
	}
	
	@Override
	public State setDoorOpen() {
		 return new DoorOpen();
	}
}
