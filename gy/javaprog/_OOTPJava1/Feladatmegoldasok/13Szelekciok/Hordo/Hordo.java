/*
 * Feladatmegold�sok/13. fejezet
 * Hordo.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Hordo {
  public static void main(String[] args) {
    double borLiter = Console.readInt("H�ny liter bor van? ");
    double hordoSugar = Console.readInt("Hord� sugara (cm): ");
    double hordoMag = Console.readInt("Hord� magass�ga (cm): ");
    double hordoLiter = Math.pow(hordoSugar,2)*Math.PI*hordoMag/1000;

    System.out.println("\nA hord� "+Math.round(hordoLiter)+" literes.");
    if (borLiter > hordoLiter)
      System.out.println("A bor nem f�r bele a hord�ba.");
    else {
      System.out.print("A bor belef�r a hord�ba. ");
      System.out.println(Math.round(hordoLiter-borLiter)+" liter bor f�rne m�g bele!");
      System.out.println("Telitetts�g: "+Math.round(borLiter*100/hordoLiter)+"%");
    }
  }
}
