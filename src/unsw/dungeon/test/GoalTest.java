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
		Enemy enemy = new Enemy(dungeon, 10, 10);
		
		EnemyGoal mainGoal = new EnemyGoal(dungeon);
		
		assertEquals(false ,mainGoal.evaluate());
		
		enemy.kill();
		
		assertEquals(true ,mainGoal.evaluate());
		//Issues with this (Most of the time it passes, but occasionally get concurrent modification error)
	}
	
	@Test
	void treasureGoal() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player = new Player(dungeon, 10, 10);
		
		Treasure tr = new Treasure(dungeon, 11, 10);
		
		TreasureGoal mainGoal = new TreasureGoal(dungeon);
		
		assertEquals(false ,mainGoal.evaluate());
		
		player.moveRight();
		
		assertEquals(false ,mainGoal.evaluate());
		
	}
	
	@Test
	void exitGoal() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player = new Player(dungeon, 19, 19);
		Exit exit = new Exit(dungeon, 19, 20);
		
		
		ExitGoal mainGoal = new ExitGoal(dungeon);
		
		assertEquals(false ,mainGoal.evaluate());
		
		player.moveDown();
		
		assertEquals(false ,mainGoal.evaluate());
		
	}
	
}
