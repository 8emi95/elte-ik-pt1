/*
 * Feladatmegoldások/20. fejezet
 * Emberek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.

   Változtatások:
   - Ember osztályban kell egy setSzulev;
   - Ember equals metódusában: nem kell vizsgálni a születési évet;
   - Emberek2 felvitel metódusában: ha van ilyen nevû ember, nem kérjük be a születési évet;
   - Emberek2 torles metódusában: már a név is elegendõ az azonosításhoz.

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
  public void setSzulev(int szulev) { this.szulev = szulev; }

  public boolean equals(Object obj) {
    return (nev.equals(((Ember)obj).getNev()));
      // && szulev == ((Ember)obj).getSzulev()); // Itt van változtatás!
  }

  public int compareTo(Object obj) {
    if (szulev < ((Ember)obj).getSzulev())
      return -1;
    else if (szulev > ((Ember)obj).getSzulev())
      return 1;
    return nev.compareTo(((Ember)obj).getNev());
  }

  public String toString() {
    return Format.left(nev,10) + Format.right(szulev,3);
  }
}

public class Emberek2 {
  private Vector emberek = new Vector();

  void felvitel() {
    Ember ember = new Ember(Console.readLine("\nEmber neve   : "),0);
    if (emberek.contains(ember))
      System.out.println("Már van ilyen nevû ember!");
    else {
      ember.setSzulev(Console.readInt("születési éve: "));
      emberek.add(ember);
    }
  }

  void torles() {
    Ember ember = new Ember(Console.readLine("\nEmber neve   : "),0);
    int index = emberek.indexOf(ember);
    if (index < 0)
      System.out.println("Nincs ilyen nevû ember!");
    else {
      ember = (Ember)(emberek.get(index));
      emberek.remove(index);
      System.out.println(ember+" törölve");
    }
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
      System.out.print("1:felv - 2:törl - 3:eredeti - 4:legid - "+
        "5:legfiat - 6:növek - 7:csökk - 8:véletlen - 9:vége...?");
      do
        valasz = Console.readChar();
      while (valasz>=1 && valasz<=9);
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
    Emberek2 enyv = new Emberek2();
    enyv.menu();
  }
}
