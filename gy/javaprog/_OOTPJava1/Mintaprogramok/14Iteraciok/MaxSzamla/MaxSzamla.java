/*
 * Mintaprogramok/14. fejezet
 * MaxSzamla.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class MaxSzamla {
  public static void main (String args[]) {
    double maxOsszeg = 0, osszeg;
    int maxSorszam=0, sorszam=0;
    System.out.println("Összegek (vége=0)");
    while ((osszeg=Console.readDouble("? ")) != 0) {
      sorszam++;
      if (osszeg > maxOsszeg) {
        maxOsszeg = osszeg;
        maxSorszam = sorszam;
      }
    }
    if (maxOsszeg == 0)
      System.out.println("Nincs számla!");
    else {
      System.out.print("A maximális számla összege: "+
        Format.left(maxOsszeg,0,2));
      System.out.println(", sorszáma: "+maxSorszam);
    }
  }
}
