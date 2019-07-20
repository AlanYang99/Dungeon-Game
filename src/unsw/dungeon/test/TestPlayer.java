package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;
import unsw.dungeon.Player;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Wall;

import org.junit.jupiter.api.Test;

class TestPlayer {

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

}
