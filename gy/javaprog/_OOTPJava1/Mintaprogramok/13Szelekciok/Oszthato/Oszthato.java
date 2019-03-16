/*
 * Mintaprogramok/13. fejezet
 * Oszthato.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Oszthato {
  public static void main(String[] args) {
    int szam = Console.readInt("Adj meg egy egész számot: ");
    if (szam%2==0)
      System.out.println("Osztható 2-vel");
    if (szam%3==0)
      System.out.println("Osztható 3-mal");
    if (szam%5==0)
      System.out.println("Osztható 5-tel");
  }
}