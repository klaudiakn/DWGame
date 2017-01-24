
package dwgame.Entities;

 //Klasa potrzebna do gry w statki w pokoju SwimmingPool 
public class Ship {
            //Pozycja statku zajmującego 3 pola, który trzeba zestrzelić 
            private int[] position = new int[3];
            //'Życie' statku 
            private int hp = 3;

            //Ustawienie pozycji statku
            public void setPosition(int[] a)
            {
                position = a;
            }


      
            //Sprawdzanie strzału gracza, zwraca stringa jako wynik: sunk, hit albo misshit
            public String check(String guess)
            {
                String result = "mishit";
                for (int i = 0; i < 3; i++)
                {
                    //Jeśli strzał był celny, zmniejszenie hp statku
                    if (Integer.parseInt(guess) == position[i])
                    {
                        hp--;
                        //Jeśli statek zatopiony, rezultat 
                        if (hp == 0)
                        {
                            result = "sunk";
                           
                        }
                        //Jeśli strzał celny, ale statek nie zatopiony jeszcze
                        else
                        {
                            result = "hit";
                           
                        }
                    }

                }
                return result;
            }
}

