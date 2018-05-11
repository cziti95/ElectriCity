package homework;

import java.io.IOException;
import java.util.Optional;
import homework.view.GameController;
import homework.view.MainMenuController;
import homework.view.RulesController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

/**
 * Az alkalmazás főosztálya.
 * 
 * @author czirjak
 *
 */
public class MainApp extends Application {

	/**
	 * Az aktuális stage.
	 */
	private Stage primaryStage = new Stage();
	/**
	 * Az "alap".
	 */
	private BorderPane root = new BorderPane();

	/**
	 * @param args - bemeneti argumentumok
	 */
	public static void main(String[] args) {
		launch(args);
		Logger.info("Alkalmazás elindítva");
	}

	/**
	 * JavaFX-hez szükséges start metódus.
	 * @param primaryStage - az aktuális stage.
	 * @throws Exception - bármilyen hiba esetén
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ElectriCity");

		initRootLayout();

		showMainMenu();

	}

	/**
	 * Beállítja az alaprajzot.
	 */
	public void initRootLayout() {
		try {

			FXMLLoader loader = new FXMLLoader(MainApp.class.getClassLoader().getResource("view/RootLayout.fxml"));
			//loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			root = loader.load();

			Scene rootScene = new Scene(root);
			primaryStage.setScene(rootScene);
			primaryStage.setResizable(false);
			primaryStage.centerOnScreen();
			primaryStage.show();
			primaryStage.setOnCloseRequest(e -> {
				e.consume();
				closeProgram();
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Mutatja a főmenüt.
	 */
	public void showMainMenu() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getClassLoader().getResource("view/MainMenu.fxml"));
			AnchorPane mainMenu = (AnchorPane) loader.load();

			root.setCenter(mainMenu);

			MainMenuController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Mutatja a játékot.
	 */
	public void showGame() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getClassLoader().getResource("view/Game.fxml"));
			AnchorPane game = loader.load();

			root.setCenter(game);

			GameController controller = loader.getController();
			controller.setMainApp(this);
			controller.startGame();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Mutatja a szabályzatot.
	 */
	public void showRules() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getClassLoader().getResource("view/Rules.fxml"));
			AnchorPane rules = (AnchorPane) loader.load();

			root.setCenter(rules);

			RulesController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @return az elsődleges "színpadot"
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	/**
	 * Figyelmeztetés a program bezárásával kapcsolatban.
	 */
	public void closeProgram() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Figyelmeztetés");
		alert.setHeaderText("Biztos ki akarsz lépni?");
		alert.setContentText("A játék nem tartalmaz automatikus mentést.");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			this.primaryStage.close();
		}
	}

}
