/*
 * Mintaprogramok/21. fejezet
 * Szavak.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2004.09.01.
 */

import java.util.*;

public class TreeSetSzavak {
  public static void main(String[] args) {
    String szoveg = "Itt is, ott is, amott is.";
    TreeSet szavak = new TreeSet();
    StringTokenizer st =
        new StringTokenizer(szoveg," .,\t\n\r\f");
    while (st.hasMoreTokens())
      szavak.add(st.nextToken());

    System.out.println(szavak);
  }
}
