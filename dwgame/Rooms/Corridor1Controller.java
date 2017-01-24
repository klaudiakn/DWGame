
package dwgame.Rooms;

import java.net.URL;
import java.util.ResourceBundle;

import dwgame.CScreen;
import dwgame.DWGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class Corridor1Controller implements Initializable, CScreen {

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
    public void jungle(ActionEvent event)
    {
        myController.setScreen(DWGame.zooID);
    }
    
    @FXML
    public void companionRoom(ActionEvent event)
    {
        myController.setScreen(DWGame.companionRoomID);
    }
    
    @FXML
    
    public void artGallery(ActionEvent event)
    {
        myController.setScreen(DWGame.artGalleryID);
    }

  
    
}
