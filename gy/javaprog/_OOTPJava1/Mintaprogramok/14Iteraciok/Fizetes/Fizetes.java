/*
 * Mintaprogramok/14. fejezet
 * Fizetes.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class Fizetes {
  public static void main (String args[]) {
    final int ELSOEV = 2001;
    final int UTOLSOEV = 2006;
    int fizetes = Console.readInt("Fizetés 2001-ben? ");
    for (int ev=ELSOEV+1; ev<=UTOLSOEV; ev++) {
      fizetes *= 1.12;
      System.out.println(ev+"-ben: "+fizetes);
    }
  }
}
