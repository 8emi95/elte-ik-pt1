/*
 * Mintaprogramok/16. fejezet
 * TizedespontCsere.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class TizedespontCsere {
  public static void main(String[] args) {
    double szam = Console.readDouble("Val�s sz�m: ");
    String szamSt = String.valueOf(szam);
    System.out.println(szamSt.replace('.',','));
  }
}
