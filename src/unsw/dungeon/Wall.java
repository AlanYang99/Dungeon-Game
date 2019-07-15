package unsw.dungeon;

public class Wall implements StaticEntity {
	
	private Dungeon dungeon;

    public Wall(Dungeon dungeon, int x, int y) {
        setup(x, y);
        this.dungeon = dungeon;
    }

}
