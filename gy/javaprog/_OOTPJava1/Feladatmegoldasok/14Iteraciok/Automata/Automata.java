/*
 * Feladatmegold�sok/14. fejezet
 * Automata.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Automata {
  public static void main (String args[]) {
    int teljesOsszeg = Console.readInt("Bedoband� �sszeg: ");
    int eddigiOsszeg = 0, aktOsszeg;
    boolean kellMeg;
    do {
      boolean joCimlet;
      do {
        aktOsszeg = Console.readInt("\nBedobott �sszeg: ");
        joCimlet = aktOsszeg==10 || aktOsszeg==20 ||
          aktOsszeg==50 || aktOsszeg==100;
        if (! joCimlet)
          System.out.println("Rossz c�mlet! Visszaadott �sszeg: "+aktOsszeg);
      } while (! joCimlet);
      eddigiOsszeg += aktOsszeg;
      kellMeg = eddigiOsszeg < teljesOsszeg;
      if (kellMeg)
        System.out.println("M�g bedoband� �sszeg: "+(teljesOsszeg-eddigiOsszeg));
    } while (kellMeg);
    System.out.println("\nOK");
    if (eddigiOsszeg > teljesOsszeg)
      System.out.println("Visszaj�r� �sszeg: "+(eddigiOsszeg-teljesOsszeg));
  }
}
