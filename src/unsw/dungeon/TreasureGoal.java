package unsw.dungeon;

public class TreasureGoal implements Goal {
	
	private int treasureLeft;
	
	public TreasureGoal(Dungeon dungeon) {
		this.treasureLeft = dungeon.getTreasure().size();
	}
	
	@Override
	public void update(Subject subject, String tag) {
		if (((Entity)subject).isTreasure() && tag.equals("TreasureCollected")) {
			treasureLeft--;
		}
		evaluate();
		notifyObservers("ReEvaluate");
	}

	@Override
	public boolean evaluate() {
		if (treasureLeft > 0)
			return false;
		else
			return true;
	}

}
