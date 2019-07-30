package unsw.dungeon;

public abstract class Collectibles extends Entity {
	
	public Collectibles(Dungeon dungeon,int x, int y) {
		super(dungeon,x,y);
	}
	
	@Override
    public boolean share(Entity item) {
		if(item.isSwitch()||item.isPlayer()) return true;
		return super.share(item);
    }
}
