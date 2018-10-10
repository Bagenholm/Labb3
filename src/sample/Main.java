package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // TODO: 1. GUI Interface design
    // TODO: - For shapes: buttons to choose shape, menu for color, input boxes for width and height
    // TODO: - Draw and select buttons
    // TODO: - Save and load buttons
    // TODO: - Clear canvas button
    // TODO:

    // TODO: 2. Canvas interaction
    // TODO: - Drawing shapes with click
    // TODO: - Selecting shapes with click
    // TODO: -


    // TODO: 3. File management
    // TODO: - Saving and loading SVG
    // TODO: - Saving and loading bitmap

    // TODO: 4. Undo and redo
    // TODO: -

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
