/*
 * Feladatmegoldások/20. fejezet
 * Bank2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;
import java.util.Vector;

class JoSzerencse {
  private static long utolsoSzamlaSzam = 10000;
  private static double arfolyam = 1.03;
  private static int vasarKezKoltseg = 200;  // kezelési költség vásárláskor
  private static int eladKezKoltseg = 400;  // kezelési költség eladáskor
  private long szamlaSzam;          // utolsoSzamlaszam+1
  private String tulajdonos, kedvezmenyezett;  // nevek
  private long jegyDb;              // Bef. jegyek száma a számlán

  // Nyit egy számlát az adott tulajdonossal és kedvezményezettel.
  // Az egyedi számlaszám automatikus, a névérték 0:
  public JoSzerencse(String tulajdonos, String kedvezmenyezett) {
    szamlaSzam = ++utolsoSzamlaSzam;
    this.tulajdonos = tulajdonos;
    this.kedvezmenyezett = kedvezmenyezett;
    jegyDb = 0;
  }

  // Nyit egy számlát az adott tulajdonossal. Kedvezményezett nincs.
  // Az egyedi számlaszám automatikus, a névérték 0:
  public JoSzerencse(String tulajdonos) {
    this(tulajdonos,"");
  }

  // Csak hasonlito objektum letrehozasara!
  JoSzerencse(long szamlaSzam) {
    this.szamlaSzam = szamlaSzam;
  }

  // Visszaadja az aktuális árfolyamot:
  public static double getArfolyam() {
    return arfolyam;
  }

  // Beállítja az aktuális árfolyamot:
  public static void setArfolyam(double arf) {
    if (arf>=0)
      arfolyam = arf;
  }

  // Visszaadja a számlaszámot:
  public long getSzamlaSzam() {
    return szamlaSzam;
  }

  // Megadja, hogy egy adott értékû összeg hány darab jegyet
  // ér az aktuális árfolyamon:
  public static long jegyDb(long ertek) {
    return (long)(ertek/arfolyam);
  }

  // Megadja, hogy az adott darabszámú jegynek mennyi az
  // értéke az aktuális árfolyamon:
  public static long ertek(long jegyDb) {
    return (long)(jegyDb*arfolyam);
  }

  // Visszaadja a számlán levõ jegyek darabszámát:
  public long getJegyDb() {
    return jegyDb;
  }

  // Visszaadja a számla aktuális értékét:
  public long ertek() {
    return ertek(jegyDb);
  }

  // Az ügyfél befektetési jegyet vásárol adott ertekû öszegért.
  // A visszaadott érték a ténylegesen befizetendõ összeg (a kerekítés miatt):
  public long vasarlas(long osszeg) {
    long db = jegyDb(osszeg);
    jegyDb += db;
    return ertek(db)+vasarKezKoltseg; // a befizetendõ összeg
  }

  // Az ügyfél befektetési jegyet ad el adott összegért.
  // A visszaadott érték a ténylegesen kiadott összeg (a kerekítés miatt):
  public long eladas(long osszeg) {
    long db = jegyDb(osszeg);
    jegyDb -= db;
    return ertek(db)-eladKezKoltseg; // a kifizetendõ összeg
  }

  public boolean equals(Object obj) {
    return szamlaSzam==((JoSzerencse)obj).getSzamlaSzam();
  }

  public String toString() {
    return "Számlaszám: "+szamlaSzam+
      " Tulajd.: "+Format.left(tulajdonos,15)+
      " Kedv.: "+Format.left(kedvezmenyezett,15)+
      " Jegyszám: "+Format.right(jegyDb,8)+
      " Érték: "+Format.right(ertek(),8);
  }
}

// A bank és mûködése:
public class Bank2 {
  private Vector szamlak=new Vector();

  void szamlaNyitas() {
    JoSzerencse szamla;
    String tulaj = Console.readLine("\nTulajdonos neve: ");
    String kedv = Console.readLine("Kedvezményezett neve: ");
    szamlak.add(new JoSzerencse(tulaj,kedv));
  }

  public void szamlaMegszuntetes() {
    JoSzerencse torlendo = new JoSzerencse(Console.readLong("\nSzámlaszám: "));
    int index = szamlak.indexOf(torlendo);
    if (index >= 0) {
      System.out.println(szamlak.get(index));
      char valasz = Character.toUpperCase(Console.readChar("Biztosan meg akarja szüntetni a számlát? (I/N)"));
      if (valasz == 'I')
        szamlak.remove(index);
    }
    else
      System.out.println("Nincs ilyen számlaszámú számla!");
  }

  public void ugyfelKiszolgalas() {
    JoSzerencse szamla = new JoSzerencse(Console.readLong("\nSzámlaszám: "));
    int index = szamlak.indexOf(szamla);
    if (index >= 0) {
      szamla = (JoSzerencse)szamlak.get(index);
      System.out.println(szamla);
      long osszeg;
      char valasz;
      do {
        valasz = Character.toUpperCase(Console.readChar("V(ásárlás)/E(ladás)"));
      } while (valasz!='V' && valasz != 'E');
      if (valasz == 'V') {
        osszeg = szamla.vasarlas(Console.readInt("Mennyiért vásárol? "));
        System.out.println("Befizetendõ: "+osszeg+" Ft");
      }
      else {
        osszeg = szamla.eladas(Console.readInt("Mennyiért ad el? "));
        System.out.println("Kifizetendõ: "+osszeg+" Ft");
      }
    }
    else
      System.out.println("Nincs ilyen számlaszámú számla!");

  }

  public void jelentes() {
    System.out.println("\n* - * - * - * - JELENTÉS - * - * - * - *");
    System.out.println("Árfolyam: "+JoSzerencse.getArfolyam());
    if (szamlak.size()==0) {
      System.out.println("Nincs egyetlen számla sem!");
      return;
    }
    System.out.println("Számlák:");
    for (int i=0; i<szamlak.size(); i++)
      System.out.println(szamlak.get(i));
  }

  public void menu() {
    char valasz;
    do {
      jelentes();
      System.out.println("\nN: Számla nyitása");
      System.out.println("M: Számla megszüntetése");
      System.out.println("K: Ügyfél kiszolgálása");
      System.out.println("A: Árfolyam módosítás");
      System.out.println("V: Vége");
      valasz = Character.toUpperCase(Console.readChar());
      switch (valasz) {
        case 'N': {
          szamlaNyitas();
          break;
        }
        case 'M': {
          szamlaMegszuntetes();
          break;
        }
        case 'K': {
          ugyfelKiszolgalas();
          break;
        }
        case 'A': {
          JoSzerencse.setArfolyam(Console.readDouble("Új árfolyam: "));
          break;
        }
      }
    } while (valasz!='V');
  }

  public static void main(String[] args) {
    Bank2 otp = new Bank2();
    otp.menu();
  }
}
