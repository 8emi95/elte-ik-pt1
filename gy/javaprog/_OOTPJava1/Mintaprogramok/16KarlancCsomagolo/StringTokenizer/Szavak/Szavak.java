/*
 * Mintaprogramok/16. fejezet
 * Szavak.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;
import java.util.*;

public class Szavak {
  public static void main(String[] args) {
    String mondat = Console.readLine("Mondat: ");
    StringTokenizer st = new StringTokenizer(mondat);

    System.out.println("Szavak száma: "+st.countTokens());

    int sorszam = 0;
    while (st.hasMoreTokens())
      System.out.println(++sorszam+": "+st.nextToken());
  }
}
