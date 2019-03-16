/*
 * Feladatmegold�sok/17. fejezet
 * PalcikaCimkezo.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

class PalcikaTipus {
  private static String faNev="Feny�";
  private static double fajsuly=0.7;          // gramm/cm3
  private String tipusNev;
  private double atmero, magassag;  // cm
  private int dbOsszesen;  // eddig �sszesen nyomtatott c�mke

  // Konstruktor
  public PalcikaTipus(String tipusNev, double atmero, double magassag) {
    this.tipusNev = tipusNev;
    this.atmero = atmero;
    this.magassag = magassag;
    dbOsszesen = 0;
  }

  public String tipusNev() {
    return tipusNev;
  }

  // Kerek�t�s 2 tizedesjegyre:
  private double round(double d) {
    return (Math.round(d*100))/100.0;
  }

  public double terfogat() {
    return Math.pow(atmero/2.0,2) * Math.PI * magassag;
  }

  public double suly() {
    return terfogat() * fajsuly;
  }

  public int dbOsszesen() {
    return dbOsszesen;
  }

  public static void setFa(String nev,double fsuly) {
    faNev = nev;
    fajsuly = fsuly;
  }

  public void printCimke(int db) {
    for (int i=0; i<db; i++) {
      System.out.println("Palcika : "+tipusNev);
      System.out.println("�tm�r�  : "+round(atmero)+" cm");
      System.out.println("Magass�g: "+round(magassag)+" cm");
      System.out.println("T�rfogat: "+round(terfogat())+" cm3");
      System.out.println("Fa      : "+faNev);
      System.out.println("Fajs�ly : "+round(fajsuly)+" gr/cm3");
      System.out.println("S�ly    : "+round(suly())+" gr");
      System.out.println();
    }
    dbOsszesen += db;
  }
}

/* Kontroll objektum.
 */
public class PalcikaCimkezo {
  // Kapcsolatok:
  private PalcikaTipus kicsi = new PalcikaTipus("Kicsi",0.66,5);
  private PalcikaTipus nagy = new PalcikaTipus("Nagy",1.2,13);

  public void statisztika() {
    System.out.println("Nyomtatott cimk�k sz�ma:");
    System.out.println(kicsi.tipusNev()+": "+kicsi.dbOsszesen());
    System.out.println(nagy.tipusNev()+": "+nagy.dbOsszesen());
  }

  public void menu() {
    char valasz;
    do {
      valasz = Character.toUpperCase(Console.readChar
        ("K(icsi)/N(agy)/F(a)/S(tatisztika)/V(�ge): "));
      switch (valasz) {
        case 'K': {
          kicsi.printCimke(Console.readInt("Darab: "));
          break;
        }
        case 'N': {
          nagy.printCimke(Console.readInt("Darab: "));
          break;
        }
        case 'F': {
          PalcikaTipus.setFa(Console.readLine("Fa neve: "),
            Console.readDouble("fajs�lya: "));
          break;
        }
        case 'S': {
          statisztika();
          break;
        }
      }
    } while (valasz != 'V');
  }

  public static void main(String[] args) {
    PalcikaCimkezo pc = new PalcikaCimkezo();
    pc.menu();
  }
}
