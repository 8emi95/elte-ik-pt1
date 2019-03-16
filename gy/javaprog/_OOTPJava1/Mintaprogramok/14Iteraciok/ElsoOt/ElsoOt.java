/* 
 * Mintaprogramok/14. fejezet
 * ElsoOt.java 
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class ElsoOt {
  public static void main (String args[]) {
    for (int i=0, szam=200; i<5; i++, szam+=17)
      System.out.print(szam+" ");
  }
} 

