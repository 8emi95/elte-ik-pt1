/*
 * Feladatmegold�sok/19. fejezet
 * RendNevek.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class RendNevek {
  private static int MAX = 100;
  private String[] nevek = new String[MAX];
  private int size=0;
  private int current; // contains allitja be

  // Visszaadja a teljes n�vb�l a keresztnevet:
  static String keresztNev(String nev) {
    int poz = nev.indexOf(' ');
    if (poz == -1)
      return "";
    return nev.substring(poz+1);
  }

  /* A visszaadott �rt�k 0, ha a k�t n�vben a keresztn�v egyenl�, ...
   */
  static int compareTo(String nev1, String nev2) {
    return keresztNev(nev1).compareTo(keresztNev(nev2));
  }

  /* Megadja, hogy van-e m�r ilyen teljes n�v a nevek k�z�tt.
   * current-et be�ll�tja arra a poz�ci�ra, ahol van, vagy lenne.
   * Vigy�zat! a compareTo() �rt�ke akkor 0, ha a k�t keresztn�v ugyanaz;
   * az equals() akkor true, ha a k�t n�v ugyanaz! Ezek nem keverend�k!
   */
  public boolean contains(String nev) {
    for (current=0; current<size; current++) {
      if (nevek[current].equals(nev))
        return true;
      if (compareTo(nevek[current],nev) > 0)
        return false;
    }
    return false;
  }

  // Besz�rja az �j nevet a nevek k�z�, keresztn�v szerint rendezetten:
  public boolean add(String nev) {
    if (size==MAX)
      return false;

    if (contains(nev))
      return false;

    for (int i=size; i>current; i--)
      nevek[i] = nevek[i-1];
    nevek[current] = nev;
    size++;
    return true;
  }

  // Nevek bevitele konzolr�l:
  public void bevitel() {
    int szulev = 0;
    String nev, ujNev;
    do {
      nev = Console.readLine("N�v: ");
      if (nev.equals(""))
        break;
      if (contains(nev)) {
        System.out.print("Ilyen n�v m�r l�tezik. ");
        szulev = Console.readInt("Sz�l. �v: ");
        nev = nev+" "+szulev;
        if (contains(nev)) {
          System.out.println("L�tezik! �jra!");
          continue;
        }
      }
      add(nev);
    } while (true);
  }

  // A nevek ki�r�sa:
  public void kiir() {
    System.out.println("Nevek keresztn�v szerint rendezve:");
    for (int i=0; i<size; i++)
      System.out.println(nevek[i]);
  }

  // main:
  public static void main(String[] args) {
    RendNevek rn = new RendNevek();
    rn.bevitel();
    rn.kiir();
  }
}
