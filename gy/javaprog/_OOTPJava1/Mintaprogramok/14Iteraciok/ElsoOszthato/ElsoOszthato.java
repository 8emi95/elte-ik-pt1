/*
 * Mintaprogramok/14. fejezet
 * ElsoOszthato.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class ElsoOszthato {
  public static void main (String args[]) {
    int kezd=5000, veg=7000, oszto=1797, szam;
    boolean van = false;
    for (szam=kezd; szam<=veg; szam++)
      if (szam%oszto==0) {
        van = true;
        break;
      }
    if (van)
      System.out.println("Az elsõ "+oszto+"-vel osztható szám: "+szam);
    else
      System.out.println("Nincs ilyen");
  }
}
