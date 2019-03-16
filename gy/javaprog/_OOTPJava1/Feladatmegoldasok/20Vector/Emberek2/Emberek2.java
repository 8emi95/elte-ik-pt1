/*
 * Feladatmegold�sok/20. fejezet
 * Emberek.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.

   V�ltoztat�sok:
   - Ember oszt�lyban kell egy setSzulev;
   - Ember equals met�dus�ban: nem kell vizsg�lni a sz�let�si �vet;
   - Emberek2 felvitel met�dus�ban: ha van ilyen nev� ember, nem k�rj�k be a sz�let�si �vet;
   - Emberek2 torles met�dus�ban: m�r a n�v is elegend� az azonos�t�shoz.

 */

import extra.*;
import java.util.*;

// collections.sort-hoz kell a Comparable interf�sz
// contains-hez kell az equals met�dus
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
      // && szulev == ((Ember)obj).getSzulev()); // Itt van v�ltoztat�s!
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
      System.out.println("M�r van ilyen nev� ember!");
    else {
      ember.setSzulev(Console.readInt("sz�let�si �ve: "));
      emberek.add(ember);
    }
  }

  void torles() {
    Ember ember = new Ember(Console.readLine("\nEmber neve   : "),0);
    int index = emberek.indexOf(ember);
    if (index < 0)
      System.out.println("Nincs ilyen nev� ember!");
    else {
      ember = (Ember)(emberek.get(index));
      emberek.remove(index);
      System.out.println(ember+" t�r�lve");
    }
  }

  // emberek list�z�sa:
  void lista(Vector e) {
    for (int i=0; i<e.size(); i++)
      System.out.println(e.get(i));
  }

  void menu() {
    Vector rendEmberek;
    char valasz;
    do {
      System.out.print("1:felv - 2:t�rl - 3:eredeti - 4:legid - "+
        "5:legfiat - 6:n�vek - 7:cs�kk - 8:v�letlen - 9:v�ge...?");
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
          System.out.println(Collections.min(emberek)); // Aki legel�bb sz�letett
          break;
        case '5':
          System.out.println(Collections.max(emberek)); // Aki legk�s�bb sz�letett
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
