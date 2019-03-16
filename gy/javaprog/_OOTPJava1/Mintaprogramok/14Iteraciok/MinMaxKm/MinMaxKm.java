/*
 * Mintaprogramok/14. fejezet
 * MinMaxKm.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class MinMaxKm {
  public static void main (String args[]) {
    int km = Console.readInt(1+". napi km: ");
    int minKm=km, maxKm=km;
    int minNap=1; int maxNap=1;
    for (int nap=2; nap<=31; nap++) {
      km = Console.readInt(nap+". napi km: ");
      if (km < minKm) {
        minNap = nap;
        minKm = km;
      }
      else if (km > maxKm) {
        maxNap = nap;
        maxKm = km;
      }
    }
    System.out.println("Legkevesebb a "+minNap+". napon "+minKm);
    System.out.println("Legtöbb     a "+maxNap+". napon "+maxKm);
  }
}
