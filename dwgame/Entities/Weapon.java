package dwgame.Entities;

import java.util.Random;

public class Weapon {
    //Poziom mocy broni 
    protected int powerLevel;
    
    //Nowa broń ma losowany poziom mocy z określonego zakresu 
    public Weapon()
     {
              Random gen= new Random();
              this.powerLevel= gen.nextInt(20)+1;
      }
     //Wystrzelenie z broni, obniżenie poziomu naładowania o 5
    public void fire()
    {
        this.powerLevel-=5;
    }
    //Zbadanie czegoś przy pomocy broni obniża poziom naładowania o 1;
    public void examine()
    {
        this.powerLevel--;
    }
    
    public int getPowerLevel()
    {
        return this.powerLevel;
    }
}
