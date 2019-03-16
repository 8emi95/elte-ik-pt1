/*
 * Feladatmegoldások/15. fejezet
 * Fuggvenyek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Fuggvenyek {

  // a) feladat:
  static int dupla(int n) {
    return n*2;
  }

  // b) feladat:
  static double korTer(double sugar) {
    return Math.pow(sugar,2) * Math.PI;
  }

  // c) feladat:
  static double gombTerf(double sugar) {
    return 4 * Math.pow(sugar,3) * Math.PI / 3;
  }

  // d) feladat:
  static boolean pozitiv(double n) {
    return n>0;
  }

  // e) feladat:
  static boolean benne(char alsoHatar, char felsoHatar, char kar) {
    if (alsoHatar > felsoHatar) {
      char seged=alsoHatar; alsoHatar=felsoHatar; felsoHatar=seged;
    }
    return alsoHatar <= kar && kar <= felsoHatar;
  }

  // f) feladat:
  static char min(char c1, char c2) {
    return (c1<c2)? c1:c2;
  }

  // g) feladat:
  static long osszeg(int alsoHatar, int felsoHatar) {
    long osszeg = alsoHatar;
    for(int i=alsoHatar+1; i<=felsoHatar; i++)
      osszeg += i;
    return osszeg;
  }

  // h) feladat:
  static double inch(double cm) {
    final double VALTOSZAM = 2.54; // 1 inch = 2.54 cm
    return cm/VALTOSZAM;
  }

  public static void main (String args[]) {
    System.out.println(dupla(5));                          //a
    int r = Console.readInt("A kör sugara: ");             //b
    System.out.println("A kör területe: "+Format.left(korTer(r),0,2));
    r = Console.readInt("A gömb sugara: ");                //c
    System.out.println("A gömb térfogata: "+Format.left(gombTerf(r),0,2));
    if (pozitiv(Console.readDouble("Szám: ")))             //d
      System.out.println("Pozitív");
    else
      System.out.println("Nem pozitív");
    if (benne('a','z',Console.readChar("Karakter: ")))     //e
      System.out.println("Kisbetû");
    else
      System.out.println("Nem kisbetû");
    System.out.println(min('a','A'));                      //f
    System.out.println(osszeg(3,7));                       //g
    System.out.println(Format.left(inch(1),0,4));          //h
  }
}
