/*
 * Feladatmegoldások/21. fejezet
 * Ajandekok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.*;
import java.util.*;

public class Ajandekok {
  public static void main(String[] args) {
    TreeSet ajandekok = new TreeSet();
    String ajandek = Console.readLine("Ajándék=");
    while (!ajandek.equals("")) {
      ajandekok.add(ajandek);
      ajandek = Console.readLine("Ajándék=");
    }

    // Egyszerû kiírás:
    System.out.println("Ajándékok:");
    System.out.println(ajandekok);

    // Kiirás iterátor segítségével:
    System.out.println("Ajándékok:");
    Object current;
    Iterator iter = ajandekok.iterator();
    while (iter.hasNext()) {
      current = iter.next();
      System.out.println(current);
    }
  }
}
