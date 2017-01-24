
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

public class ZooController implements Initializable, CScreen {

    dwgame.Rooms.RoomController myController;
    @FXML
    Label label;
    @FXML
    Button fire, ball, door, chop;
    
    @Override
    public void setScreenParent(dwgame.Rooms.RoomController screenPage) {
        myController= screenPage;   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    //Uderzenie dinozaura skutkuje jedynie zabraniem graczowi czasu 
    public void karateChopIt(ActionEvent event)
    {
        myController.game.player.takeTime();
        label.setText("The dinosaur didn't even notice your action. At least you didn't get him angry. Maybe try something else.");
        
    }
    
    @FXML
    public void throwBall(ActionEvent event)
    {
        myController.game.player.takeTime();
        label.setText("The dinosaur went after the ball like a dog! You have free way to the door.");
        fire.setVisible(false);
        chop.setVisible(false);
        ball.setVisible(false);
        door.setVisible(true);
    }
    
    @FXML
    public void door(ActionEvent event)
    {
        myController.setScreen(DWGame.corridor2ID);
    }
    
    @FXML
    //Strzał do dinozaura-> wystrzelenie z broni, zabranie czasu gracza i zabranie 5 pkt energii życiowej gracza 
    public void fire(ActionEvent event)
    {
        if(myController.game.player.myWeapon.getPowerLevel() < 5 )
        {
            label.setText("Your weapon doesn't have enough power to fire!");
        }
        else{
            myController.game.player.takeTime();
            myController.game.player.myWeapon.fire();
            myController.game.player.updatePowerLevel();
            label.setText("Dinosaur just got angry at you, started chasing you around the jungle. Your power energy gets lower!!");
            myController.game.player.changeLifeEnergy(5);
        }
            
            
    }
    
    

  
    
}
