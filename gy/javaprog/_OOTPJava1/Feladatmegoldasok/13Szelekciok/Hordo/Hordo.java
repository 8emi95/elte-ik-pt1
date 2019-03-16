/*
 * Feladatmegoldások/13. fejezet
 * Hordo.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Hordo {
  public static void main(String[] args) {
    double borLiter = Console.readInt("Hány liter bor van? ");
    double hordoSugar = Console.readInt("Hordó sugara (cm): ");
    double hordoMag = Console.readInt("Hordó magassága (cm): ");
    double hordoLiter = Math.pow(hordoSugar,2)*Math.PI*hordoMag/1000;

    System.out.println("\nA hordó "+Math.round(hordoLiter)+" literes.");
    if (borLiter > hordoLiter)
      System.out.println("A bor nem fér bele a hordóba.");
    else {
      System.out.print("A bor belefér a hordóba. ");
      System.out.println(Math.round(hordoLiter-borLiter)+" liter bor férne még bele!");
      System.out.println("Telitettség: "+Math.round(borLiter*100/hordoLiter)+"%");
    }
  }
}
