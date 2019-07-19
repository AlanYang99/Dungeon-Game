package unsw.dungeon;

public class EnemyGoal implements Goal {
	
	public int livingEnemies;
	
	EnemyGoal(int totalEnemiesInDungeon) {
		this.livingEnemies = totalEnemiesInDungeon;
	}
	
	@Override
	public void update(Subject subject) {
		if (subject instanceof Enemy) {
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
