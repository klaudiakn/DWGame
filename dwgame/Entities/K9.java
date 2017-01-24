
package dwgame.Entities;

import dwgame.DWGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class K9 extends Weapon {
    DWGame game;
    
    //Posiadanie K9 umożliwia wyświetlenie mapy 
    public K9(DWGame g)
    {
        super();
        this.game=g;
        game.showMap.setVisible(true);
        //Pokazanie mapy-> pokazanie przycisku do ukrycia mapy, schowanie przycisku pokazania mapy
        game.showMap.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
            game.map.setVisible(true);
            game.showMap.setVisible(false);
            game.hideMap.setVisible(true);
        }
    });
         //Schowanie mapy, pokazanie przycisku do pokazania mapy, schowanie przycisku do schowania.
        game.hideMap.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
             game.map.setVisible(false);
            game.hideMap.setVisible(false);
            game.showMap.setVisible(true);
        }
    });

    }
    
    
    
}
