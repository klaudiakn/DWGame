
package dwgame.Rooms;

import java.net.URL;
import java.util.ResourceBundle;

import dwgame.CScreen;
import dwgame.DWGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CorridorController implements Initializable , CScreen {

    RoomController myController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    
    public void setScreenParent(RoomController screenParent){
        myController = screenParent;
    }

    @FXML
    private void goToSwimmingPool(ActionEvent event){
       myController.setScreen(DWGame.swimmingPoolID);
    }
    
    @FXML
    private void goToLibrary(ActionEvent event){
       myController.setScreen(DWGame.libraryID);
    }
    
    @FXML
    private void goToWardrobe(ActionEvent event){
       myController.setScreen(DWGame.wardrobeID);
    }
}
