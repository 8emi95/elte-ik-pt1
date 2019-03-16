/*
 * Mintaprogramok/14. fejezet
 * KisNagyABC.java 
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class KisNagyABC {
  public static void main (String args[]) {
    for (char kis='a',nagy='A'; kis<='z'; kis++, nagy++)
      System.out.print(kis+""+nagy+" ");
  }
}
