package dwgame;

//Interfejs ustawiający, że wszystkie ekrany pamiętają swojego rodzica
public interface CScreen {
    public void setScreenParent(dwgame.Rooms.RoomController screenPage);
}
