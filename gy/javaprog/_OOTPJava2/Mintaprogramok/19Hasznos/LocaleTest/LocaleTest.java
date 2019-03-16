/*
 * Mintaprogramok/19. fejezet
 * LocaleTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.Locale;

public class LocaleTest {

  public static void main(String[] args) {
    System.out.println("H bet�s orsz�gok: ");
    Locale[] nemzetek = Locale.getAvailableLocales();

    for (int i = 0; i < nemzetek.length; i++) {
      if (nemzetek[i].getISO3Country().startsWith("H"))
        System.out.print(nemzetek[i].getISO3Country()+"-"+
          nemzetek[i].getDisplayCountry()+", ");
    }
    System.out.print("\nAktu�lis orsz�g �s nyelv: ");
    Locale loc = Locale.getDefault();
    System.out.println(loc.getCountry()+", "+loc.getLanguage());
  }
}
