package homework.view;

import homework.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Kontroller osztály a szabályzat menüponthoz.
 * 
 * @author czirjak
 *
 */
public class RulesController {

	/**
	 * Visszalépő gomb.
	 */
	@FXML
	private Button back;

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
	 * Az osztály konstruktora.
	 */
	public RulesController() {
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
	 * Kezeli a "vissza" gombot.
	 */
	@FXML
	public void handleBackButton(){
		mainApp.showMainMenu();
	}
    
    
}
