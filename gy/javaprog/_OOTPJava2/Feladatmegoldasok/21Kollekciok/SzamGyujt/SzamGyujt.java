/*
 * Feladatmegold�sok/21. fejezet
 * SzamGyujt.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.*;
import java.util.*;

public class SzamGyujt {
  public static void main(String[] args) {
    TreeSet szamok = new TreeSet();
    int szam;
    while ((szam = Console.readInt("Sz�m = ")) != 0) {
      szamok.add(new Integer(szam));
    }
    System.out.println(szamok);
  }
}
