package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;
import unsw.dungeon.Player;
import unsw.dungeon.Sword;
import unsw.dungeon.Dungeon;

import org.junit.jupiter.api.Test;

class TestSword {

	@Test
	void useSword() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Sword infinitySword = new Sword(dungeon,10,11);		
		player1.setSword(infinitySword);
		assertNotEquals(player1.getSword(),null);
		player1.getSword().use();
		assertEquals(player1.getSword().getHits(),4);
		player1.getSword().use();
		player1.getSword().use();
		player1.getSword().use();
		
		assertEquals(player1.getSword().getHits(),1);
		assertEquals(player1.getSword().use(),true);	
		assertEquals(player1.getSword(),null);
	}

}