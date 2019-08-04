package unsw.dungeon.enemyStates;

import java.util.List;

import unsw.dungeon.*;

public class enemyDefending implements MovementBehaviour {
	
	public void move(Player player, Enemy me) {
		Dungeon dungeon = player.getDungeon();
		int width = dungeon.getWidth();
		int height = dungeon.getHeight();
		
		int[][] distMap = new int[width][height];
		
		int bigNum = 1000000;
		// Convert entities you can walk through to 0 and entities you cannot to -1.
		for (int x=0;x<width;x++) {
			for (int y=0;y<height;y++) {
				List<Entity> entities = dungeon.getEntities(x, y);
				
				boolean walkable = true;
				for (Entity e : entities) {
					walkable = walkable && me.share(e);
				}
				
				if (walkable)
					distMap[x][y] = bigNum;
				else
					distMap[x][y] = -1;
			}
		}
		
		int pX = player.getX();
		int pY = player.getY();
		
		fill(pX, pY, 0, player, distMap);
		
		int eX = me.getX();
		int eY = me.getY();
		
		int[] neighbours = new int[4];
		neighbours[0] = distMap[eX][eY+1];
		neighbours[1] = distMap[eX][eY-1];
		neighbours[2] = distMap[eX+1][eY];
		neighbours[3] = distMap[eX-1][eY];
		
		int max = -1;
		int maxI = -1;
		for (int i=0;i<4;i++) {
			if (neighbours[i] != -1 &&  neighbours[i] > max && neighbours[i] != bigNum ) {
				max = neighbours[i];
				maxI = i;
			}
		}
		
		switch (maxI) {
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
	
	public void fill(int x, int y, int oldVal, Player player, int[][] map) {
		int width = player.getDungeon().getWidth();
		int height = player.getDungeon().getHeight();
		
		if (map[x][y] == -1) return;
		if (oldVal+1 >= map[x][y]) return;
		
		map[x][y] = oldVal+1;
		
		if (y+1 <= height-1) 
			fill(x, y+1, oldVal+1, player, map);
		if (y-1 >= 0)
			fill(x, y-1, oldVal+1, player, map);
		if (x+1 <= width-1)
			fill(x+1, y, oldVal+1, player, map);
		if (x-1 >= 0)
			fill(x-1, y, oldVal+1, player, map);
		
	}

	@Override
	public void toggleState(Enemy enemy) {
		enemy.setState(new enemyAttacking());
	}
	
	public void printMap(int[][] map) {
		for (int y=0;y<map[0].length;y++) {
			for (int x=0;x<map.length;x++) {
				System.out.print(map[x][y] + " ");
			}
			System.out.println();
		}
	}
	
}