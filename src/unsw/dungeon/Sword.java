package unsw.dungeon;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Sword extends Entity {
	private static final int HITS = 5;
	private int hits; // hits remaining
	
	private BooleanProperty Exist;

	/**
     * Create an sword positioned in square (x,y)
     * @param x
     * @param y
     */
    public Sword(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        hits = HITS;
        Exist = new SimpleBooleanProperty(true);
    }
    
    public BooleanProperty getExist() {
    	return Exist;
    }
    
	
    public int getHits() {
		return hits;
	}

	@Override
	public boolean collect() {
//		System.out.println("hi");
		// check player isn't already holding a sword
		if (dungeon.getPlayer().getSword() != null) return false;
//		System.out.println(dungeon.getPlayer().getSword());
		
		//give to player
		dungeon.getPlayer().setSword(this);
		System.out.println(Exist);
		Exist.set(false);
		System.out.println(Exist);
//		System.out.println(dungeon.getPlayer().getSword());
		// remove from dungeon map
//		dungeon.getMap()[getX()][getY()].remove(this);
		// set entity coordinates to null
//		setX(-1);
//		setY(-1);
		return true;
	}
	
	@Override
	/**
     * @inv		If player has a sword, hits remaining is > 0
     */
	public boolean use() {
		if(dungeon.getPlayer().getSword() == null) return false;
		
		hits --;
		if (hits == 0) dungeon.getPlayer().setSword(null);
		return true;
	}
	
//	@Override
//    public boolean share(Entity item) {
//    	if (item instanceof Player || item instanceof Switch) return true;
//		return super.share(item);
//    }

}
