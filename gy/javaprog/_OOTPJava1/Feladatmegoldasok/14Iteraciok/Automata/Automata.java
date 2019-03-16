/*
 * Feladatmegoldások/14. fejezet
 * Automata.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Automata {
  public static void main (String args[]) {
    int teljesOsszeg = Console.readInt("Bedobandó összeg: ");
    int eddigiOsszeg = 0, aktOsszeg;
    boolean kellMeg;
    do {
      boolean joCimlet;
      do {
        aktOsszeg = Console.readInt("\nBedobott összeg: ");
        joCimlet = aktOsszeg==10 || aktOsszeg==20 ||
          aktOsszeg==50 || aktOsszeg==100;
        if (! joCimlet)
          System.out.println("Rossz címlet! Visszaadott összeg: "+aktOsszeg);
      } while (! joCimlet);
      eddigiOsszeg += aktOsszeg;
      kellMeg = eddigiOsszeg < teljesOsszeg;
      if (kellMeg)
        System.out.println("Még bedobandó összeg: "+(teljesOsszeg-eddigiOsszeg));
    } while (kellMeg);
    System.out.println("\nOK");
    if (eddigiOsszeg > teljesOsszeg)
      System.out.println("Visszajáró összeg: "+(eddigiOsszeg-teljesOsszeg));
  }
}
