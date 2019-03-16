/*
 * Mintaprogramok/19. fejezet
 * LocaleTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.Locale;

public class LocaleTest {

  public static void main(String[] args) {
    System.out.println("H betûs országok: ");
    Locale[] nemzetek = Locale.getAvailableLocales();

    for (int i = 0; i < nemzetek.length; i++) {
      if (nemzetek[i].getISO3Country().startsWith("H"))
        System.out.print(nemzetek[i].getISO3Country()+"-"+
          nemzetek[i].getDisplayCountry()+", ");
    }
    System.out.print("\nAktuális ország és nyelv: ");
    Locale loc = Locale.getDefault();
    System.out.println(loc.getCountry()+", "+loc.getLanguage());
  }
}
