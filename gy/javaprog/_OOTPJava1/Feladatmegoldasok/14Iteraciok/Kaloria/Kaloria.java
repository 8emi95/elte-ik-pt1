/*
 * Feladatmegoldások/14. fejezet
 * Kaloria.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;

public class Kaloria {
  public static void main(String[] args) {
    int napiKaloria, osszKaloria=0;

    for (int nap=1; nap<=7; nap++) {
      napiKaloria = Console.readInt(nap+". nap kalóriája: ");
      osszKaloria += napiKaloria;
    }
    System.out.println("Összes kalória: "+osszKaloria);
    System.out.println("Napi átlag kalória: "+Format.left(osszKaloria/7.0,0,2));
  }
}
