package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;

import unsw.dungeon.Potion;
import unsw.dungeon.Entity;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import org.junit.jupiter.api.Test;

class TestPotion {

//	@Test
//	void collectPotion() {
//		Dungeon dungeon = new Dungeon(20,20);
//		Player player1 = new Player(dungeon,10,10);
//		Potion invisPotion = new Potion(dungeon,11,11);
//		player1.moveDown();
//		assertEquals(invisPotion.getX(),11);
//		assertEquals(invisPotion.getY(),11);
//		assertEquals(dungeon.getMap()[11][11].get(0),invisPotion);
//		player1.moveRight();
//		invisPotion.collect();
//		assertEquals(player1.getPotion(),invisPotion);
//		assertEquals(invisPotion.getX(),-1);
//		assertEquals(invisPotion.getY(),-1);
//		
//	}
	
	@Test
	void usePotion() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Potion invisPotion = new Potion(dungeon,10,10);
		assertEquals(player1.isInvulnerable(),false);
		
	}
	
	@Test
	void collectPotion2() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Potion invisPotion = new Potion(dungeon,11,10);
		System.out.println(player1.getDungeon());
		player1.moveRight();
		assertEquals(player1.getPotion(),invisPotion);
		player1.moveRight();
		assertEquals(dungeon.getMap()[11][10].isEmpty(),true);
		assertEquals(player1.getX(),12);
		
	}

}
