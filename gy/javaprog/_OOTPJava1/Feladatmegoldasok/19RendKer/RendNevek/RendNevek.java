/*
 * Feladatmegoldások/19. fejezet
 * RendNevek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class RendNevek {
  private static int MAX = 100;
  private String[] nevek = new String[MAX];
  private int size=0;
  private int current; // contains allitja be

  // Visszaadja a teljes névbõl a keresztnevet:
  static String keresztNev(String nev) {
    int poz = nev.indexOf(' ');
    if (poz == -1)
      return "";
    return nev.substring(poz+1);
  }

  /* A visszaadott érték 0, ha a két névben a keresztnév egyenlõ, ...
   */
  static int compareTo(String nev1, String nev2) {
    return keresztNev(nev1).compareTo(keresztNev(nev2));
  }

  /* Megadja, hogy van-e már ilyen teljes név a nevek között.
   * current-et beállítja arra a pozícióra, ahol van, vagy lenne.
   * Vigyázat! a compareTo() értéke akkor 0, ha a két keresztnév ugyanaz;
   * az equals() akkor true, ha a két név ugyanaz! Ezek nem keverendõk!
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

  // Beszúrja az új nevet a nevek közé, keresztnév szerint rendezetten:
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

  // Nevek bevitele konzolról:
  public void bevitel() {
    int szulev = 0;
    String nev, ujNev;
    do {
      nev = Console.readLine("Név: ");
      if (nev.equals(""))
        break;
      if (contains(nev)) {
        System.out.print("Ilyen név már létezik. ");
        szulev = Console.readInt("Szül. év: ");
        nev = nev+" "+szulev;
        if (contains(nev)) {
          System.out.println("Létezik! Újra!");
          continue;
        }
      }
      add(nev);
    } while (true);
  }

  // A nevek kiírása:
  public void kiir() {
    System.out.println("Nevek keresztnév szerint rendezve:");
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
