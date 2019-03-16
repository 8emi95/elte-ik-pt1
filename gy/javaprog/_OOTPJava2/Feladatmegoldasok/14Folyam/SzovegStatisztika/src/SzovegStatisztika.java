/*
 * Feladatmegoldások/14. fejezet
 * Projekt: SzovegStatisztika
 * SzovegStatisztika.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class SzovegStatisztika {
  public static void main(String[] args) {
    String fNev = "c:/javaprog/lib/setjava.bat";
    TextFileStat szoveg = new TextFileStat(fNev);
    System.out.println("\n" + fNev + " statisztikai adatai:");
    try {
      System.out.println("Sorok száma: "+szoveg.sorokSzama());
      System.out.println("Szavak száma: "+szoveg.szavakSzama());
      System.out.println("Leütések száma: "+szoveg.leutesekSzama());

      int sorszam = szoveg.keres("java");
      if (sorszam >= 0)
        System.out.println("Az elsõ 'java' szó a "+sorszam+". sorban van.");
      else
        System.out.println("Nincs benne 'java' szó.");
    }
    catch (FileNotFoundException ex) {
      System.out.println("A megadott állomány ("+fNev+") nem létezik!");
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }

}
