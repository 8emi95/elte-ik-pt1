/*
 * Mintaprogramok/13. fejezet
 * MiIgaz.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class MiIgaz {
  public static void main(String[] args) {
    int szam = Console.readInt("Szám= ");
    boolean allitas1 = szam >=50 && szam <= 150;
    boolean allitas2 = szam%2==1 && Math.pow(szam,5)<1E9;

    if (allitas1 && !allitas2)
      System.out.println("Csak az 1. állítás igaz");
    else if (!allitas1 && allitas2)
      System.out.println("Csak a 2. állítás igaz");
    else if (allitas1 && allitas2)
      System.out.println("Mindkét állítás igaz");
    else
      System.out.println("Egyik állítás sem igaz");
  }
}
