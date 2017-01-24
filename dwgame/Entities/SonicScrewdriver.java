
package dwgame.Entities;

public class SonicScrewdriver extends Weapon {

    public SonicScrewdriver() {
        super();
    }
    //Metoda otwierania zamka zabiera 2 z mocy broni
    public void lockPicking(){
        this.powerLevel-=2;
    }
       
            
    
}
