
package dwgame.Rooms;

import java.net.URL;
import java.util.ResourceBundle;

import dwgame.CScreen;
import dwgame.DWGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
public class StartController implements Initializable, CScreen {

    dwgame.Rooms.RoomController myController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setScreenParent(dwgame.Rooms.RoomController screenParent){
        myController = screenParent;
    }

    @FXML
    private void play(ActionEvent event){
       myController.setScreen(DWGame.corridorID);
    }
    
 
}
