/*
 * Mintaprogramok/20. fejezet
 * Emberek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;
import java.util.*;

// collections.sort-hoz kell a Comparable interfész
// contains-hez kell az equals metódus
class Ember implements Comparable {
  private String nev;
  private int szulev;

  public Ember(String nev, int szulev) {
    this.nev = nev;
    this.szulev = szulev;
  }

  public String getNev() { return nev; }
  public int getSzulev() { return szulev; }

  public boolean equals(Object obj) {
    return (nev.equals(((Ember)obj).getNev()) &&
      szulev == ((Ember)obj).getSzulev());
  }

  public int compareTo(Object obj) {
    if (szulev < ((Ember)obj).getSzulev())
      return -1;
    if (szulev > ((Ember)obj).getSzulev())
      return 1;
    return nev.compareTo(((Ember)obj).getNev());
  }

  public String toString() {
    return Format.left(nev,10) + Format.right(szulev,5);
  }
}

public class Emberek {
  private Vector emberek = new Vector();

  void felvitel() {
    Ember ember = new Ember(Console.readLine("\nEmber neve   : "),
      Console.readInt("szuletesi eve: "));
    if (emberek.contains(ember))
      System.out.println("Mar van ilyen");
    else
      emberek.add(ember);
  }

  void torles() {
    Ember ember = new Ember(Console.readLine("\nEmber neve   : "),
      Console.readInt("szuletesi eve: "));
    if (!emberek.remove(ember))
      System.out.println("Nincs ilyen ember");
    else
      System.out.println(ember+" torolve");
  }

  // emberek listázása:
  void lista(Vector e) {
    for (int i=0; i<e.size(); i++)
      System.out.println(e.get(i));
  }

  void menu() {
    Vector rendEmberek;
    char valasz;
    do {
      System.out.print("1:felv - 2:torl - 3:eredeti - 4:legid - "+
        "5:legfiat - 6:novek - 7:csokk - 8:veletlen - 9:vege...?");
      do
        valasz = Console.readChar();
      while (valasz<'1' || valasz>'9');
      switch (valasz) {
        case '1':
          felvitel();
          break;
        case '2':
          torles();
          break;
        case '3':
          lista(emberek);
          break;
        case '4':
          System.out.println(Collections.min(emberek)); // Aki legelõbb született
          break;
        case '5':
          System.out.println(Collections.max(emberek)); // Aki legkésõbb született
          break;
        case '6':
          rendEmberek = new Vector(emberek);
          Collections.sort(rendEmberek);
          lista(rendEmberek);
          break;
        case '7':
          rendEmberek = new Vector(emberek);
          Collections.sort(rendEmberek);
          Collections.reverse(rendEmberek);
          lista(rendEmberek);
          break;
        case '8':
          rendEmberek = new Vector(emberek);
          Collections.shuffle(rendEmberek);
          lista(rendEmberek);
          break;
      }
    } while (valasz != '9');
  }

  public static void main(String[] args) {
    Emberek enyv = new Emberek();
    enyv.menu();
  }
}
