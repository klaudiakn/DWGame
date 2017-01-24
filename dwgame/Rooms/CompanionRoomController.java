
package dwgame.Rooms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

import dwgame.CScreen;
import dwgame.DWGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class CompanionRoomController implements Initializable, CScreen {

   RoomController myController;
   @FXML
   ListView companions, answer;
   @FXML 
   Button select, delete;
   ObservableList names, namesSelected, correctAnswer;
   @FXML
   Label label;
    
    @Override
    public void setScreenParent(RoomController screenPage) {
        myController= screenPage;   
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        names=FXCollections.observableArrayList();
        namesSelected=FXCollections.observableArrayList();
        correctAnswer=FXCollections.observableArrayList();
        try{
            FileReader fr=new FileReader("src\\dwgame\\companions.txt");
            BufferedReader bfr= new BufferedReader(fr);
            String line="";
            while( (line=bfr.readLine())!=null){
                names.add(line);
            }
            fr.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            FileReader fr1=new FileReader("src\\dwgame\\answerCompanions.txt");
            BufferedReader bfr= new BufferedReader(fr1);
            String line="";
            while( (line=bfr.readLine())!=null){
                correctAnswer.add(line);
            }
            fr1.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        companions.setItems(names);
     
    }   
    
    @FXML
    public void deleteName(ActionEvent event)
    {
        namesSelected.remove(answer.getSelectionModel().getSelectedItem());
        answer.setItems(namesSelected);
    }
    
    @FXML
    public void select(ActionEvent event)
    {
        namesSelected.add(companions.getSelectionModel().getSelectedItem());
        answer.setItems(namesSelected);
    }
    

    
    @FXML
    public void confirm(ActionEvent event)
    {
        if(namesSelected.equals(correctAnswer) )
        {
            myController.setScreen(DWGame.corridor2ID);
        }
        else
        {
            myController.game.player.takeTime();
            label.setText("That is uncorrect!");
            
        }
    }
    
   

   
    
}
