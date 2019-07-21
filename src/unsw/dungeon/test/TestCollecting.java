package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;
import unsw.dungeon.*;
import org.junit.jupiter.api.Test;

class TestCollecting {

	@Test
	void collectingBomb() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Bomb bomb1 = new Bomb(dungeon,11,10);
		player1.moveRight();
		assertEquals(player1.getNumBombs(),1);
	}
	
	@Test
	void collectingKey() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Key key = new Key(dungeon,9,10,1);
		player1.moveLeft();
		assertEquals(player1.getKey(),key);		
	}

	@Test
	void collectingSword() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Sword sword1 = new Sword(dungeon,10,11);
		player1.moveDown();
		assertEquals(player1.getSword(),sword1);
	}
}
