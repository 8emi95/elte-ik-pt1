/*
 * Feladatmegold�sok/19. fejezet
 * EgyOraEltolas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

public class EgyOraEltolas {
  public static void main(String[] args) {
    // Id�z�n�k egy �ra eltol�ssal:
    String[] idozonak = TimeZone.getAvailableIDs(1*60*60*1000);
    System.out.println("Egy �ra elt�r�s� id�z�n�k azonos�t�i �s nevei");
    for (int i = 0; i < idozonak.length; i++) {
      TimeZone tz = TimeZone.getTimeZone(idozonak[i]);
      System.out.println(tz.getID()+"\t"+tz.getDisplayName());
    }
  }
}
