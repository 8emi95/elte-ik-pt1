/*
 * Mintaprogramok/13. fejezet
 * Legnagyobb.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Legnagyobb {
  public static void main(String[] args) {
    int szam1, szam2, szam3;
    int legnagyobb;
    szam1 = Console.readInt("1. sz�m: ");
    szam2 = Console.readInt("2. sz�m: ");
    szam3 = Console.readInt("3. sz�m: ");
    if (szam1 > szam2)
      if (szam1>szam3)
        legnagyobb = szam1;
      else
        legnagyobb = szam3;
    else
      if (szam2>szam3)
        legnagyobb = szam2;
      else
        legnagyobb = szam3;

    System.out.println("A legnagyobb sz�m: "+ legnagyobb);
  }
}
