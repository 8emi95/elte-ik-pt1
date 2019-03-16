/*
 * Mintaprogramok/21. fejezet
 * HashSetBetuk.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.*;
import java.util.*;

public class HashSetBetuk {
  public static void main(String[] args) {
    HashSet betuk = new HashSet();
    String szoveg = Console.readLine("Sz�veg = ");
    // Karakterek gy�jt�se a betuk halmazban:
    for (int i=0; i<szoveg.length(); i++)
      betuk.add(new Character(szoveg.charAt(i)));

    // A betuk halmaz ki�r�sa toString-gel:
    System.out.println(betuk);

    // A betuk halmaz ki�r�sa elemvizsg�lattal:
    for (char c=0; c<Character.MAX_VALUE; c++)
      if (betuk.contains(new Character(c)))
        System.out.print(c);
    System.out.println();
  }
}
