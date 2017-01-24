
package dwgame.Rooms;

import java.util.HashMap;

import dwgame.CScreen;
import dwgame.DWGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.scene.layout.StackPane;


public class RoomController  extends StackPane {
    
    //HashMapa do przechowywania ekranów, które będą wyświetlane jako kolejne pokoje
    private HashMap<String, Node> screens = new HashMap<>();
    public DWGame game;
    
    public RoomController(DWGame g) {
        super();
        this.game=g;
    }

    //Dodanie ekranu/pokoju do HashMapy
    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }

    public Node getScreen(String name) {
        return screens.get(name);
    }
    //Załadowanie ekranu o podanym imieniu i pliku fxml 
    public boolean loadScreen(String name, String resource) {
        try {
            //Władowanie pliku fxml 
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();   
            CScreen myScreenControler = ((CScreen) myLoader.getController());
            myScreenControler.setScreenParent(this);
            //Dodanie ekranu do HashMapy
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //Wyświetlenie ekranu o podanej nazwie
    public boolean setScreen(final String name) {       
         Node screenToRemove;
         if(screens.get(name) != null){   //czy ekran władowany do HashMapy
         if(!getChildren().isEmpty()){    //jeśli to nie jest pierwszy ekran, jaki jest wyświetlany 
         getChildren().add(0, screens.get(name));     //wyświetlenie ekranu 
         screenToRemove = getChildren().get(1);      //poprzedni ekran 
         getChildren().remove(1);                    //usuniecie poprzedniego wyświetlanego
         }else{
         getChildren().add(screens.get(name));   //to pierwszy ekran, jaki jest wyświetlany
         }
         return true;
         }else { //jeśli w kolekcji nie ma ekranu o podanej nazwie 
         System.out.println("screen hasn't been loaded!!! \n");
         return false;
         }
    }
}

