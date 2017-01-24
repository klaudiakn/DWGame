
package dwgame.Rooms;

import java.net.URL;
import java.util.ResourceBundle;

import dwgame.CScreen;
import dwgame.DWGame;
import dwgame.Entities.SonicScrewdriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CloisterRoomController implements Initializable, CScreen {

    RoomController myController;
    @FXML
    Button next, wrong1, wrong2, correct,examineB, pickB;
    @FXML
    TextField answer;
    @FXML
    PasswordField password;
    @FXML
    Label label;
    
    @Override
    public void setScreenParent(RoomController screenPage) {
        myController= screenPage;   
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //Zabranie czasu za nieodpowiednią odpowiedź 
    public void fail()
    {
        myController.game.player.takeTime();
        label.setText("That is uncorrect.Time's running out.");
    }
    

    //Jeśli gracz wprowadzi hasło do drzwi 
    @FXML
    public void passwordTyped(ActionEvent event)
    {
        //Jeśli gracz odgadnie hasło, pogratulowanie i przejście dalej
        if(password.getText().toLowerCase().equals("crimson, eleven, delight, petrichor") ) 
        {
            label.setText("That's correct! Click Next to continue.");
            examineB.setVisible(false);
            pickB.setVisible(false);
            next.setVisible(true);
        }
        else
            fail();
    }

    
    @FXML
    public void next(ActionEvent event){
        next.setVisible(false);
        answer.setVisible(true);
        label.setText("But there is no control panel. You try saying it at loud, but it doesn't work. What do you do? (Enter the answer below");
        password.setVisible(false);
        answer.setVisible(true);
    }
    
    @FXML
    public void examine(ActionEvent event){
        myController.game.player.takeTime();
        if(myController.game.player.myWeapon.getPowerLevel() < 1 )
        {
            label.setText("Your weapon doesn't have enough power. You waste your time!");
           
        }
        else
        {
            myController.game.player.myWeapon.examine();
            myController.game.player.updatePowerLevel();
            label.setText("You learn that the password is: Crimson, Eleven, Delight, Petrichor. Click Next to contiune.");
            next.setVisible(true);
            password.setVisible(false);
            examineB.setVisible(false);
            pickB.setVisible(false);
        }
    }
    @FXML
    public void answerTyped(ActionEvent evenet){
        if( answer.getText().toLowerCase().equals("think") ){
            label.setText("Yes. But what do you think of as 'petrichor'?? Select from images above.");
            
            wrong1.setVisible(true);
            wrong2.setVisible(true);
            correct.setVisible(true);
            answer.setVisible(false);
        }
        else
            fail();
    }
    
    @FXML
    public void wrong(ActionEvent event){
        fail();
    }
    
    @FXML
    public void correct(ActionEvent event){
        myController.setScreen(DWGame.engineID);
    }

    @FXML
    public void pick(ActionEvent event){
        myController.game.player.takeTime();
        if(myController.game.player.myWeapon instanceof SonicScrewdriver && myController.game.player.myWeapon.getPowerLevel() > 2 )
        {
            SonicScrewdriver mySonic= (SonicScrewdriver) myController.game.player.myWeapon;
            mySonic.lockPicking();
            myController.game.player.updatePowerLevel();
            label.setText("Unfortunately that doesn't work");
            
        }
        else
        {
            label.setText("Your weapon can't pick lock cause either its power is too low or it doesn't have feature of lock picking");
           
        }
    }
    
}
