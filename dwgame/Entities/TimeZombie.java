
package dwgame.Entities;

import dwgame.Player;

import java.util.Random;

 //Klasa TimeZombie, przeciwnika, z którym gracz spotyka się w pokoju Library i The Eye of Harmony
public class TimeZombie {
     private int powerLevel;

        //Nowe TimeZombie ma losowy poziom energii życiowej 
        public TimeZombie()
        {
            Random gen = new Random();
            this.powerLevel = gen.nextInt(10)+1;
        }

        //Metoda wywoływana po wyborze walki wręcz z TmeZombie w pokoju The Eye of Harmony,
        //zwraca komunikat o wyniku działania. Zabiera graczowi 2 pkt energii życia, ale zabija TimeZombie
        public String fightByHand(Player player)
        {
            player.changeLifeEnergy(2);
            this.powerLevel = 0;
            return "You fight with Time Zombie hand to hand. Your life power gets lower but in a lucky punch you manage to throw it from the bridge into the Eye of Harmony. ";

        }

        //Walka przy pomocy broni, TimeZombie traci 4pkt energii, zwraca komunikat o wyniku działania
        public String fightWithWeapon(Player player)
        {
            player.myWeapon.fire();
            player.updatePowerLevel();
            this.powerLevel -= 4;
            //Jeśli poziom energii TimeZombie zerowy, to zwrócenie komunikatu o jego śmierci
            if (this.death())
                return "You manage to kill time zombie with your weapon.";
            else
                return "Altought time zombie gets hurt from your attack, it's not dead yet and still coming after you.";
        }

        //Sprawdza, czy TimeZombie umarło
        public boolean death()
        {
         return powerLevel <= 0;
        }
}
