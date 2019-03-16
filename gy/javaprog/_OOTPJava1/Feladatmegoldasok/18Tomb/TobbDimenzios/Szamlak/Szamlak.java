/*
 * Feladatmegold�sok/18. fejezet
 * Szamlak.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Szamlak {
  final int EV;
  // 1..12 h�napokban a napok sz�ma (a 0. elemet nem haszn�ljuk):
  int[] honapHossz = {0,31,0,31,30,31,30,31,31,30,31,30,31};
  // szamlak t�mb deklar�l�sa �s els� dimenzi�j�nak l�trehoz�sa:
  double[][] szamlak = new double[honapHossz.length][];

  public Szamlak(int ev) {
    /* szamlak t�mb l�trehoz�sa.
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

  // H�nap sz�m�nak ellen�rz�se:
  static boolean joHo(int ho) {
    return ho >= 1 && ho <= 12;
  }

  // Nap sz�m�nak ellen�rz�se egy adott h�napban:
  boolean joNap(int ho, int nap) {
    return nap >= 1 && nap <= honapHossz[ho];
  }

  // szamlak t�mb null�z�sa:
  void nullazas() {
    for (int ho=1; ho<szamlak.length; ho++)
      for (int nap=1; nap<szamlak[ho].length; nap++)
        szamlak[ho][nap]=0;
  }

  // A sz�ml�k gy�jt�se:
  void gyujtes() {
    int ho, nap;
    while ((ho = Console.readInt("\nH�nap : "))!=0) {
      if (!joHo(ho)) {
        System.out.println("Nem j� h�nap!");
        continue;
      }
      nap = Console.readInt("Nap   : ");
      if (!joNap(ho,nap)) {
        System.out.println("Nem j� nap!");
        continue;
      }
      szamlak[ho][nap] += Console.readDouble("�sszeg: ");
    }
  }

  // Eredm�ny ki�r�sa:
  void eredmenyKiiras() {
    double evOssz = 0;
    for (int ho=1; ho<szamlak.length; ho++) {
      System.out.println("\n------------------------");
      System.out.println(""+ho+". h�nap");
      double hoOssz = 0;
      for (int nap=1; nap<szamlak[ho].length; nap++) {
        if (szamlak[ho][nap]!=0) {
          System.out.println(nap+": "+szamlak[ho][nap]);
          hoOssz += szamlak[ho][nap];
        }
      }
      System.out.println("H�nap �sszesen: "+hoOssz);
      evOssz += hoOssz;
      Console.pressEnter();
    }
    System.out.println("�v �sszesen: "+evOssz);
  }

  public static void main(String[] args) {
    Szamlak szamlak = new Szamlak(2001);
    szamlak.nullazas();
    szamlak.gyujtes();
    szamlak.eredmenyKiiras();
  }
}
