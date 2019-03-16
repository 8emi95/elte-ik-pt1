/*
 * Mintaprogramok/13. fejezet
 * MiIgaz.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class MiIgaz {
  public static void main(String[] args) {
    int szam = Console.readInt("Sz�m= ");
    boolean allitas1 = szam >=50 && szam <= 150;
    boolean allitas2 = szam%2==1 && Math.pow(szam,5)<1E9;

    if (allitas1 && !allitas2)
      System.out.println("Csak az 1. �ll�t�s igaz");
    else if (!allitas1 && allitas2)
      System.out.println("Csak a 2. �ll�t�s igaz");
    else if (allitas1 && allitas2)
      System.out.println("Mindk�t �ll�t�s igaz");
    else
      System.out.println("Egyik �ll�t�s sem igaz");
  }
}
