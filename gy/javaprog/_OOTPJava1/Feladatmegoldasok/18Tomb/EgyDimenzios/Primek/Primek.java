/* 
 * Feladatmegoldások/18. fejezet
 * Primek.java 
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */
 
import extra.*;

public class Primek {
  public static void main (String args[]) {
    // Határszám bekérése, ennek megfelelõ nagysagú tömb lefoglalása.
    // Csak a 2. elemtõl használjuk a tömböt (az 1 nem prím).
    int hatar = Console.readInt("Meddig? ");
    boolean[] szamok = new boolean[hatar+1];

    // Kezdetben minden elem prím:
    for (int i=2; i<szamok.length; i++)
      szamok[i] = true;

    // Ami még prím, annak a többszöröseit false-ra állítjuk:
    for (int i=2; i<szamok.length; i++)
      if (szamok[i])
        for (int j=2*i; j<szamok.length; j+=i)
          szamok[j]=false;

    // A true értékû elemek indexei a primek:
    int nPrim=0;
    for (int i=2; i<szamok.length; i++)
      if (szamok[i])
        System.out.println(Format.right(++nPrim,2)+": "+i);
  } 
} 
