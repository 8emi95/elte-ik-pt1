/*
 * Mintaprogramok/14. fejezet
 * FonokFizetese.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

public class FonokFizetese {
  public static void main(String[] args) {
    int fonokFiz = Console.readInt("F�n�k fizet�se : ");
    int sajatFiz = Console.readInt("Saj�t fizet�sem: ");

    if (fonokFiz > sajatFiz)
      System.out.println("Igazs�gos, de nem tetszik.");
    else if (fonokFiz < sajatFiz)
      System.out.println("Nem igazs�gos, de tetszik.");
    else
      System.out.println("Nem t�ved�s?");
  }
}
