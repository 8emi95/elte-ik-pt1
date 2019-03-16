/*
 * Feladatmegold�sok/19. fejezet
 * Formazas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;
import java.text.*;

public class Formazas {
  // Visszaadja az adott orsz�g (country) k�rnyezet�t:
  static Locale getLocale(String country) {
    Locale[] nemzetek = Locale.getAvailableLocales();
    for (int i = 0; i < nemzetek.length; i++) {
      if (nemzetek[i].getCountry().equals(country))
        return nemzetek[i];
    }
    return Locale.getDefault();
  }

  // main:
  public static void main(String[] args) {
    NumberFormat nf; // form�z� objektum

    // 7566512.77 sz�m amerikai, francia �s magyar k�rnyezetben:
    double szam = 7566512.77;
    nf = NumberFormat.getNumberInstance(Locale.US);
    System.out.println("Amerikai szam: "+nf.format(szam));

    nf = NumberFormat.getNumberInstance(Locale.FRANCE);
    System.out.println("Francia szam: "+nf.format(szam));

    // Locale.HUNGARY konstans nincsen:
    nf = NumberFormat.getNumberInstance(new Locale("hu","HU"));
    System.out.println("Magyar szam: "+nf.format(szam));

    // 46.5 sz�zal�k n�met, olasz �s magyar k�rnyezetben:
    double szazalek = 46.5;
    nf = NumberFormat.getPercentInstance(Locale.GERMANY);
    System.out.println("\nNemet szazalek: "+nf.format(szazalek));

    nf = NumberFormat.getPercentInstance(Locale.ITALY);
    System.out.println("Olasz szazalek: "+nf.format(szazalek));

    nf = NumberFormat.getPercentInstance();
    System.out.println("Magyar szazalek: "+nf.format(szazalek));

    // 28 milli� egys�gnyi p�nz amerikai, sv�d �s magyar k�rnyezetben:
    double penz = 28000000;
    nf = NumberFormat.getCurrencyInstance(Locale.US);
    System.out.println("\nMagyar penzforma: "+nf.format(penz));

    // �rtunk egy met�dust az SV-hez tartoz� Locale kikeres�s�re:
    nf = NumberFormat.getCurrencyInstance(getLocale("SV"));
    System.out.println("Sved penzforma: "+nf.format(penz));

    nf = NumberFormat.getCurrencyInstance(); // magyar az alap�rtelmezett
    System.out.println("Magyar penzforma: "+nf.format(penz));

   // Mai d�tum amerikai, rom�n �s magyar k�rnyezetben:
   Date datum = new Date();
   DateFormat df;
   df = DateFormat.getDateInstance(DateFormat.FULL,Locale.US);
   System.out.println("\nAmerikai datum: "+df.format(datum));

   df = DateFormat.getDateInstance(DateFormat.FULL,getLocale("RO"));
   System.out.println("Roman datum: "+df.format(datum));

   df = DateFormat.getDateInstance(DateFormat.FULL);
   System.out.println("Magyar datum: "+df.format(datum));
  }
}
