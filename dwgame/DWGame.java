
package dwgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;



public class DWGame extends Application {
    
    //Zmienne na nazwy i pliki fxml poszczególnych pokoi 
    public static String startID = "main";
    public static String startFile = "Start.fxml";
    public static String corridorID = "corridor";
    public static String corridor = "Corridor.fxml";
    public static String libraryID= "library";
    public static String libraryFile="Library.fxml";
    public static String endID="end";
    public static String endFile="End.fxml";
    public static String playScreenID="main";
    public static String library= "Library.fxml";
    public static String swimmingPool= "SwimmingPool.fxml";
    public static String wardrobe= "Wardrobe.fxml";
    public static String corridor1= "Corridor1.fxml";
    public static String eye= "Eye.fxml";
    public static String cloister= "CloisterRoom.fxml";
    public static String corridor2= "Corridor2.fxml";
    public static String artGallery= "ArtGallery.fxml";
    public static String zoo= "Zoo.fxml";
    public static String companionRoom= "CompanionRoom.fxml";
    public static String engine= "Engine.fxml";
    public static String console= "ConsoleRoom.fxml";
    public static String swimmingPoolID= "SwimmingPool";
    public static String wardrobeID= "Wardrobe";
    public static String corridor1ID= "Corridor1";
    public static String eyeID= "Eye";
    public static String cloisterID= "CloisterRoom";
    public static String corridor2ID= "Corridor2";
    public static String artGalleryID= "ArtGallery";
    public static String zooID= "Zoo";
    public static String companionRoomID= "CompanionRoom";
    public static String engineID= "Engine";
    public static String consoleID= "ConsoleRoom";
    //Komponenty stałe, odpowiadające stanowi gry
    public VBox levels; 
    public Button showMap;
    public Button hideMap;
    public Label lifeEnergy;
    public Label powerLevel;
    public Label weaponType;
    public ImageView map;
    public Label time;
    public Label communique;
    public Player player;
    public Button playAgain;
    
    //Kontroler
    dwgame.Rooms.RoomController mainContainer;
    
    @Override
    public void start(Stage primaryStage) {
        
        mainContainer= new dwgame.Rooms.RoomController(this);
        //Załadowanie wszystkich ekranów do kontrolera
        mainContainer.loadScreen(DWGame.startID, DWGame.startFile);
        mainContainer.loadScreen(DWGame.libraryID, DWGame.libraryFile);
        mainContainer.loadScreen(DWGame.corridorID, DWGame.corridor);
        mainContainer.loadScreen(DWGame.swimmingPoolID, DWGame.swimmingPool);
        mainContainer.loadScreen(DWGame.wardrobeID, DWGame.wardrobe);
        mainContainer.loadScreen(DWGame.corridor1ID, DWGame.corridor1);
        mainContainer.loadScreen(DWGame.eyeID, DWGame.eye);
        mainContainer.loadScreen(DWGame.zooID, DWGame.zoo);
        mainContainer.loadScreen(DWGame.companionRoomID, DWGame.companionRoom);
        mainContainer.loadScreen(DWGame.engineID, DWGame.engine);
        mainContainer.loadScreen(DWGame.consoleID, DWGame.console);
        mainContainer.loadScreen(DWGame.artGalleryID, DWGame.artGallery);
        mainContainer.loadScreen(DWGame.corridor2ID, DWGame.corridor2);
        mainContainer.loadScreen(DWGame.cloisterID, DWGame.cloister);
        mainContainer.loadScreen(DWGame.endID, DWGame.endFile);
        mainContainer.setScreen(DWGame.startID);
        //Ustawienie przycisków stałych 
        setLevels();
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        root.getChildren().addAll(levels);
        primaryStage.setScene(scene);
        primaryStage.show();
        player= new Player(this);
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    //Przygotowanie komponentów stałych dla wszystkich ekranów gry 
    public void setLevels()
    {
        showMap= new Button();
        playAgain= new Button();
        playAgain.setText("Play again");
        playAgain.setVisible(false);
        playAgain.setOnAction((ActionEvent event) -> {
            end();
        });
        showMap.setText("Show Map");
        hideMap= new Button();
        hideMap.setText("Hide Map");
        lifeEnergy= new Label();
        lifeEnergy.setText("Life energy: ");
        powerLevel= new Label();
        powerLevel.setText("Power level: ");
        weaponType = new Label();
        weaponType.setText("Weapon: ");
        communique= new Label();
        communique.setPrefSize(300, 100);
        communique.setWrapText(true);
        map= new ImageView();
        map.setImage(new Image("dwgame/Images/map.jpg"));
        map.setFitWidth(374);
        map.setFitHeight(326);
        map.setPreserveRatio(true);
        map.setVisible(false);
        showMap.setVisible(false);
        hideMap.setVisible(false);
        time= new Label();
        time.setText("Time: ");
        levels= new VBox();
        levels.relocate(505, 0);
        
        levels.getChildren().addAll(lifeEnergy,weaponType, powerLevel,time, communique, playAgain,showMap, hideMap, map);
        levels.setSpacing(25);
       
    }
    //Zakończenie gry
    public void end()
    {
         playAgain.setVisible(false);
         mainContainer.setScreen(startID);
         player= new Player(this);
        
    }

  
}
