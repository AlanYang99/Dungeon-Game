package unsw.dungeon;

public abstract class ImmovableEntity extends Entity{
	
	public ImmovableEntity(Dungeon dungeon,int x, int y) {
		super(dungeon,x,y);
	}
	
	@Override
    public boolean share(Entity item) {
		if(item.isPlayer()) return true;
		return super.share(item);
    }
	
	@Override
	public boolean isImmovable() {
		return true;
	}
}
