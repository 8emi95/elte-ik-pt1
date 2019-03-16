/*
 * Mintaprogramok/16. fejezet
 * Palindroma.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Palindroma {
  // str-b�l az �sszes kar t�rl�se:
  static String kivesz(String str,char kar) {
    StringBuffer sb = new StringBuffer(str);
    int p;
    while ((p=sb.toString().indexOf(kar)) != -1)
      sb.deleteCharAt(p) ;
    return sb.toString();
  }

  // true, ha a szoveg palindr�ma:
  static boolean palindroma(String szoveg) {
    szoveg = kivesz(szoveg,' ').toUpperCase();
    StringBuffer sb = new StringBuffer(szoveg);
    return szoveg.equals(sb.reverse().toString());
  }

  public static void main (String args[]) {

    // Sz�vegek beolvas�sa �s feldolgoz�sa:
    String szoveg;
    while (!(szoveg = Console.readLine("Sz�veg: ")).equals("")) {
      // Palindr�ma vizsg�lat:
      if (palindroma(szoveg))
        System.out.println("Palindr�ma");
      else
        System.out.println("Nem palindr�ma");
    }
  }
}
