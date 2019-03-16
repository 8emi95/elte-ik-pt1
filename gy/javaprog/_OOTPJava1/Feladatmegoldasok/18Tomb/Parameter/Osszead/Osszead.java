/* 
 * Feladatmegoldások/18. fejezet
 * Osszead.java 
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*; 

public class Osszead {
  public static void main(String[] args) {
    double osszeg=0;
    double szam;
    for (int i=0; i<args.length; i++) {
      szam = Double.parseDouble(args[i]);
      osszeg += szam; 
      System.out.println(Format.right(szam,10,2));
    }
    System.out.println("----------");
    System.out.println(Format.right(osszeg,10,2));
  }
}
