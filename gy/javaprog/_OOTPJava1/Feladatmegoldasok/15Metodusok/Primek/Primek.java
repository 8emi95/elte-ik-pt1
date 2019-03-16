/*
 * Feladatmegoldások/15. fejezet
 * Primek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class Primek {

  // a) feladat:
  static boolean prim(long szam) {
    if (szam < 2)
      return false;
    for (int oszto=2; oszto<=Math.sqrt(szam); oszto++)
      if (szam%oszto==0)
        return false;
    return true;
  }

  // prim() függvény tesztelésére
  static void primVizsgalat() {
    long szam;
    while ((szam=(long)Console.readDouble("Szám: "))!=0)
      if (prim(szam))
        System.out.println("Prím");
      else
        System.out.println("Nem prím");
  }

  // b) feladat:
  static void kisebbPrimekKiir(long szam) {
    int sorsz=0;
    for (int n=1; n<szam; n++)
      if (prim(n))
        System.out.print(++sorsz+": "+n+"  ");
    System.out.println();
  }

  // c) feladat:
  static int kisebbPrimekSzama(long szam) {
    int db=0;
    for (int n=1; n<szam; n++)
      if (prim(n))
        db++;
    return db;
  }

  // d) feladat:
  static long kovPrim(long szam) {
    do
      szam++;
    while (!prim(szam));
    return szam;
  }

  public static void main (String args[]) {
    primVizsgalat();                                              //a
    kisebbPrimekKiir(100);                                        //b
    System.out.println("Az 1 milliónál kisebb prímek száma: "+    //c
      kisebbPrimekSzama(1000000)); // Várjon, eltart egy darabig!
    long szam = Console.readLong("Szám: ");                       //d
    System.out.println(szam+" utáni elsõ prím: "+kovPrim(szam));
  }
}
