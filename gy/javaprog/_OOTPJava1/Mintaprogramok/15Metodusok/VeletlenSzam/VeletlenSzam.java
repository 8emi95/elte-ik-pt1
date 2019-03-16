/*
 * Mintaprogramok/15. fejezet
 * VeletlenSzam.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class VeletlenSzam {
  static int random(int also, int felso) {
    // a>b esetén a két szám felcserélése:
    if (also>felso) {
      int seged=also; also=felso; felso=seged;
    }
    return (int)(Math.random()*(felso-also+1))+also;
  }

  public static void main(String[] args) {
    final short DB = 1000;
    long osszeg = 0;
    for (int i=0; i<DB; i++)
      osszeg += random(3,12);
    System.out.println(osszeg/(float)DB);  // -> Egy eredmény: 7.541
  }
}



