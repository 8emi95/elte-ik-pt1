/*
 * Feladatmegold�sok/14. fejezet
 * MennyiPenz1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class MennyiPenz1 {
  public static void main (String args[]) {
    final int AKTEV = 2001;
    final int VEGJEL = 0;
    long alapOsszeg = Console.readInt("Mennyi p�nze van? "), ujOsszeg;
    double kamat = Console.readDouble("�vi kamat%? ");
    // felt�telezz�k, hogy osszeg �s kamat pozit�v
    System.out.println("Most 2001-et �runk.");
    System.out.println("�rja be az �veket, megadom, mennyi p�nze lesz ("+VEGJEL+"=v�ge):");
    int ev;
    while ((ev = Console.readInt("�v? "))!=VEGJEL) {
      if (ev>=AKTEV) {
        ujOsszeg = (long)(alapOsszeg * Math.pow(1+kamat/100,ev-AKTEV));
        System.out.println("Ennyi lesz: "+(long)ujOsszeg);
      }
      else
        System.out.println("Hib�s �v! �jra!");
    }
  }
}
