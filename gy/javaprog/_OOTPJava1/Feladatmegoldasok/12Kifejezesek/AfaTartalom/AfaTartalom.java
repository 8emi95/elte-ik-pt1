/*
 * Feladatmegoldások/12. fejezet
 * AfaTartalom.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;

public class AfaTartalom {
  public static void main(String[] args) {
    int afaSzazalek = Console.readInt("Hány százalékos az ÁFA? ");
    double afaTartalom = (100.0*afaSzazalek)/(100+afaSzazalek);
    System.out.println("A számla "+Format.left(afaTartalom,0,2)+" százalék forgalmi adót tartalmaz.");
  }
}
