/*
 * Feladatmegoldások/14. fejezet
 * LegKaloria1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;

public class  LegKaloria1 {
  public static void main(String[] args) {
    //Ebben a megoldásban feltételezzük, hogy 1 minimum és maximum van.
    int napiKaloria = Console.readInt("1. nap kalóriája: ");
    int min=napiKaloria , max=napiKaloria, minNap=1, maxNap=1;
    for (int nap=2; nap<=7; nap++) {
      napiKaloria = Console.readInt(nap+". nap kalóriája: ");
      if (napiKaloria<min) {
        min=napiKaloria;
        minNap=nap;
      }
      else if (napiKaloria>max) {
        max=napiKaloria;
        maxNap=nap;
      }
    }
    System.out.println("A legkevesebb kalóriát ("+min+") a "+minNap+". napon fogyasztottuk.");
    System.out.println("A legtöbb kalóriát ("+max+") a "+maxNap+". napon fogyasztottuk.");
  }
}