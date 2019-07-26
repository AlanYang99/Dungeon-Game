package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

class GoalTest {
	
	@Test
	void switchGoal() {
		
		Dungeon dungeon = new Dungeon(20,20);
		
		
		Player player = new Player(dungeon, 10, 10);
		
		Switch s1 = new Switch(dungeon, 12,10);
		Boulder b1 = new Boulder(dungeon, 11, 10);
		
		// Layout:
		// Player | Boulder | Switch
		
		SwitchGoal switchGoal = new SwitchGoal(dungeon);
		
		assertEquals(false, switchGoal.evaluate());
		
		// Move the boulder onto the switch.
		player.moveRight();
		
		assertEquals(true, switchGoal.evaluate());
		
		
	}
	
	@Test
	void enemyGoal() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player = new Player(dungeon, 19, 19);
		dungeon.addEntity(player);
		Enemy enemy = new Enemy(dungeon, 10, 10);
		dungeon.addEntity(enemy);
		
		EnemyGoal mainGoal = new EnemyGoal(dungeon);
		
		assertEquals(false ,mainGoal.evaluate());
		
		enemy.kill();
		
		assertEquals(true ,mainGoal.evaluate());
		
	}
	
}
