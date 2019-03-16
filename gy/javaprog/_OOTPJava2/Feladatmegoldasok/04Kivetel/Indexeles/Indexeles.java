/*
 * Feladatmegold�sok/4. fejezet
 * Indexeles.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
      System.out.println("Ejnye, bejnye, indexelj m�r rendesen!" );
    }
    System.out.println("Na j�, az�rt folytatom..." );
  }
}
