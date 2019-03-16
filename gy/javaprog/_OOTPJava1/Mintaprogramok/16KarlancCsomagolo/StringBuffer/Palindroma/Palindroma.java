/*
 * Mintaprogramok/16. fejezet
 * Palindroma.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Palindroma {
  // str-bõl az összes kar törlése:
  static String kivesz(String str,char kar) {
    StringBuffer sb = new StringBuffer(str);
    int p;
    while ((p=sb.toString().indexOf(kar)) != -1)
      sb.deleteCharAt(p) ;
    return sb.toString();
  }

  // true, ha a szoveg palindróma:
  static boolean palindroma(String szoveg) {
    szoveg = kivesz(szoveg,' ').toUpperCase();
    StringBuffer sb = new StringBuffer(szoveg);
    return szoveg.equals(sb.reverse().toString());
  }

  public static void main (String args[]) {

    // Szövegek beolvasása és feldolgozása:
    String szoveg;
    while (!(szoveg = Console.readLine("Szöveg: ")).equals("")) {
      // Palindróma vizsgálat:
      if (palindroma(szoveg))
        System.out.println("Palindróma");
      else
        System.out.println("Nem palindróma");
    }
  }
}
