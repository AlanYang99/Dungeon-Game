package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;
import unsw.dungeon.Key;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import unsw.dungeon.Door;
import org.junit.jupiter.api.Test;

class TestKey {

	@Test
	void collectKey() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Key key1 = new Key(dungeon,10,11,1);
		key1.collect();
		assertEquals(player1.getKey(),key1);
	}
	
	@Test
	void dropNCollectKey() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Key key1 = new Key(dungeon,10,11,1);
		key1.collect();
		assertEquals(player1.getKey(),key1);
		Key key2 = new Key(dungeon,10,12,1);
		player1.moveRight();
		key2.collect();
		assertNotEquals(player1.getKey(),key1);
		assertEquals(player1.getKey(),key2);
		assertEquals(key1.getX(),10);
		assertEquals(key1.getY(),12);
		
	}
	
	@Test
	void useKey() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Key key1 = new Key(dungeon,10,11,1);
		key1.collect();
		assertEquals(player1.getKey(),key1);
		assertEquals(player1.getKey().use(),false);
		assertNotEquals(player1.getKey(),null);
	}
	
	@Test
	void openDoor() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Key key1 = new Key(dungeon,10,11,1);
		Door door1 = new Door(dungeon,10,12,1);
		key1.collect();
		player1.moveUp();
		assertEquals(player1.getY(),11);
		
		
	}

}
