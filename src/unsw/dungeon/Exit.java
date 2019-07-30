package unsw.dungeon;

public class Exit extends ImmovableEntity {


    /**
     * Create an exit positioned in square (x,y)
     * @param x
     * @param y
     */
    public Exit(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }
    
//	@Override
//    public boolean share(Entity item) {
//    	if (item instanceof Player) return true;
//		return super.share(item);
//    }

}
