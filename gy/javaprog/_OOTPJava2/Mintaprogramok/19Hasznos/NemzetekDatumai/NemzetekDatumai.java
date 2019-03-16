/*
 * Mintaprogramok/19. fejezet
 * NemzetekDatumai.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;
import java.text.*;

public class NemzetekDatumai {
  static void datumIdoKiir(Date date, Locale locale) {
    System.out.print(locale.getDisplayCountry()+": ");
    DateFormat df = DateFormat.getDateTimeInstance(
      DateFormat.FULL,DateFormat.SHORT,locale);
    System.out.println(df.format(date));
  }

  public static void main(String[] args) {
    Locale[] nemzetek = {Locale.getDefault(), Locale.UK,
      Locale.FRANCE, Locale.ITALY};
    Date most = new Date();
    for (int i = 0; i < nemzetek.length; i++) {
      datumIdoKiir(most,nemzetek[i]);
    }
  }
}
