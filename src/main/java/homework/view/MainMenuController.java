package homework.view;

import java.util.Optional;

import homework.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

/**
 * Kontroller osztály a főmenühöz.
 * 
 * @author czirjak
 *
 */
public class MainMenuController {

	/**
	 * Új játék gomb.
	 */
	@FXML
	private Button newGame;

	/**
	 * Szabályzat gomb.
	 */
	@FXML
	private Button Rules;

	/**
	 * Kilépő gomb.
	 */
	@FXML
	private Button Exit;

	/**
	 * A főosztály.
	 */
	private MainApp mainApp;

	/**
	 * Inicializálja a kontroller osztályt.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Konstruktor az osztályhoz.
	 */
	public MainMenuController() {
		super();
	}

	/**
	 * A fő alkalmazás felhívja a referenciát önmagára.
	 * 
	 * @param mainApp - beállítja a főalkalmazást
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Kezeli az új játék menüpontot.
	 */
	@FXML
	public void handleNewGame() {
		mainApp.showGame();
	}

	/**
	 * Kezeli a szabályzat menüpontot.
	 */
	@FXML
	public void handleRulesButton() {
		mainApp.showRules();
	}

	/**
	 * Kezeli a kilépést.
	 */
	@FXML
	public void handleExitButton() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Figyelmeztetés");
		alert.setHeaderText("Biztos ki akarsz lépni?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			mainApp.getPrimaryStage().close();
		}
	}
}
