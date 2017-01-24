
package dwgame.Rooms;

import java.net.URL;
import java.util.ResourceBundle;

import dwgame.CScreen;
import dwgame.DWGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ArtGalleryController implements Initializable, CScreen {

   RoomController myController;
   @FXML
   Button venus;
  
    
    @Override
    public void setScreenParent(RoomController screenPage) {
        myController= screenPage;   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }  
    
    @FXML
    public void secretPassage(ActionEvent event)
    {
        myController.setScreen(DWGame.cloisterID);
    }
    
    @FXML
    public void door(ActionEvent event)
    {
        myController.setScreen(DWGame.corridor2ID);
    }
    
    
    

    
    
}
