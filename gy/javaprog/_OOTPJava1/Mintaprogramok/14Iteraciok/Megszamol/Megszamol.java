/*
 *  Mintaprogramok/14. fejezet
 *  Megszamol.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class Megszamol {
  public static void main (String args[]) {
    final int VEGJEL = 0;
    int n = 0;
    int szam;
    while ((szam = Console.readInt("Sz�m: ")) != VEGJEL) {
      n++;
    }
    System.out.println("A bevitt sz�mok sz�ma: "+n);
  }
}
