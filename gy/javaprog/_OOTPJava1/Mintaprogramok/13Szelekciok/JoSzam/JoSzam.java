/*
 * Mintaprogramok/13. fejezet
 * JoSzam.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class JoSzam {
  public static void main(String[] args) {
    double szam = Console.readDouble("Kérek egy számot: ");
    if (szam>=1000 && szam<=2000 && szam%2==0)
      System.out.println("Jó szám");
    else
      System.out.println("Nem jó szám");
  }
}
