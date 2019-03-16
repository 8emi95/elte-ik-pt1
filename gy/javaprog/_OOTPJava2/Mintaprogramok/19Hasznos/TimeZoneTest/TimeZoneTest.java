/*
 * Mintaprogramok/19. fejezet
 * TimeZoneTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

public class TimeZoneTest {
  public static void main(String[] args) {
    TimeZone tz = TimeZone.getDefault();
    System.out.println("\nHelyi id�z�na");
    System.out.println(" azonos�t�ja : "+tz.getID());
    System.out.println(" neve        : "+tz.getDisplayName());

    Date date = new Date();
    System.out.println("\nId�pont: "+date);
    if (tz.inDaylightTime(date))
      System.out.println("Ny�ri id�sz�m�t�s van.");
    else
      System.out.println("T�li id�sz�m�t�s van.");
  }
}
