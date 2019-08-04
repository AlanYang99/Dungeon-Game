package unsw.dungeon;

import java.util.ArrayList;
import java.util.List;

public class Treasure extends Collectibles {

	
	private List<Observer> observers;
	
    /**
     * Create a treasure positioned in square (x,y)
     * @param x
     * @param y
     */
    public Treasure(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
        observers = new ArrayList<Observer>();
    }

	@SuppressWarnings("null")
	@Override
	public boolean collect() {
		//give to player
		dungeon.getPlayer().addTreasures(this);

		setExist(false);

		// Update the treasure goal
		notifyObservers("TreasureCollected");
		
		return true;
	}
	
	@Override

    public boolean share(Entity item) {
		if(item.isSwitch()||item.isPlayer()) return true;
		return super.share(item);
    }
	
	@Override
	public boolean isTreasure() {
		return true;
	}


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
