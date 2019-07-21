package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unsw.dungeon.*;

class GoalTest {
	
	@Test
	void setup() {
		
		Dungeon dungeon = new Dungeon(20,20);
		Player player = new Player(dungeon, 10, 10);
		dungeon.addEntity(player);
		Treasure gold = new Treasure(dungeon, 1, 1);
		dungeon.addEntity(gold);
		
		SwitchGoal switchG = new SwitchGoal(1);
		TreasureGoal treasureG = new TreasureGoal(dungeon);
		ANDGoal mainGoal = new ANDGoal(switchG, treasureG);
		
		System.out.println(mainGoal.evaluate());
		
		// Switch Boulder Player
		Boulder b1 = new Boulder(dungeon, 11, 10);
		Switch s1 = new Switch(dungeon, 12,10);
		
		player.moveLeft();
		
		System.out.println(mainGoal.evaluate());
		
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
	
	
	/*
	
	@Test
	void position() {
		Dungeon dungeon = new Dungeon(30,30);
		Player player1 = new Player(dungeon,15,15);
		assertEquals(player1.getX(),15);
		assertEquals(player1.getY(),15);
	}
	
	@Test
	void movingVertically() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		player1.moveDown();
		assertEquals(player1.getY(),11);
		player1.moveUp();
		assertEquals(player1.getY(),10);
	}
	
	@Test
	void movingHorizontally() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		player1.moveLeft();
		assertEquals(player1.getX(),9);
		player1.moveRight();
		assertEquals(player1.getX(),10);		
	}
	
	@Test
	void movingWalls() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Wall wall1 = new Wall(dungeon,11,10);
		player1.moveRight();
		assertEquals(player1.getX(),10);		
	}
	
	*/
	
}
