package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;
import unsw.dungeon.*;
import org.junit.jupiter.api.Test;

class TestBoulder {

	@Test
	void movingBoulder() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);	
		Boulder boulder1 = new Boulder(dungeon,11,10);
		player1.moveRight();
		assertEquals(player1.getX(),11);
		assertEquals(player1.getY(),10);
		assertEquals(boulder1.getX(),12);
		assertEquals(boulder1.getY(),10);
	}
	
	@Test
	void twoBoulders() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);	
		Boulder boulder1 = new Boulder(dungeon,11,10);
		Boulder boulder2 = new Boulder(dungeon,12,10);
		player1.moveRight();
		assertEquals(player1.getX(),10);
		assertEquals(player1.getY(),10);
		assertEquals(boulder1.getX(),11);
		assertEquals(boulder1.getY(),10);		
		assertEquals(boulder2.getX(),12);
		assertEquals(boulder2.getY(),10);		
	}
	
	@Test
	void movingIntoWall() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);	
		Boulder boulder1 = new Boulder(dungeon,11,10);
		Wall wall1 = new Wall(dungeon,12,10);
		player1.moveRight();
		assertEquals(player1.getX(),10);
		assertEquals(player1.getY(),10);
		assertEquals(boulder1.getX(),11);
		assertEquals(boulder1.getY(),10);	
		assertEquals(wall1.getX(),12);
		assertEquals(wall1.getY(),10);			
	}
	
	@Test
	void movingIntoEntities() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);	
		Boulder boulder1 = new Boulder(dungeon,11,10);
		Sword infinitySword = new Sword(dungeon,12,10);
		assertEquals(player1.getX(),10);
		assertEquals(player1.getY(),10);
		assertEquals(boulder1.getX(),11);
		assertEquals(boulder1.getY(),10);	
		assertEquals(infinitySword.getX(),12);
		assertEquals(infinitySword.getY(),10);		
	}

}
