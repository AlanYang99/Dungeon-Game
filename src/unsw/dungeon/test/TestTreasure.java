package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;
import unsw.dungeon.Treasure;
import unsw.dungeon.Player;
import unsw.dungeon.Dungeon;
import org.junit.jupiter.api.Test;

class TestTreasure {

	@Test
	void collectTreasure() {
		Dungeon dungeon = new Dungeon(20,20);
		Player player1 = new Player(dungeon,10,10);
		Treasure gold = new Treasure(dungeon,10,11);
		assertEquals(player1.getNumTreasures(),0);		
		gold.collect();
		assertEquals(player1.getNumTreasures(),1);
	}

}
