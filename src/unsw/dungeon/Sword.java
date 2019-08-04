package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Sword extends Collectibles {
	private static final int HITS = 5;
	private int hits; // hits remaining
	private List<Observer> observers;
	
	/**
     * Create an sword positioned in square (x,y)
     * @param x
     * @param y
     */
    public Sword(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        observers = new ArrayList<Observer>();
        hits = HITS;
    }
	
    public int getHits() {
		return hits;
	}

	@Override
	public boolean collect() {
		// check player isn't already holding a sword
		if (dungeon.getPlayer().getSword() != null) return false;
		//give to player
		dungeon.getPlayer().setSword(this);
		setExist(false);

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
	
	@Override
	public void attach(Observer o) {
		observers.add(o);
	}
	
	@Override
	public void notifyObservers(String tag) {
		if (observers == null) return;
		for (Observer o : observers) {
			o.update(this, tag);
		}
	}
	
	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}

}
