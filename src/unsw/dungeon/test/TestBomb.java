package unsw.dungeon.test;

import static org.junit.jupiter.api.Assertions.*;
import unsw.dungeon.Bomb;
import unsw.dungeon.Player;
import unsw.dungeon.Dungeon;
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

}
