/*
 * Mintaprogramok/13. fejezet
 * JoSzam.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class JoSzam {
  public static void main(String[] args) {
    double szam = Console.readDouble("K�rek egy sz�mot: ");
    if (szam>=1000 && szam<=2000 && szam%2==0)
      System.out.println("J� sz�m");
    else
      System.out.println("Nem j� sz�m");
  }
}
