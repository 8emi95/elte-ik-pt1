/*
 * Mintaprogramok/21. fejezet
 * Orszagok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

public class Orszagok {
  public static void main(String[] args) {
    String[] nevek =
        {"USA","Lengyelorsz�g","Nep�l","Magyarorsz�g","Kuba"};

    HashSet orszagok = new HashSet();
    for (int i = 0; i < nevek.length; i++)
      orszagok.add(nevek[i]);

    System.out.println(orszagok);

    // Kiir�s iter�tor seg�ts�g�vel:
    System.out.println("Orsz�gok:");
    Iterator iter = orszagok.iterator();
    while (iter.hasNext())
      System.out.println(iter.next());
  }
}
