
package dwgame.Rooms;

import java.net.URL;
import java.util.ResourceBundle;

import dwgame.CScreen;
import dwgame.DWGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class WardrobeController implements Initializable, CScreen {

    dwgame.Rooms.RoomController myController;
    @FXML
    Button yes, no, door, look;
    @FXML
    Label label;
    
    @Override
    public void setScreenParent(dwgame.Rooms.RoomController screenPage) {
        myController= screenPage;   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void lookAround(ActionEvent event)
    {
        look.setVisible(false);
        door.setVisible(false);
        myController.game.player.takeTime();
        label.setText("As you're going through rather weird collection of clothes,you discover K9 hidden behind long brown coat. You now can have him as your companion. Do you want to take him with you??");
        yes.setVisible(true);
        no.setVisible(true);
    }
    
    @FXML
    public void door(ActionEvent event)
    {
        myController.game.player.takeTime();
        myController.setScreen(DWGame.corridor1ID);
    }
    
    @FXML
    public void yes(ActionEvent event)
    {
        myController.game.player.changeWeaponToK9();
        myController.setScreen(DWGame.corridor1ID);
    }
    
    

    
    
}
