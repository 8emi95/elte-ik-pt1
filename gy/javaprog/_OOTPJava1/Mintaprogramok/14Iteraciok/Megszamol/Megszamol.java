/*
 *  Mintaprogramok/14. fejezet
 *  Megszamol.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class Megszamol {
  public static void main (String args[]) {
    final int VEGJEL = 0;
    int n = 0;
    int szam;
    while ((szam = Console.readInt("Szám: ")) != VEGJEL) {
      n++;
    }
    System.out.println("A bevitt számok száma: "+n);
  }
}
