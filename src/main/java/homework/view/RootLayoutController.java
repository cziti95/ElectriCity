package homework.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Kontroller osztály a gyökérelemhez.
 * 
 * @author czirjak
 *
 */
public class RootLayoutController {

    /**
     * Kezeli a bezárás menüpontot.
     */
    @FXML
    private void handleClose(){
    	System.exit(0);
    }
    
    /**
     * Kezeli a "a játékról" menüpontot.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Információ");
        alert.setHeaderText("Programozási környezetek beadandó.");
        alert.setContentText("Készítette: Czirják Tibor");

        alert.showAndWait();
    }
}
