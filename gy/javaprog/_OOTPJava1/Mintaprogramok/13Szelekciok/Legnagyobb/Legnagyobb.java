/*
 * Mintaprogramok/13. fejezet
 * Legnagyobb.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Legnagyobb {
  public static void main(String[] args) {
    int szam1, szam2, szam3;
    int legnagyobb;
    szam1 = Console.readInt("1. szám: ");
    szam2 = Console.readInt("2. szám: ");
    szam3 = Console.readInt("3. szám: ");
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

    System.out.println("A legnagyobb szám: "+ legnagyobb);
  }
}
