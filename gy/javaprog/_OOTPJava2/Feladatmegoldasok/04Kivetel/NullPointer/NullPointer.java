/*
 * Feladatmegold�sok/4. fejezet
 * NullPointer.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.*;

public class NullPointer {

  static void nullTermeszetes() {
    Object obj = null;
    obj.toString();
  }

  static void nullMesterseges() {
    throw new NullPointerException();
  }

  public static void main (String args[]) {
    // a)
    nullTermeszetes();
    // b)
    //nullMesterseges();
  }
}
