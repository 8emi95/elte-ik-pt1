/*
 * Feladatmegold�sok/18. fejezet
 * Borton.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

public class Borton {
  public static void main(String[] args) {
    // A 0. elemet nem haszn�ljuk!
    boolean[] szabad = new boolean[1001];

    // Kezdetben minden cella (1..1000) z�rva van:
    for (int i=1; i<szabad.length; i++)
      szabad[i] = false;

    // A b�rt�n�r j�t�ka:
    for (int lepes=1; lepes<szabad.length; lepes++)
      for (int i=lepes; i<szabad.length; i+=lepes)
        szabad[i] = !szabad[i];

    // A szerencs�s rabok ki�r�sa:
    System.out.println("A szerencs�s rabok cellasorsz�mai:");
    for (int i=1; i<szabad.length; i++)
      if (szabad[i])
        System.out.print(i+" ");
    System.out.println();
  }
}
