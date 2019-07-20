package unsw.dungeon.enemyStates;

import unsw.dungeon.Enemy;
import unsw.dungeon.Player;
import unsw.dungeon.State;

public interface MovementBehaviour extends State {
	public void move(Player player, Enemy me);
	public void toggleState(Enemy enemy);
}
