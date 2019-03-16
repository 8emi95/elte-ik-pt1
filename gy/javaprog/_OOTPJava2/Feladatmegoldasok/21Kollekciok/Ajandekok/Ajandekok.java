/*
 * Feladatmegold�sok/21. fejezet
 * Ajandekok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.*;
import java.util.*;

public class Ajandekok {
  public static void main(String[] args) {
    TreeSet ajandekok = new TreeSet();
    String ajandek = Console.readLine("Aj�nd�k=");
    while (!ajandek.equals("")) {
      ajandekok.add(ajandek);
      ajandek = Console.readLine("Aj�nd�k=");
    }

    // Egyszer� ki�r�s:
    System.out.println("Aj�nd�kok:");
    System.out.println(ajandekok);

    // Kiir�s iter�tor seg�ts�g�vel:
    System.out.println("Aj�nd�kok:");
    Object current;
    Iterator iter = ajandekok.iterator();
    while (iter.hasNext()) {
      current = iter.next();
      System.out.println(current);
    }
  }
}
