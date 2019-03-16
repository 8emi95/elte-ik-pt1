/*
 * Feladatmegoldások/14. fejezet
 * MennyiPenz2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class MennyiPenz2 {
  public static void main (String args[]) {
    final int AKTEV = 2001;
    final int VEGJEL = 0;
    long alapOsszeg = Console.readInt("Mennyi pénze van? "), ujOsszeg;
    double kamat = Console.readDouble("Évi kamat%? ");
    // feltételezzük, hogy osszeg és kamat pozitív
    System.out.println("Most 2001-et írunk.");
    System.out.println("Írja be az éveket, megadom, mennyi pénze lesz ("+VEGJEL+"=vége):");
    int ev;
    while (true) {
      do {
        ev = Console.readInt("Év? ");
        if (ev<AKTEV && ev!=VEGJEL)
          System.out.println("Hibás év! Újra!");
      } while (ev<AKTEV && ev!=VEGJEL);
      if (ev==VEGJEL)
        break;

      ujOsszeg = (long)(alapOsszeg * Math.pow(1+kamat/100,ev-AKTEV));
      System.out.println("Ennyi lesz: "+(long)ujOsszeg);
    }
  }
}
