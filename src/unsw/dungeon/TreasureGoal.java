package unsw.dungeon;

public class TreasureGoal implements Goal {
	
	public int treasureLeft;
	
	TreasureGoal(int totalTreasureInDungeon) {
		this.treasureLeft = totalTreasureInDungeon;
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
