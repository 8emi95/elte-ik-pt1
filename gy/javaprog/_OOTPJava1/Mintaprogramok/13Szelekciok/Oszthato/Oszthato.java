/*
 * Mintaprogramok/13. fejezet
 * Oszthato.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Oszthato {
  public static void main(String[] args) {
    int szam = Console.readInt("Adj meg egy eg�sz sz�mot: ");
    if (szam%2==0)
      System.out.println("Oszthat� 2-vel");
    if (szam%3==0)
      System.out.println("Oszthat� 3-mal");
    if (szam%5==0)
      System.out.println("Oszthat� 5-tel");
  }
}