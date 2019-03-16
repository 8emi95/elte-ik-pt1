/*
 * Feladatmegold�sok/14. fejezet
 * Kaloria.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

public class Kaloria {
  public static void main(String[] args) {
    int napiKaloria, osszKaloria=0;

    for (int nap=1; nap<=7; nap++) {
      napiKaloria = Console.readInt(nap+". nap kal�ri�ja: ");
      osszKaloria += napiKaloria;
    }
    System.out.println("�sszes kal�ria: "+osszKaloria);
    System.out.println("Napi �tlag kal�ria: "+Format.left(osszKaloria/7.0,0,2));
  }
}
