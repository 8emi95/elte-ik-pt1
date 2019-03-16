/*
 * Mintaprogramok/21. fejezet
 * HashSetBetuk.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.*;
import java.util.*;

public class HashSetBetuk {
  public static void main(String[] args) {
    HashSet betuk = new HashSet();
    String szoveg = Console.readLine("Szöveg = ");
    // Karakterek gyûjtése a betuk halmazban:
    for (int i=0; i<szoveg.length(); i++)
      betuk.add(new Character(szoveg.charAt(i)));

    // A betuk halmaz kiírása toString-gel:
    System.out.println(betuk);

    // A betuk halmaz kiírása elemvizsgálattal:
    for (char c=0; c<Character.MAX_VALUE; c++)
      if (betuk.contains(new Character(c)))
        System.out.print(c);
    System.out.println();
  }
}
