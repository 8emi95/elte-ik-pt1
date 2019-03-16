/*
 * Mintaprogramok/19. fejezet
 * Projekt: Megfigyeles
 * Csomag: db
 * BetuStatisztika.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

package db;
import java.util.*;

// Ezt az adatot figyelik, hogy megv�ltozott-e:
public class BetuStatisztika extends Observable {
  private int[] betukSzama;
  private int leutesekSzama;

  public void stat(String text) {
    betukSzama = new int['Z'-'A'+1];
    leutesekSzama = 0;
    char betu;
    for (int i = 0; i < text.length(); i++) {
      betu = Character.toUpperCase(text.charAt(i));
      if (betu != '\n' && betu != '\r')
        leutesekSzama++;
      if (betu>='A' && betu<='Z')
        betukSzama[betu-'A'] += 1;
    }
    // Megv�ltozott az objektum, �rtes�teni kell a figyel�ket:
    setChanged();                                          //1
    notifyObservers();
  }

  public int hany(char betu) {
    betu = Character.toUpperCase(betu);
    if (betu<'A' || betu>'Z')
      return 0;
    return betukSzama[betu-'A'];
  }

  public int leutesekSzama() {
    return leutesekSzama;
  }
}
