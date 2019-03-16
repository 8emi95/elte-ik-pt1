/*
 * Feladatmegold�sok/15. fejezet
 * Primek.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
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

  // prim() f�ggv�ny tesztel�s�re
  static void primVizsgalat() {
    long szam;
    while ((szam=(long)Console.readDouble("Sz�m: "))!=0)
      if (prim(szam))
        System.out.println("Pr�m");
      else
        System.out.println("Nem pr�m");
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
    System.out.println("Az 1 milli�n�l kisebb pr�mek sz�ma: "+    //c
      kisebbPrimekSzama(1000000)); // V�rjon, eltart egy darabig!
    long szam = Console.readLong("Sz�m: ");                       //d
    System.out.println(szam+" ut�ni els� pr�m: "+kovPrim(szam));
  }
}
