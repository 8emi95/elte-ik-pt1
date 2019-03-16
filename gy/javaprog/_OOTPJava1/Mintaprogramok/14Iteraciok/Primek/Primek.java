/*
 * Mintaprogramok/14. fejezet
 * Primek.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class Primek {
  public static void main (String args[]) {
    int tol=2000, ig = 2100;
    int primekSzama = 0;
    for (int n=tol; n<=ig; n++) {
      boolean prim = true;
      for (int i=2; prim && (i<=Math.sqrt(n)); i++)
        prim = n%i!=0;
      if (prim) {
        System.out.print(n+" ");
        primekSzama++;
      }
    }
    System.out.println("\nPr�mek sz�ma: "+primekSzama);
  }
}

