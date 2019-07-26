package unsw.dungeon.enemyStates;

import java.util.List;

import unsw.dungeon.*;

public class enemyAttacking implements MovementBehaviour {
	
	public void move(Player player, Enemy me) {
		Dungeon dungeon = player.getDungeon();
		int width = dungeon.getWidth();
		int height = dungeon.getHeight();
		
		int[][] distMap = new int[width][height];
		
		// Convert entities you can walk through to 0 and entities you cannot to -1.
		for (int x=0;x<width;x++) {
			for (int y=0;y<height;y++) {
				List<Entity> entities = dungeon.getEntities(x, y);
				
				boolean walkable = true;
				for (Entity e : entities) {
					walkable = walkable && me.share(e);
				}
				
				if (walkable)
					distMap[x][y] = 0;
				else
					distMap[x][y] = -1;
			}
		}
		
		int pX = player.getX();
		int pY = player.getY();
		
		fill(pX, pY, 0, me, player, distMap);
		
		int eX = me.getX();
		int eY = me.getY();
		
		int[] neighbours = new int[4];
		neighbours[0] = distMap[eX][eY+1];
		neighbours[1] = distMap[eX][eY-1];
		neighbours[2] = distMap[eX+1][eY];
		neighbours[3] = distMap[eX-1][eY];
		
		int min = neighbours[0];
		int minI = 0;
		for (int i=1;i<4;i++) {
			if (neighbours[i] < min) {
				min = neighbours[i];
				minI = i;
			}
		}
		
		switch (minI) {
		case 0:
			me.moveDown();
			break;
		case 1:
			me.moveUp();
			break;
		case 2:
			me.moveRight();
			break;
		case 3:
			me.moveLeft();
			break;
		}
		
	}
	
	public void fill(int x, int y, int oldVal, Enemy me, Player player, int[][] map) {
		int width = player.getDungeon().getWidth();
		int height = player.getDungeon().getHeight();
		
		if (map[x][y] == -1) return;
		if (x == player.getX() && y == player.getY() && oldVal != 0) return;
		
		boolean alreadyPlaced = false;
		if (map[x][y] > 0) alreadyPlaced = true;
		
		//if (map[x][y] != 0 && map[x][y] < oldVal + 1)
		
		if (map[x][y] == 0 || map[x][y] >= oldVal + 1) {
			map[x][y] = oldVal + 1;
		}
		
		int val = map[x][y];
		
		if (alreadyPlaced) return;
		if (x == me.getX() && y == me.getY()) return;
		
		if (y+1 <= height-1) 
			fill(x, y+1, val, me, player, map);
		if (y-1 >= 0)
			fill(x, y-1, val, me, player, map);
		if (x+1 <= width-1)
			fill(x+1, y, val, me, player, map);
		if (x-1 >= 0)
			fill(x-1, y, val, me, player, map);
		
	}

	@Override
	public void toggleState(Enemy enemy) {
		enemy.setState(new enemyDefending());
	}
	
}