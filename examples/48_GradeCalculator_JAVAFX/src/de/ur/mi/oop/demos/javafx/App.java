package de.ur.mi.oop.demos.javafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	private static final String STAGE_TITLE = "OOP Notenrechner";
	private static final String FXML_PATH = "./fxml/javafx_layout.fxml";
	
	@Override
	public void start(Stage stage) {
		initApplication(stage);
	}
	
	private void initApplication(Stage stage) {
		Scene scene = loadScene();
		stage.setTitle(STAGE_TITLE);
        stage.setScene(scene);
        stage.show();
	}

	private Scene loadScene() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource(FXML_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
        return new Scene(root, WIDTH, HEIGHT);
	}
	
}
