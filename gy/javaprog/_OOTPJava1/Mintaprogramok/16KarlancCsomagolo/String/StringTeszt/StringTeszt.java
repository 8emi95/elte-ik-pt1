/*
 * Mintaprogramok/16. fejezet
 * StringTeszt.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class StringTeszt {
  public static void main(String[] args) {
    String szoveg = Console.readLine("Sz�veg: ");

    // Ki�r�s ford�tva                          //1
    for (int i=szoveg.length()-1; i>=0; i--)
      System.out.print(szoveg.charAt(i));
    System.out.println();

    // Nagybet�s, majd kisbet�s form�k          //2
    System.out.println(szoveg.toUpperCase());
    System.out.println(szoveg.toLowerCase());

    // Els� 9 �s utols� 3 karakter ki�r�sa      //3
    if (szoveg.length()>=9) // egy�bk�nt fut�si hiba lenne
      System.out.println(szoveg.substring(0,9));
    if (szoveg.length()>=3)  // egy�bk�nt fut�si hiba lenne
      System.out.println(szoveg.substring(szoveg.length()-3));

    // Az �sszes pont kicser�l�se k�t�jelre     //4
    System.out.println(szoveg.replace('.','-'));
  }
}
