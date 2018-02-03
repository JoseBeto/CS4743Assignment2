package assignment1;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/* CS 4743 Assignment 1 by Jose Bocanegra */

public class Launcher extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
		Scene scene = new Scene(root);

		primaryStage.setTitle("assignment1");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
