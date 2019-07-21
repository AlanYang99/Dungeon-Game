package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;

import unsw.dungeon.Potion;
import unsw.dungeon.Entity;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import org.junit.jupiter.api.Test;

class TestPotion {

	@Test
	void collectPotion() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Potion invisPotion = new Potion(dungeon,11,11);
		player1.moveDown();
		assertEquals(invisPotion.getX(),11);
		assertEquals(invisPotion.getY(),11);
		assertEquals(dungeon.getMap()[11][11].get(0),invisPotion);
		player1.moveRight();
		invisPotion.collect();
		assertEquals(player1.getPotion(),invisPotion);
		assertEquals(invisPotion.getX(),-1);
		assertEquals(invisPotion.getY(),-1);
		
	}

}
