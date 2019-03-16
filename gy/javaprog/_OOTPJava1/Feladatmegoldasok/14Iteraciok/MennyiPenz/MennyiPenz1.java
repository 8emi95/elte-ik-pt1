/*
 * Feladatmegoldások/14. fejezet
 * MennyiPenz1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class MennyiPenz1 {
  public static void main (String args[]) {
    final int AKTEV = 2001;
    final int VEGJEL = 0;
    long alapOsszeg = Console.readInt("Mennyi pénze van? "), ujOsszeg;
    double kamat = Console.readDouble("Évi kamat%? ");
    // feltételezzük, hogy osszeg és kamat pozitív
    System.out.println("Most 2001-et írunk.");
    System.out.println("Írja be az éveket, megadom, mennyi pénze lesz ("+VEGJEL+"=vége):");
    int ev;
    while ((ev = Console.readInt("Év? "))!=VEGJEL) {
      if (ev>=AKTEV) {
        ujOsszeg = (long)(alapOsszeg * Math.pow(1+kamat/100,ev-AKTEV));
        System.out.println("Ennyi lesz: "+(long)ujOsszeg);
      }
      else
        System.out.println("Hibás év! Újra!");
    }
  }
}
