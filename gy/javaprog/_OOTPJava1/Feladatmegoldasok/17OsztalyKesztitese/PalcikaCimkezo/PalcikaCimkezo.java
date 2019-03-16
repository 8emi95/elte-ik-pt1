/*
 * Feladatmegoldások/17. fejezet
 * PalcikaCimkezo.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

class PalcikaTipus {
  private static String faNev="Fenyõ";
  private static double fajsuly=0.7;          // gramm/cm3
  private String tipusNev;
  private double atmero, magassag;  // cm
  private int dbOsszesen;  // eddig összesen nyomtatott címke

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

  // Kerekítés 2 tizedesjegyre:
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
      System.out.println("Átmérõ  : "+round(atmero)+" cm");
      System.out.println("Magasság: "+round(magassag)+" cm");
      System.out.println("Térfogat: "+round(terfogat())+" cm3");
      System.out.println("Fa      : "+faNev);
      System.out.println("Fajsúly : "+round(fajsuly)+" gr/cm3");
      System.out.println("Súly    : "+round(suly())+" gr");
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
    System.out.println("Nyomtatott cimkék száma:");
    System.out.println(kicsi.tipusNev()+": "+kicsi.dbOsszesen());
    System.out.println(nagy.tipusNev()+": "+nagy.dbOsszesen());
  }

  public void menu() {
    char valasz;
    do {
      valasz = Character.toUpperCase(Console.readChar
        ("K(icsi)/N(agy)/F(a)/S(tatisztika)/V(ége): "));
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
            Console.readDouble("fajsúlya: "));
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
