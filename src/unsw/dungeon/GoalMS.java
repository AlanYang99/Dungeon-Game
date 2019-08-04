package unsw.dungeon;

public class GoalMS {
	private String type;
	private State state;
	
	GoalMS (String type) {
		this.type = type;
		this.state = new GoalOpen();
	}	
	
	public void setComplete() {
		this.state = new Closed();
	}

	public String getType() {
		return type;
	}

}
