/*
 * Mintaprogramok/16. fejezet
 * TizedespontCsere.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class TizedespontCsere {
  public static void main(String[] args) {
    double szam = Console.readDouble("Valós szám: ");
    String szamSt = String.valueOf(szam);
    System.out.println(szamSt.replace('.',','));
  }
}
