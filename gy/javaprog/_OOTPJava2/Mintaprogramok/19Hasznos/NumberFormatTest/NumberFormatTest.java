/*
 * Mintaprogramok/19. fejezet
 * NumberFormatTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.Locale;
import java.text.NumberFormat;

public class NumberFormatTest {
  static void lista(Locale locale) {
    System.out.println(locale.getDisplayCountry()+":");
    NumberFormat nf; // számformázó objektum

    nf = NumberFormat.getCurrencyInstance(locale);
    System.out.print("Penz: "+nf.format(9250));

    nf = NumberFormat.getNumberInstance(locale);
    System.out.print("\tSzam: "+nf.format(19827.51));

    nf = NumberFormat.getPercentInstance(locale);
    nf.setMinimumFractionDigits(2);
    nf.setMaximumFractionDigits(2);
    System.out.println("\tSzazalek: "+nf.format(0.75));
  }

  public static void main(String[] args) {
    lista(Locale.US);
    lista(Locale.getDefault());
  }
}
