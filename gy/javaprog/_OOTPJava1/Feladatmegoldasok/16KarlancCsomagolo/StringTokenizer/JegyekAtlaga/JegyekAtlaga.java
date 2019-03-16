/*
 * Feladatmegoldások/16. fejezet
 * JegyekAtlaga.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;
import java.util.*;

public class JegyekAtlaga {
  static String atlagSzoveg(String szoveg) {
    int poz = szoveg.indexOf(':');
    if (poz < 0)
      return "";

    String ujSzoveg = szoveg.substring(0,poz)+":";    // név
    szoveg = szoveg.substring(poz+1,szoveg.length()); // jegyek
    StringTokenizer st = new StringTokenizer(szoveg);
    double atlag=0;
    int db = st.countTokens(); // Vigyázat, elõtte kell megjegyezni, utána már 0!
    while (st.hasMoreTokens())
      atlag += Integer.parseInt(st.nextToken());
    atlag /= db;
    ujSzoveg = ujSzoveg+" "+Format.left(atlag,0,2);
    return ujSzoveg;
  }

  public static void main(String[] args) {
    String szoveg = "Tokaji Ivó: 2 5 3 4 4 5 5";
    System.out.println(atlagSzoveg(szoveg));
  }
}
