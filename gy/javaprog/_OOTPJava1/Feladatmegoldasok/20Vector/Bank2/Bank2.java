/*
 * Feladatmegold�sok/20. fejezet
 * Bank2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;
import java.util.Vector;

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

  // Csak hasonlito objektum letrehozasara!
  JoSzerencse(long szamlaSzam) {
    this.szamlaSzam = szamlaSzam;
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

  // Visszaadja a sz�mlasz�mot:
  public long getSzamlaSzam() {
    return szamlaSzam;
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

  public boolean equals(Object obj) {
    return szamlaSzam==((JoSzerencse)obj).getSzamlaSzam();
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
public class Bank2 {
  private Vector szamlak=new Vector();

  void szamlaNyitas() {
    JoSzerencse szamla;
    String tulaj = Console.readLine("\nTulajdonos neve: ");
    String kedv = Console.readLine("Kedvezm�nyezett neve: ");
    szamlak.add(new JoSzerencse(tulaj,kedv));
  }

  public void szamlaMegszuntetes() {
    JoSzerencse torlendo = new JoSzerencse(Console.readLong("\nSz�mlasz�m: "));
    int index = szamlak.indexOf(torlendo);
    if (index >= 0) {
      System.out.println(szamlak.get(index));
      char valasz = Character.toUpperCase(Console.readChar("Biztosan meg akarja sz�ntetni a sz�ml�t? (I/N)"));
      if (valasz == 'I')
        szamlak.remove(index);
    }
    else
      System.out.println("Nincs ilyen sz�mlasz�m� sz�mla!");
  }

  public void ugyfelKiszolgalas() {
    JoSzerencse szamla = new JoSzerencse(Console.readLong("\nSz�mlasz�m: "));
    int index = szamlak.indexOf(szamla);
    if (index >= 0) {
      szamla = (JoSzerencse)szamlak.get(index);
      System.out.println(szamla);
      long osszeg;
      char valasz;
      do {
        valasz = Character.toUpperCase(Console.readChar("V(�s�rl�s)/E(lad�s)"));
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
    else
      System.out.println("Nincs ilyen sz�mlasz�m� sz�mla!");

  }

  public void jelentes() {
    System.out.println("\n* - * - * - * - JELENT�S - * - * - * - *");
    System.out.println("�rfolyam: "+JoSzerencse.getArfolyam());
    if (szamlak.size()==0) {
      System.out.println("Nincs egyetlen sz�mla sem!");
      return;
    }
    System.out.println("Sz�ml�k:");
    for (int i=0; i<szamlak.size(); i++)
      System.out.println(szamlak.get(i));
  }

  public void menu() {
    char valasz;
    do {
      jelentes();
      System.out.println("\nN: Sz�mla nyit�sa");
      System.out.println("M: Sz�mla megsz�ntet�se");
      System.out.println("K: �gyf�l kiszolg�l�sa");
      System.out.println("A: �rfolyam m�dos�t�s");
      System.out.println("V: V�ge");
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
          JoSzerencse.setArfolyam(Console.readDouble("�j �rfolyam: "));
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
