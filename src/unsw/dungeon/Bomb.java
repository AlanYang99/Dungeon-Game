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
		dungeon.getPlayer().addBomb(this);
		this.x() = null;
		this.y() = null;
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
    	if (item instanceof Switch) return true;
		return super.share(item);
    }

}
