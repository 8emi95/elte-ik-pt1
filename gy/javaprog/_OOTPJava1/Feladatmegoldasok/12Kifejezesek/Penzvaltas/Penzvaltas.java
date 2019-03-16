/*
 * Feladatmegold�sok/12. fejezet
 * Penzvaltas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Penzvaltas {
  public static void main(String[] args) {
    int osszeg;
    int cimlet5000, cimlet1000, cimlet500, cimlet100;

    osszeg = Console.readInt("�rjon be egy �sszeget: ");

    cimlet5000 = osszeg / 5000;
    osszeg = osszeg % 5000;

    cimlet1000 = osszeg / 1000;
    osszeg = osszeg % 1000;

    cimlet500 = osszeg / 500;
    osszeg = osszeg % 500;

    cimlet100 = osszeg / 100;
    osszeg = osszeg % 100;

    System.out.println("C�mlet Darabsz�m");
    System.out.println("5000:     "+cimlet5000);
    System.out.println("1000:     "+cimlet1000);
    System.out.println(" 500:     "+cimlet500);
    System.out.println(" 100:     "+cimlet100);
    System.out.println("Aj�nd�k: "+osszeg+" Ft");
  }
}
