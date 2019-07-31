package unsw.dungeon;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
public abstract class Collectibles extends Entity {
	
	private BooleanProperty Exist;

	public Collectibles(Dungeon dungeon,int x, int y) {
		super(dungeon,x,y);
		Exist = new SimpleBooleanProperty(true);
	}
	
	public abstract boolean collect();
	
    public BooleanProperty getExist() {
    	return Exist;
    }
    
    public void setExist(Boolean state) {
    	Exist.set(state);
    }
	
	@Override
    public boolean share(Entity item) {
		if(item.isSwitch()||item.isPlayer()) return true;
		return super.share(item);
    }
	
}
