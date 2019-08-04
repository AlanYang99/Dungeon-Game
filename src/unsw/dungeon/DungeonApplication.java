package unsw.dungeon;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

public class DungeonApplication extends Application {



    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Dungeon");
        
        DungeonControllerLoader dungeonLoader = new DungeonControllerLoader("advanced.json");

        DungeonController controller = dungeonLoader.loadController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DungeonView.fxml"));
        Button button = new Button("hi");
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        root.requestFocus();
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene1 = new Scene(layout,300,250);
        primaryStage.setScene(scene1);
        
        primaryStage.show();
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    

    public static void main(String[] args) {
        launch(args);
    }

}

