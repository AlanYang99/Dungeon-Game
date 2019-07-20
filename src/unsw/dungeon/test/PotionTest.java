package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;
import unsw.dungeon.Potion;
import unsw.dungeon.Dungeon;
import unsw.dungeon.Player;
import org.junit.jupiter.api.Test;

class PotionTest {

	@Test
	void addingPotion() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Potion invisPotion = new Potion(dungeon,11,11);
		System.out.println(dungeon.getPlayer());
		player1.moveDown();
		assertEquals(invisPotion.getX(),11);
		assertEquals(invisPotion.getY(),11);
		player1.moveRight();
		invisPotion.collect();
		
		System.out.println(invisPotion.getX());
		
		System.out.println(player1.getPotion());
//		System.out.println(invisPotion);
//		assertEquals(player1.getPotion(),invisPotion);
	}

}
