
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
import javafx.scene.control.TextField;

public class EngineController implements Initializable, CScreen {

   RoomController myController;
   @FXML
   Button jumpButton, examineButton;
   @FXML
   Label label1, label2;
   @FXML 
   TextField answer;
    
    @Override
    public void setScreenParent(RoomController screenPage) {
        myController= screenPage;   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     //Zbadanie przepaści skutkuje zabraniem czasu i uzyskaniem podpowiedzi, że przejście do silnika wymaga skoczenia w przepaść    
    @FXML
    public void examine(ActionEvent event){
       label1.setText("The abyss is a cloaking system. In order to get to the engine, you must jump into it.");
       myController.game.player.takeTime();
       myController.game.player.myWeapon.examine();
       myController.game.player.updatePowerLevel();
       examineButton.setVisible(false);
    }
    
     //Skoczenie w przepaść-> przeniesienie do prawdziwego silnika
    @FXML
    public void jump(ActionEvent event){
        label1.setVisible(false);
        examineButton.setVisible(false);
        jumpButton.setVisible(false);
        label2.setVisible(true);
        answer.setVisible(true);
        
    }
    
    @FXML
    public void answerTyped(ActionEvent event){
        if(answer.getText().toLowerCase().equals("music")){
            myController.setScreen(DWGame.consoleID);
        }
        else
            label2.setText("That is not the correct answer. Think! Time's running out.");
        
    }
    
}
