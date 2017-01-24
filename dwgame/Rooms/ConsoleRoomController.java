
package dwgame.Rooms;

import java.net.URL;
import java.util.ResourceBundle;

import dwgame.CScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class ConsoleRoomController implements Initializable, CScreen {

   RoomController myController;
    
    @Override
    public void setScreenParent(RoomController screenPage) {
        myController= screenPage;   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    @FXML
    public void buttonClick(ActionEvent event){
        myController.game.playAgain.setVisible(true);
    }
    

    
    
}
