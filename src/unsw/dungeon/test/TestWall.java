package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import unsw.dungeon.Wall;

class TestWall {

	@Test
	void movingWalls() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Wall wall1 = new Wall(dungeon,11,10);
		player1.moveRight();
		assertEquals(player1.getX(),10);		
	}

}
