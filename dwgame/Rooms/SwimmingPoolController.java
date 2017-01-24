
package dwgame.Rooms;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import dwgame.CScreen;
import dwgame.DWGame;
import dwgame.Entities.Ship;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/// W tym pokoju jednowymiarowa gra w statki: 3 masztowy statek na planszy 10 pól. Każdy zły strzał zabiera graczowi czas. 
public class SwimmingPoolController implements Initializable, CScreen {
 
    dwgame.Rooms.RoomController myController;
    @FXML
     Label label;
    @FXML
    Button play;
    @FXML
    TextField shoot;
    
    //Informacja o wyniku strzału
     String info;
     Ship s;
    // Czy było strzelane w dane miejsce już
    private boolean[] wasShot = new boolean[10];
    
    @Override
    public void setScreenParent(dwgame.Rooms.RoomController screenPage) {
        myController= screenPage;   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    //Przygotowanie gry w statki
    private Ship prepareGame(){
            s = new Ship();
            Random x = new Random();
            //Wylosowanie pozycji i ustawienie jej 
            int pos = x.nextInt(7);
            int[] a = { pos, pos + 1, pos + 2 };
            s.setPosition(a);
            return s;
        }
    
    @FXML
    //Rozpoczęcie gry
    public void play(ActionEvent event)
    {
        myController.game.player.takeTime();
        play.setVisible(false);
        shoot.setVisible(true);
        Ship ship= prepareGame();
        label.setText("Where should i shoot? Write number from 0 to 9 in the textField below");
        info="";
        
    }
    
   public void shoot(ActionEvent event)
   {
       String wp = shoot.getText();
            if (wp.equals(""))
                return;
            //Nieprawidłowo wprowadzone dane, liczba nie z podanego zakresu.
            if (Integer.parseInt(wp) > 9 || Integer.parseInt(wp) < 0)
            {
                label.setText("A NUMBER FROM 0 TO 9!");
                myController.game.player.takeTime();
                return;
            }
                
            //Jeśli statek nie jest jeszcze zatopiony 
            if (!"sunk".equals(info))
            {
                
                
                //Jeśli jeszcze w to pole nie strzelano 
                if (wasShot[Integer.parseInt(wp)] == false)
                {
                    wasShot[Integer.parseInt(wp)] = true;
                    //Strzał, zwraca infromacje o jego wyniku 
                    info = s.check(wp);
                    //Jeśli zły strzał, zabranie graczowi czasu 
                    if (info.equals("mishit"))
                        myController.game.player.takeTime();
                    //Jeśli statek zatopiony, przejście do korytarza1
                    if (info.equals("sunk"))
                        myController.setScreen(DWGame.corridor1ID);
                    //Wyświetlenie w texBlocku wyniku strzału 
                    label.setText(info);
                }
                //Jeśli gracz strzela w miejsce, w które już strzelał, zabranie czasu i wyświetlenie komunikatu 
                else
                {
                    myController.game.player.takeTime();
                    label.setText("Don't shoot in the same position couple times!");
                }

            }
   }
    

  
    
}
