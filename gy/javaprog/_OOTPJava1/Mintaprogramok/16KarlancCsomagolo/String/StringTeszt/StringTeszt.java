/*
 * Mintaprogramok/16. fejezet
 * StringTeszt.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class StringTeszt {
  public static void main(String[] args) {
    String szoveg = Console.readLine("Szöveg: ");

    // Kiírás fordítva                          //1
    for (int i=szoveg.length()-1; i>=0; i--)
      System.out.print(szoveg.charAt(i));
    System.out.println();

    // Nagybetûs, majd kisbetûs formák          //2
    System.out.println(szoveg.toUpperCase());
    System.out.println(szoveg.toLowerCase());

    // Elsõ 9 és utolsó 3 karakter kiírása      //3
    if (szoveg.length()>=9) // egyébként futási hiba lenne
      System.out.println(szoveg.substring(0,9));
    if (szoveg.length()>=3)  // egyébként futási hiba lenne
      System.out.println(szoveg.substring(szoveg.length()-3));

    // Az összes pont kicserélése kötõjelre     //4
    System.out.println(szoveg.replace('.','-'));
  }
}
