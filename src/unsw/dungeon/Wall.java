package unsw.dungeon;

public class Wall extends ImmovableEntity {

    public Wall(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }
    
    @Override
    public boolean share(Entity Item) {
    	return false;
    }
}
