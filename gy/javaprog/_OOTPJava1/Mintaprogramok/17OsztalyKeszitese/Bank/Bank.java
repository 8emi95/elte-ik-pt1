/*
 * Mintaprogramok/17. fejezet
 * Bank.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

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

  // Visszaadja az aktuális árfolyamot:
  public static double getArfolyam() {
    return arfolyam;
  }

  // Beállítja az aktuális árfolyamot:
  public static void setArfolyam(double arf) {
    if (arf>=0)
      arfolyam = arf;
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

  public String toString() {
    return "Számlaszám: "+szamlaSzam+
      " Tulajd.: "+Format.left(tulajdonos,15)+
      " Kedv.: "+Format.left(kedvezmenyezett,15)+
      " Jegyszám: "+Format.right(jegyDb,8)+
      " Érték: "+Format.right(ertek(),8);
  }
}

// A bank és mûködése:
public class Bank {
  private JoSzerencse szamla1, szamla2;

  public Bank() {
    szamla1 = new JoSzerencse("Arany Dániel","Ezüst Hajnalka");
    szamla2 = new JoSzerencse("Fejér Lipót");
  }

  public void ugyfelKiszolgalas(JoSzerencse szamla) {
    long osszeg;
    System.out.println("\n"+szamla);
    char valasz;
    do {
      valasz = Character.toUpperCase(Console.readChar("V(ásárlás)/E(ladás)? "));
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

  public void jelentes() {
    System.out.println("\n* - * - * - * - JELENTÉS - * - * - * - *");
    System.out.println("Árfolyam  : "+JoSzerencse.getArfolyam());
    System.out.println(szamla1);
    System.out.println(szamla2);
  }

  public void menu() {
    char valasz;
    do {
      jelentes();
      System.out.println("\n1: 1. ügyfél kiszolgálása");
      System.out.println("2: 2. ügyfél kiszolgálása");
      System.out.println("A: Árfolyam modosítás ");
      System.out.println("V: Vége");
      valasz = Character.toUpperCase(Console.readChar("?"));
      switch (valasz) {
        case '1': {
          ugyfelKiszolgalas(szamla1);
          break;
        }
        case '2': {
          ugyfelKiszolgalas(szamla2);
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
    Bank otp = new Bank();
    otp.menu();
  }
}
