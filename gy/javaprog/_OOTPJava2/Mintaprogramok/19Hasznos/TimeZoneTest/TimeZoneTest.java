/*
 * Mintaprogramok/19. fejezet
 * TimeZoneTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;

public class TimeZoneTest {
  public static void main(String[] args) {
    TimeZone tz = TimeZone.getDefault();
    System.out.println("\nHelyi idõzóna");
    System.out.println(" azonosítója : "+tz.getID());
    System.out.println(" neve        : "+tz.getDisplayName());

    Date date = new Date();
    System.out.println("\nIdõpont: "+date);
    if (tz.inDaylightTime(date))
      System.out.println("Nyári idõszámítás van.");
    else
      System.out.println("Téli idõszámítás van.");
  }
}
