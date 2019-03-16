/*
 * Feladatmegoldások/4. fejezet
 * Indexeles.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.*;

public class Indexeles {

  static void index() {
    int[] t = new int[2];
    t[5] = 4;
  }

  public static void main (String[] args) {
    try {
      index();
    }
    catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Ejnye, bejnye, indexelj már rendesen!" );
    }
    System.out.println("Na jó, azért folytatom..." );
  }
}
