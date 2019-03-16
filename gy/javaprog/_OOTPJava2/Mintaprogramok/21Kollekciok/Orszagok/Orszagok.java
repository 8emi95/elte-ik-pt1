/*
 * Mintaprogramok/21. fejezet
 * Orszagok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;

public class Orszagok {
  public static void main(String[] args) {
    String[] nevek =
        {"USA","Lengyelország","Nepál","Magyarország","Kuba"};

    HashSet orszagok = new HashSet();
    for (int i = 0; i < nevek.length; i++)
      orszagok.add(nevek[i]);

    System.out.println(orszagok);

    // Kiirás iterátor segítségével:
    System.out.println("Országok:");
    Iterator iter = orszagok.iterator();
    while (iter.hasNext())
      System.out.println(iter.next());
  }
}
