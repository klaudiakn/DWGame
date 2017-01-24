package dwgame;


import dwgame.Entities.SonicScrewdriver;
import dwgame.Entities.Weapon;

public class Player {
    
    private int time;
    private int lifeEnergy;
    public Weapon myWeapon;
    DWGame game;
    
    //Gracz na poczatku gry ma poziom energii 10, wykorzystany przez niego czas to 0 i jego bronią jest Sonic Screwdriver 
    public Player(DWGame g)
    {
        this.game=g;
        this.lifeEnergy= 10;
        changeWeaponToSonic();
        this.updateLifeEnergy();
        this.updateTime();
    }
    
    public void changeLifeEnergy(int x)
    {
        this.lifeEnergy-=x;
        updateLifeEnergy();
    }
    public int getLifeEnergy()
    {
        return this.lifeEnergy;
    }
    
    public void updatePowerLevel()
    {
        game.powerLevel.setText("Power level: " + myWeapon.getPowerLevel() );
    }
    
    public void updateLifeEnergy()
    {
        if(lifeEnergy <0 )
        {
            game.communique.setText("You have no more life energy! You're dying out of your wounds....Game over. Press play again if you want to try again.");
            game.playAgain.setVisible(true);
            game.mainContainer.setScreen(DWGame.endID);
        }
        game.lifeEnergy.setText("Life energy: " +lifeEnergy);
    }
    
    //Wyświetlenie wartości spędzonego przez gracza czasu
    public void updateTime()
    {
        //Jeśli czas przekracza limit, zakończenie gry porażką
            if(time > 7)
            {
                game.communique.setText("Your time limit is up! The engine blows, you, TARDIS and everybody on board are dying...(looks like Steven Moffat wrote this game). Game over ;c. Press play again if you want to try again.");
                game.playAgain.setVisible(true);
                game.mainContainer.setScreen(DWGame.endID);

            }
            //W przeciwnym razie wyświetlenie wartości czasu
            game.time.setText("Time: " + time);
    }
    

     //Zabranie czasu graczowi 
        public void takeTime()
        {
            this.time++;
            this.updateTime();
        }
    
    
    
    //Zmiana broni na Sonic Screwdriver, wyświetlenie informacji o nim i pokazanie jego poziomu naładowania w oknie
    public void changeWeaponToSonic(){
        this.myWeapon = new SonicScrewdriver();
        game.weaponType.setText("Weapon: Sonic Screwdriver");
        this.updatePowerLevel();
        this.updateTime();
        game.communique.setText("You're now using Sonic Screwdriver as your weapon. You can fire it at your enemies or pick a lock with it. But be careful, it's power level is limited. Firing it will lower it's level by 5, picking a lock by 2, and examination by 1.");
    }
    
     //Zmiania broni na K9, wyświetlenie komunikatu informacji o jego właściwościach, pokazanie przycisku do wyświetlania mapy
        public void changeWeaponToK9()
        {
            this.myWeapon = new dwgame.Entities.K9(game);
            game.weaponType.setText("Weapon: K9");
            //Pokazanie poziomu naładowania zdobytej broni 
            this.updatePowerLevel();
            game.communique.setText("Now you have K9 with you! He can fire at your enemies like Sonic Screwdriver (at the same rules) and he's got the map of the TARDIS, you can see it by clicking the button 'Show Map' (look closely, there may be shortcuts)");
            game.showMap.setVisible(true);
            
        }
        
      
    
}
