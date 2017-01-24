
package dwgame.Rooms;

import java.net.URL;
import java.util.ResourceBundle;

import dwgame.CScreen;
import dwgame.DWGame;
import dwgame.Entities.TimeZombie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EyeController implements Initializable, CScreen {

   dwgame.Rooms.RoomController myController;
   @FXML 
   Button fireButton, fightButton, runButton, doorButton;
   @FXML 
   Label label;
   TimeZombie enemy;
    
    @Override
    public void setScreenParent(dwgame.Rooms.RoomController screenPage) {
        myController= screenPage;   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void fire(ActionEvent event){
        myController.game.player.takeTime();
        if( myController.game.player.myWeapon.getPowerLevel() >=5 )
        {
            label.setText(enemy.fightWithWeapon(myController.game.player) );
            victory();
        }
        else
        {
            label.setText("Your weapon doesn't have enough power!");
            
        }
        
    }
     //Sprawdza, czy gracz wygrał z TimeZombie, jeśli tak, chowa przyciski wcześniejszych wyborów i pokazuje przycisk drzwi do następnego pokoju
    public void victory()
    {
        if(enemy.death()){
            label.setText("You defeated Time Zombie! Now you have free passage to the next room. Go ahead.");
            doorButton.setVisible(true);
            fireButton.setVisible(false);
            fightButton.setVisible(false);
        }
    }
    
    @FXML 
    public void door(ActionEvent event){
        myController.setScreen(DWGame.cloisterID);
    }
    
    @FXML 
    public void fight(ActionEvent event){
        label.setText(enemy.fightByHand(myController.game.player));
        myController.game.player.takeTime();
        victory();
 
    }
    
    @FXML
    public void run(ActionEvent event){
        label.setText("You try to run away, but Time Zombie is blocking your way and hurts you. Your life power gets lower.");
        myController.game.player.takeTime();
        myController.game.player.changeLifeEnergy(3);
    }
    
    
}
