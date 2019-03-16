/*
 * Feladatmegoldások/19. fejezet
 * NyelvOrszagSzam.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;
import java.text.*;

public class NyelvOrszagSzam {
  public static void main(String[] args) {
    String[] orszagok = Locale.getISOCountries();
    String[] nyelvek = Locale.getISOLanguages();

    // Nyelvek kétkarakteres azonosítói:
    System.out.println("\nNyelvek kétkarakteres azonosítói:");
    for (int i = 0; i < nyelvek.length; i++) {
      System.out.print(nyelvek[i]+" ");
    }

    // Országok kétkarakteres azonosítói:
    System.out.println("\nOrszágok kétkarakteres azonosítói:");
    for (int i = 0; i < orszagok.length; i++) {
      System.out.print(orszagok[i]+" ");
    }

    // Számábrázolás minden elérhetõ Locale-ra:
    System.out.println("\nSzámábrázolások:");
    Locale[] nemzetek = NumberFormat.getAvailableLocales();
    NumberFormat nf;
    for (int i = 0; i < nemzetek.length; i++) {
      nf = NumberFormat.getNumberInstance(nemzetek[i]);
      System.out.println(nemzetek[i]+": "+nf.format(19566.6));
    }
  } // main
} // NyelvOrszagSzam
