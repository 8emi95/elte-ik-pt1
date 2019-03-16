/*
 * Mintaprogramok/17. fejezet
 * Bank.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

class JoSzerencse {
  private static long utolsoSzamlaSzam = 10000;
  private static double arfolyam = 1.03;
  private static int vasarKezKoltseg = 200;  // kezel�si k�lts�g v�s�rl�skor
  private static int eladKezKoltseg = 400;  // kezel�si k�lts�g elad�skor
  private long szamlaSzam;          // utolsoSzamlaszam+1
  private String tulajdonos, kedvezmenyezett;  // nevek
  private long jegyDb;              // Bef. jegyek sz�ma a sz�ml�n

  // Nyit egy sz�ml�t az adott tulajdonossal �s kedvezm�nyezettel.
  // Az egyedi sz�mlasz�m automatikus, a n�v�rt�k 0:
  public JoSzerencse(String tulajdonos, String kedvezmenyezett) {
    szamlaSzam = ++utolsoSzamlaSzam;
    this.tulajdonos = tulajdonos;
    this.kedvezmenyezett = kedvezmenyezett;
    jegyDb = 0;
  }

  // Nyit egy sz�ml�t az adott tulajdonossal. Kedvezm�nyezett nincs.
  // Az egyedi sz�mlasz�m automatikus, a n�v�rt�k 0:
  public JoSzerencse(String tulajdonos) {
    this(tulajdonos,"");
  }

  // Visszaadja az aktu�lis �rfolyamot:
  public static double getArfolyam() {
    return arfolyam;
  }

  // Be�ll�tja az aktu�lis �rfolyamot:
  public static void setArfolyam(double arf) {
    if (arf>=0)
      arfolyam = arf;
  }

  // Megadja, hogy egy adott �rt�k� �sszeg h�ny darab jegyet
  // �r az aktu�lis �rfolyamon:
  public static long jegyDb(long ertek) {
    return (long)(ertek/arfolyam);
  }

  // Megadja, hogy az adott darabsz�m� jegynek mennyi az
  // �rt�ke az aktu�lis �rfolyamon:
  public static long ertek(long jegyDb) {
    return (long)(jegyDb*arfolyam);
  }

  // Visszaadja a sz�ml�n lev� jegyek darabsz�m�t:
  public long getJegyDb() {
    return jegyDb;
  }

  // Visszaadja a sz�mla aktu�lis �rt�k�t:
  public long ertek() {
    return ertek(jegyDb);
  }

  // Az �gyf�l befektet�si jegyet v�s�rol adott ertek� �szeg�rt.
  // A visszaadott �rt�k a t�nylegesen befizetend� �sszeg (a kerek�t�s miatt):
  public long vasarlas(long osszeg) {
    long db = jegyDb(osszeg);
    jegyDb += db;
    return ertek(db)+vasarKezKoltseg; // a befizetend� �sszeg
  }

  // Az �gyf�l befektet�si jegyet ad el adott �sszeg�rt.
  // A visszaadott �rt�k a t�nylegesen kiadott �sszeg (a kerek�t�s miatt):
  public long eladas(long osszeg) {
    long db = jegyDb(osszeg);
    jegyDb -= db;
    return ertek(db)-eladKezKoltseg; // a kifizetend� �sszeg
  }

  public String toString() {
    return "Sz�mlasz�m: "+szamlaSzam+
      " Tulajd.: "+Format.left(tulajdonos,15)+
      " Kedv.: "+Format.left(kedvezmenyezett,15)+
      " Jegysz�m: "+Format.right(jegyDb,8)+
      " �rt�k: "+Format.right(ertek(),8);
  }
}

// A bank �s m�k�d�se:
public class Bank {
  private JoSzerencse szamla1, szamla2;

  public Bank() {
    szamla1 = new JoSzerencse("Arany D�niel","Ez�st Hajnalka");
    szamla2 = new JoSzerencse("Fej�r Lip�t");
  }

  public void ugyfelKiszolgalas(JoSzerencse szamla) {
    long osszeg;
    System.out.println("\n"+szamla);
    char valasz;
    do {
      valasz = Character.toUpperCase(Console.readChar("V(�s�rl�s)/E(lad�s)? "));
    } while (valasz!='V' && valasz != 'E');
    if (valasz == 'V') {
      osszeg = szamla.vasarlas(Console.readInt("Mennyi�rt v�s�rol? "));
      System.out.println("Befizetend�: "+osszeg+" Ft");
    }
    else {
      osszeg = szamla.eladas(Console.readInt("Mennyi�rt ad el? "));
      System.out.println("Kifizetend�: "+osszeg+" Ft");
    }
  }

  public void jelentes() {
    System.out.println("\n* - * - * - * - JELENT�S - * - * - * - *");
    System.out.println("�rfolyam  : "+JoSzerencse.getArfolyam());
    System.out.println(szamla1);
    System.out.println(szamla2);
  }

  public void menu() {
    char valasz;
    do {
      jelentes();
      System.out.println("\n1: 1. �gyf�l kiszolg�l�sa");
      System.out.println("2: 2. �gyf�l kiszolg�l�sa");
      System.out.println("A: �rfolyam modos�t�s ");
      System.out.println("V: V�ge");
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
          JoSzerencse.setArfolyam(Console.readDouble("�j �rfolyam: "));
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
