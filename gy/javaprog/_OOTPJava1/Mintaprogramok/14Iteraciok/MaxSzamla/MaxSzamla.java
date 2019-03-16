/*
 * Mintaprogramok/14. fejezet
 * MaxSzamla.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class MaxSzamla {
  public static void main (String args[]) {
    double maxOsszeg = 0, osszeg;
    int maxSorszam=0, sorszam=0;
    System.out.println("�sszegek (v�ge=0)");
    while ((osszeg=Console.readDouble("? ")) != 0) {
      sorszam++;
      if (osszeg > maxOsszeg) {
        maxOsszeg = osszeg;
        maxSorszam = sorszam;
      }
    }
    if (maxOsszeg == 0)
      System.out.println("Nincs sz�mla!");
    else {
      System.out.print("A maxim�lis sz�mla �sszege: "+
        Format.left(maxOsszeg,0,2));
      System.out.println(", sorsz�ma: "+maxSorszam);
    }
  }
}
