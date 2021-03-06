package unsw.dungeon;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * A DungeonLoader that also creates the necessary ImageViews for the UI,
 * connects them via listeners to the model, and creates a controller.
 * @author Robert Clifton-Everest
 *
 */
public class DungeonControllerLoader extends DungeonLoader {

    private List<ImageView> entities;

    //Images
    private Image playerImage;
    private Image wallImage;
    private Image LitBomb1;
    private Image LitBomb2;
    private Image LitBomb3;

    private Image exitImage;
    private Image doorImage; // closed version
    private Image switchImage;
    private Image boulderImage;
    private Image enemyImage; // 3 variations
    private Image keyImage;
    private Image treasureImage;
    private Image bombImage; // unlit version
    private Image potionImage; // 2 variations
    private Image swordImage;

    public DungeonControllerLoader(String filename)
            throws FileNotFoundException {
        super(filename);
        entities = new ArrayList<>();
        playerImage = new Image("/human_new.png");
        wallImage = new Image("/brick_brown_0.png");
        exitImage = new Image("/exit.png");
        doorImage = new Image("/closed_door.png");
        switchImage = new Image("/pressure_plate.png");
        boulderImage = new Image("/boulder.png");
        enemyImage = new Image("/deep_elf_master_archer.png");
        keyImage = new Image ("/key.png");
        treasureImage = new Image("/gold_pile.png");
        bombImage = new Image("/bomb_unlit.png");
        potionImage = new Image("/brilliant_blue_new.png");
        swordImage = new Image("/greatsword_1_new.png");
        LitBomb1 = new Image("/bomb_lit_2.png");
        LitBomb2 = new Image("/bomb_lit_3.png");
        LitBomb3 = new Image("/bomb_lit_4.png");

    }

    @Override
    public void onLoad(Entity player) {
        ImageView view = new ImageView(playerImage);
        addEntity(player, view);
    }

    @Override
    public void onLoad(Wall wall) {
        ImageView view = new ImageView(wallImage);
        addEntity(wall, view);
    }
    
    @Override
	public void onLoad(Exit exit) {
    	ImageView view = new ImageView(exitImage);
        addEntity(exit, view);
	}

	@Override
	public void onLoad(Door door) {
		ImageView view = new ImageView(doorImage);
        addEntity(door, view);
	}

	@Override
	public void onLoad(Switch plate) {
		ImageView view = new ImageView(switchImage);
        addEntity(plate, view);
	}

	@Override
	public void onLoad(Boulder boulder) {
		ImageView view = new ImageView(boulderImage);
        addEntity(boulder, view);
	}

	@Override
	public void onLoad(Enemy enemy) {
		ImageView view = new ImageView(enemyImage);
        addEntity(enemy, view);
	}

	@Override
	public void onLoad(Key key) {
		ImageView view = new ImageView(keyImage);
        addEntity(key, view);
	}
	
	@Override
    public void onLoad(Treasure treasure) {
        ImageView view = new ImageView(treasureImage);
        addEntity(treasure, view);
    }

	@Override
	public void onLoad(Bomb bomb) {
		ImageView view = new ImageView(bombImage);
        addEntity(bomb, view);
	}

	@Override
	public void onLoad(Potion potion) {
		ImageView view = new ImageView(potionImage);
        addEntity(potion, view);
	}
	
	@Override
	public void onLoad(Sword sword) {
		ImageView view = new ImageView(swordImage);
        addEntity(sword, view);
	}

    private void addEntity(Entity entity, ImageView view) {
        trackPosition(entity, view);
        trackExist(entity,view); //Testing purposes
        if(entity.isBomb()) trackBombState((Bomb)entity,view);
        entities.add(view);
    }

    /**
     * Set a node in a GridPane to have its position track the position of an
     * entity in the dungeon.
     *
     * By connecting the model with the view in this way, the model requires no
     * knowledge of the view and changes to the position of entities in the
     * model will automatically be reflected in the view.
     * @param entity
     * @param node
     */
    

    private void trackBombState(Bomb bomb,Node node) {
    	bomb.getState().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable,
                        Number oldValue, Number newValue) {
                	
                	ImageView temp = (ImageView)node;
            		if(newValue.equals(2)) {
            			temp.setImage(LitBomb1);
            		} else if (newValue.equals(3)) {
                    	temp.setImage(LitBomb2);
            		} else if (newValue.equals(4)) {
                    	temp.setImage(LitBomb3);
            		}
                }
            });
    }
    
    private void trackExist(Entity sword, Node node) {
    	sword.getExist().addListener(new ChangeListener<Boolean>() {
    		@Override
            public void changed(ObservableValue<? extends Boolean> observable,
                    Boolean oldValue, Boolean newValue) {
//            	System.out.println("test2");
////    			node.prop
//    			GridPane.setColumnIndex(node, 0);
//    			GridPane.
    			if(sword.isKey() && oldValue == false) {
    		        GridPane.setColumnIndex(node, sword.getX());
    		        GridPane.setRowIndex(node, sword.getY());    				
					ImageView im = (ImageView) node;
					im.setImage(keyImage);    					
    			} else if (sword.isBomb() && oldValue == false){
    		        GridPane.setColumnIndex(node, sword.getX());
    		        GridPane.setRowIndex(node, sword.getY());
					ImageView im = (ImageView) node;
					im.setImage(bombImage);      		        
    			} else {
					ImageView im = (ImageView) node;
					im.setImage(null);
    			}
				
//    			GridPane.clearConstraints(node);
    			//Suggestions
    			//The trackposition method, adds all initial entities into
    			//the gridPane
    			//Hence if we colllect an item, we can reinitialise the entities list
    			//by making it empty and then adding the current existing 
    			//items into the list
    			//Have a list that contains all Entities, when collect
    			//remove that item from the entities list (above) line 22
    			//and then reinitalise the 
    			
//    			GridPane.setColumnIndex(node, -1);
//    			GridPane.setRowIndex(node, -1);

//                GridPane.setColumnIndex(node, newValue.booleanValue());
//                System.out.println(node);
//                GridPane.se
            }    		
    	});
    }
    private void trackPosition(Entity entity, Node node) {
        GridPane.setColumnIndex(node, entity.getX());
        GridPane.setRowIndex(node, entity.getY());
        
        entity.x().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                GridPane.setColumnIndex(node, newValue.intValue());
            }
        });
        entity.y().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                GridPane.setRowIndex(node, newValue.intValue());
            }
        });
    }

    /**
     * Create a controller that can be attached to the DungeonView with all the
     * loaded entities.
     * @return
     * @throws FileNotFoundException
     */
    public DungeonController loadController() throws FileNotFoundException {
        return new DungeonController(load(), entities);
    }


}
