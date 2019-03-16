/*
 * Feladatmegold�sok/14. fejezet
 * Projekt: SzovegStatisztika
 * SzovegStatisztika.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;

public class SzovegStatisztika {
  public static void main(String[] args) {
    String fNev = "c:/javaprog/lib/setjava.bat";
    TextFileStat szoveg = new TextFileStat(fNev);
    System.out.println("\n" + fNev + " statisztikai adatai:");
    try {
      System.out.println("Sorok sz�ma: "+szoveg.sorokSzama());
      System.out.println("Szavak sz�ma: "+szoveg.szavakSzama());
      System.out.println("Le�t�sek sz�ma: "+szoveg.leutesekSzama());

      int sorszam = szoveg.keres("java");
      if (sorszam >= 0)
        System.out.println("Az els� 'java' sz� a "+sorszam+". sorban van.");
      else
        System.out.println("Nincs benne 'java' sz�.");
    }
    catch (FileNotFoundException ex) {
      System.out.println("A megadott �llom�ny ("+fNev+") nem l�tezik!");
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }

}
