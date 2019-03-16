/*
 * Feladatmegold�sok/12. fejezet
 * AfaTartalom.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

public class AfaTartalom {
  public static void main(String[] args) {
    int afaSzazalek = Console.readInt("H�ny sz�zal�kos az �FA? ");
    double afaTartalom = (100.0*afaSzazalek)/(100+afaSzazalek);
    System.out.println("A sz�mla "+Format.left(afaTartalom,0,2)+" sz�zal�k forgalmi ad�t tartalmaz.");
  }
}
