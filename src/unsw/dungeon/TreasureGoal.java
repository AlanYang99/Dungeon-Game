package unsw.dungeon;

public class TreasureGoal implements Goal {
	
	private int treasureLeft;
	
	public TreasureGoal(Dungeon dungeon) {
		this.treasureLeft = dungeon.getTreasure().size();
	}
	
	@Override
	public void update(Subject subject) {
		if (subject instanceof Treasure) { // Treasure will change to whichever class holds all treasure information
			treasureLeft--;
		}
		evaluate();
		notifyObservers();
	}

	@Override
	public boolean evaluate() {
		if (treasureLeft > 0)
			return false;
		else
			return true;
	}

}
