/*
 * Mintaprogramok/14. fejezet
 * KisNagyABC.java 
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class KisNagyABC {
  public static void main (String args[]) {
    for (char kis='a',nagy='A'; kis<='z'; kis++, nagy++)
      System.out.print(kis+""+nagy+" ");
  }
}
