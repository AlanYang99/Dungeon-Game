package unsw.dungeon.enemyStates;

import unsw.dungeon.*;

public class enemyDefending implements MovementBehaviour {
	public void move(Player player, Enemy me) {
		Dungeon dungeon = player.getDungeon();
		
		// TODO
		
	}

	@Override
	public void toggleState(Enemy enemy) {
		enemy.setState(new enemyAttacking());
	}
}