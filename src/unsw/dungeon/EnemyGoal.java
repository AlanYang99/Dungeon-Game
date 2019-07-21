package unsw.dungeon;

public class EnemyGoal implements Goal {
	
	private int livingEnemies;
	
	public EnemyGoal(Dungeon dungeon) {
		this.livingEnemies = dungeon.getEnemies().size();
		for (Enemy e : dungeon.getEnemies()) {
			e.attach(this);
		}
	}
	
	@Override
	public void update(Subject subject) {
		if (subject instanceof Enemy) { // Enemy will change to whichever class holds all enemy information
			livingEnemies--;
		}
		evaluate();
		notifyObservers();
	}

	@Override
	public boolean evaluate() {
		if (livingEnemies > 0)
			return false;
		else
			return true;
	}

}
