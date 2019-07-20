package unsw.dungeon;

public class Bomb extends Entity { 

    /**
     * Create an bomb positioned in square (x,y)
     * @param x
     * @param y
     */
    public Bomb(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }

	@Override
	public boolean collect() {
		//give to player
		dungeon.getPlayer().addBomb(this);
		// remove from dungeon map
		dungeon.getMap()[getX()][getY()].remove(this);
		// set entity coordinates to null
		setX(-1);
		setY(-1);
		return true;
	}
	
	@Override
	public boolean use() {
		if (dungeon.getPlayer().getNumBombs() == 0) return false;
		// TODO
		return true;
	}

	@Override
    public boolean share(Entity item) {
    	if (item instanceof Switch || item instanceof Player) return true;
		return super.share(item);
    }

}
