package controleur;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * classe controleurTp1 , entrée de l application
 * 
 * @author CORENTIN NGAKO
 *
 */
public class controleurTp1 extends Application {
	private AnchorPane root;
	private Scene scene;

	/**
	 * on charge le fichier FXML générer par SceneBuilder
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = FXMLLoader.load(getClass().getClassLoader().getResource("FXMLDocument.fxml"));
		scene = new Scene(root);
		primaryStage.setTitle("TP1 Programmation reseau");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}