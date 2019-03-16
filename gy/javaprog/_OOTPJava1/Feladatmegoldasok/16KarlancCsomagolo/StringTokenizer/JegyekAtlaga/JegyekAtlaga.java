/*
 * Feladatmegold�sok/16. fejezet
 * JegyekAtlaga.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;
import java.util.*;

public class JegyekAtlaga {
  static String atlagSzoveg(String szoveg) {
    int poz = szoveg.indexOf(':');
    if (poz < 0)
      return "";

    String ujSzoveg = szoveg.substring(0,poz)+":";    // n�v
    szoveg = szoveg.substring(poz+1,szoveg.length()); // jegyek
    StringTokenizer st = new StringTokenizer(szoveg);
    double atlag=0;
    int db = st.countTokens(); // Vigy�zat, el�tte kell megjegyezni, ut�na m�r 0!
    while (st.hasMoreTokens())
      atlag += Integer.parseInt(st.nextToken());
    atlag /= db;
    ujSzoveg = ujSzoveg+" "+Format.left(atlag,0,2);
    return ujSzoveg;
  }

  public static void main(String[] args) {
    String szoveg = "Tokaji Iv�: 2 5 3 4 4 5 5";
    System.out.println(atlagSzoveg(szoveg));
  }
}
