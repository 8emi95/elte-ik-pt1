/*
 * Feladatmegoldások/19. fejezet
 * EgyOraEltolas.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;

public class EgyOraEltolas {
  public static void main(String[] args) {
    // Idõzónák egy óra eltolással:
    String[] idozonak = TimeZone.getAvailableIDs(1*60*60*1000);
    System.out.println("Egy óra eltérésû idõzónák azonosítói és nevei");
    for (int i = 0; i < idozonak.length; i++) {
      TimeZone tz = TimeZone.getTimeZone(idozonak[i]);
      System.out.println(tz.getID()+"\t"+tz.getDisplayName());
    }
  }
}
