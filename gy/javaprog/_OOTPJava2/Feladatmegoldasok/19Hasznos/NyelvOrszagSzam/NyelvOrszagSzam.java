/*
 * Feladatmegold�sok/19. fejezet
 * NyelvOrszagSzam.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;
import java.text.*;

public class NyelvOrszagSzam {
  public static void main(String[] args) {
    String[] orszagok = Locale.getISOCountries();
    String[] nyelvek = Locale.getISOLanguages();

    // Nyelvek k�tkarakteres azonos�t�i:
    System.out.println("\nNyelvek k�tkarakteres azonos�t�i:");
    for (int i = 0; i < nyelvek.length; i++) {
      System.out.print(nyelvek[i]+" ");
    }

    // Orsz�gok k�tkarakteres azonos�t�i:
    System.out.println("\nOrsz�gok k�tkarakteres azonos�t�i:");
    for (int i = 0; i < orszagok.length; i++) {
      System.out.print(orszagok[i]+" ");
    }

    // Sz�m�br�zol�s minden el�rhet� Locale-ra:
    System.out.println("\nSz�m�br�zol�sok:");
    Locale[] nemzetek = NumberFormat.getAvailableLocales();
    NumberFormat nf;
    for (int i = 0; i < nemzetek.length; i++) {
      nf = NumberFormat.getNumberInstance(nemzetek[i]);
      System.out.println(nemzetek[i]+": "+nf.format(19566.6));
    }
  } // main
} // NyelvOrszagSzam
