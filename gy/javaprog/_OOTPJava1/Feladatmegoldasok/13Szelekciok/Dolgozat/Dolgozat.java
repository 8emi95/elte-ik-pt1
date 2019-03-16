/*
 * Feladatmegold�sok/13. fejezet
 * Dolgozat.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Dolgozat {
  public static void main(String[] args) {
    int pontszam = Console.readInt("Pontsz�m (0..55): ");
    if (pontszam<0 || pontszam>55)
      System.out.println("Ez nem val�di pontsz�m!");
    else if (pontszam>=0 && pontszam<=29)
      System.out.println("Oszt�lyzat: el�gtelen (1)");
    else if (pontszam>=30 && pontszam<=37)
      System.out.println("Oszt�lyzat: el�gs�ges (2)");
    else if (pontszam>=38 && pontszam<=43)
      System.out.println("Oszt�lyzat: k�zepes (3)");
    else if (pontszam>=44 && pontszam<=49)
      System.out.println("Oszt�lyzat: j� (4)");
    else //if (pontszam>=50 && pontszam<=55)
      System.out.println("Oszt�lyzat: jeles (5)");
  }
}
