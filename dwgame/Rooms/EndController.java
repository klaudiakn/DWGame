
package dwgame.Rooms;

import java.net.URL;
import java.util.ResourceBundle;

import dwgame.CScreen;
import javafx.fxml.Initializable;

public class EndController implements Initializable, CScreen {

      RoomController myController;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setScreenParent(RoomController screenParent){
        myController = screenParent;
    }

   
    
}
