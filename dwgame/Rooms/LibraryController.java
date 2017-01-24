
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

 // Starcie z TimeZombie, opcje do wyboru: schowanie się lub walka bronią 
public class LibraryController implements Initializable, CScreen {

    @FXML 
    Label label1;
    @FXML
    Button door1;
    @FXML
    Button fire1;
    @FXML
    Button wait1;
    
    RoomController myController;
    TimeZombie walker;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        walker=new TimeZombie();
        door1.setVisible(false);
       
    }    

    @Override
    public void setScreenParent(RoomController screenPage) {
        myController= screenPage;   
    }
    
    //Wybór strzału- wywołanie metody walki z potworem bronią 
    @FXML
    public void fire(ActionEvent event)
    {
         myController.game.player.takeTime();
        //Jeśli broń ma niewystarczającą ilość mocy, zabranie poziomu energii i czasu
            if (myController.game.player.myWeapon.getPowerLevel() < 5)
            {
                label1.setText("Your weapon doesn't have enough power to fire! You waste your time on trying to get it to work and the creature i hurting you. Your life power gets lower by 2.");
                myController.game.player.changeLifeEnergy(2);
                
            }
            else
            {
 
                label1.setText(walker.fightWithWeapon(myController.game.player));
                myController.game.player.updatePowerLevel();
                //Jeśli przeciwnik umiera wywołanie metody ukrycia przycisków wyboru akcji i pokazanie przycisku drzwi 
                if (walker.death())
                    this.hideButtons();
                    
            }
    }
    
    @FXML
    public void door(ActionEvent event)
    {
        myController.setScreen(DWGame.corridor1ID);
    }
    
     //Wybó czekania skutkuje zabraniem czasu, ale wolnym przejściem do drzwi do następnego pokoju 
    @FXML
    public void wait(ActionEvent event)
    {
         myController.game.player.takeTime();
        label1.setText("You hide behind one of bookstands and wait till the creature is gone. You loose time, but have free passage to the door.");
        myController.game.player.takeTime();
        this.hideButtons();
    }
    
    //Ukrywa przyciski wystrzału i czekania, pokazuje przycisk z drzwiami 
    private void hideButtons()
    {
        fire1.setVisible(false);
        wait1.setVisible(false);
        door1.setVisible(true);
    }
    
}
