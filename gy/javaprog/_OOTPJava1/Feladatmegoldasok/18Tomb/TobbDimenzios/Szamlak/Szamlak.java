/*
 * Feladatmegoldások/18. fejezet
 * Szamlak.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Szamlak {
  final int EV;
  // 1..12 hónapokban a napok száma (a 0. elemet nem használjuk):
  int[] honapHossz = {0,31,0,31,30,31,30,31,31,30,31,30,31};
  // szamlak tömb deklarálása és elsõ dimenziójának létrehozása:
  double[][] szamlak = new double[honapHossz.length][];

  public Szamlak(int ev) {
    /* szamlak tömb létrehozása.
     * Honapok indexei: 1..12, napok indexei: 1..honapHossz[ho]:
     */
    this.EV = ev;
    honapHossz[2] = szokoEv(EV)?29:28;
    for (int ho=1; ho<honapHossz.length; ho++)
      szamlak[ho] = new double[honapHossz[ho]+1];
  }

  static boolean szokoEv(int ev) {
    return ev%4==0 && (ev%100!=0 || ev%400==0);
  }

  // Hónap számának ellenõrzése:
  static boolean joHo(int ho) {
    return ho >= 1 && ho <= 12;
  }

  // Nap számának ellenõrzése egy adott hónapban:
  boolean joNap(int ho, int nap) {
    return nap >= 1 && nap <= honapHossz[ho];
  }

  // szamlak tömb nullázása:
  void nullazas() {
    for (int ho=1; ho<szamlak.length; ho++)
      for (int nap=1; nap<szamlak[ho].length; nap++)
        szamlak[ho][nap]=0;
  }

  // A számlák gyûjtése:
  void gyujtes() {
    int ho, nap;
    while ((ho = Console.readInt("\nHónap : "))!=0) {
      if (!joHo(ho)) {
        System.out.println("Nem jó hónap!");
        continue;
      }
      nap = Console.readInt("Nap   : ");
      if (!joNap(ho,nap)) {
        System.out.println("Nem jó nap!");
        continue;
      }
      szamlak[ho][nap] += Console.readDouble("Összeg: ");
    }
  }

  // Eredmény kiírása:
  void eredmenyKiiras() {
    double evOssz = 0;
    for (int ho=1; ho<szamlak.length; ho++) {
      System.out.println("\n------------------------");
      System.out.println(""+ho+". hónap");
      double hoOssz = 0;
      for (int nap=1; nap<szamlak[ho].length; nap++) {
        if (szamlak[ho][nap]!=0) {
          System.out.println(nap+": "+szamlak[ho][nap]);
          hoOssz += szamlak[ho][nap];
        }
      }
      System.out.println("Hónap összesen: "+hoOssz);
      evOssz += hoOssz;
      Console.pressEnter();
    }
    System.out.println("Év összesen: "+evOssz);
  }

  public static void main(String[] args) {
    Szamlak szamlak = new Szamlak(2001);
    szamlak.nullazas();
    szamlak.gyujtes();
    szamlak.eredmenyKiiras();
  }
}
