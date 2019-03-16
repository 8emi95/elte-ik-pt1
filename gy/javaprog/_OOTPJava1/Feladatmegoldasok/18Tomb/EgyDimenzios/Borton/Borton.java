/*
 * Feladatmegoldások/18. fejezet
 * Borton.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;

public class Borton {
  public static void main(String[] args) {
    // A 0. elemet nem használjuk!
    boolean[] szabad = new boolean[1001];

    // Kezdetben minden cella (1..1000) zárva van:
    for (int i=1; i<szabad.length; i++)
      szabad[i] = false;

    // A börtönõr játéka:
    for (int lepes=1; lepes<szabad.length; lepes++)
      for (int i=lepes; i<szabad.length; i+=lepes)
        szabad[i] = !szabad[i];

    // A szerencsés rabok kiírása:
    System.out.println("A szerencsés rabok cellasorszámai:");
    for (int i=1; i<szabad.length; i++)
      if (szabad[i])
        System.out.print(i+" ");
    System.out.println();
  }
}
