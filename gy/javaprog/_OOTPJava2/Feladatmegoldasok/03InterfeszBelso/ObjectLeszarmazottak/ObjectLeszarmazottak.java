/*
 * Feladatmegold�sok/3. fejezet
 * ObjectLeszarmazottak.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

public class ObjectLeszarmazottak {
  public static void main(String[] args) {
    Vector objektumok = new Vector();

    objektumok.add(new Object() {
      public String toString() {
        return "Bolha";
      }
    });
    objektumok.add(new Object() {
      public String toString() {
        return "Piac";
      }
    });
    System.out.println(objektumok);
  }
}
