package unsw.dungeon;

public class Bomb extends StaticEntity { 

    /**
     * Create an bomb positioned in square (x,y)
     * @param x
     * @param y
     */
    public Bomb(Dungeon dungeon, int x, int y) {
        super(dungeon, x, y);
    }
    
    @Override
    public void setState(State state) {
    	//TODO
    }

}
