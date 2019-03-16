/*
 * Feladatmegoldások/21. fejezet
 * SzamGyujt.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.*;
import java.util.*;

public class SzamGyujt {
  public static void main(String[] args) {
    TreeSet szamok = new TreeSet();
    int szam;
    while ((szam = Console.readInt("Szám = ")) != 0) {
      szamok.add(new Integer(szam));
    }
    System.out.println(szamok);
  }
}
