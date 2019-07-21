package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;
import unsw.dungeon.Bomb;
import unsw.dungeon.Player;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Wall;
import org.junit.jupiter.api.Test;

class TestBomb {

	@Test
	void collectingBomb() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Bomb bomb1 = new Bomb(dungeon,10,11);
		bomb1.collect();
		assertEquals(player1.getNumBombs(),1);
		assertEquals(bomb1.getX(),-1);
		assertEquals(bomb1.getY(),-1);
		Bomb bomb2 = new Bomb(dungeon,10,12);
		bomb2.collect();
		assertEquals(player1.getNumBombs(),2);
	}

	@Test
	void useBomb() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Wall wall1 = new Wall(dungeon,11,10);
		Wall wall2 = new Wall(dungeon,9,10);
		Wall wall3 = new Wall(dungeon,10,11);
		Wall wall4 = new Wall(dungeon,10,9);
		assertEquals(dungeon.getMap()[11][10].contains(wall1),true);
		assertEquals(dungeon.getMap()[9][10].contains(wall2),true);
		assertEquals(dungeon.getMap()[10][11].contains(wall3),true);
		assertEquals(dungeon.getMap()[10][9].contains(wall4),true);
		
		Bomb bomb1 = new Bomb(dungeon,10,12);
		bomb1.collect();
		assertEquals(player1.getNumBombs(),1);
		assertEquals(bomb1.use(),true);
		
		assertEquals(dungeon.getMap()[11][10].contains(wall1),true);
		assertEquals(dungeon.getMap()[9][10].contains(wall2),true);
		assertEquals(dungeon.getMap()[10][11].contains(wall3),true);
		assertEquals(dungeon.getMap()[10][9].contains(wall4),true);		
		assertEquals(player1.getNumBombs(),0);
		assertEquals(bomb1.use(),false);
		
		
	}
}
