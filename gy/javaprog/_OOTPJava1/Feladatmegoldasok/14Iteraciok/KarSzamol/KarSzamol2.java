/*
 * Feladatmegoldások/14. fejezet
 * KarSzamol2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class KarSzamol2 {
  public static void main (String args[]) {
    // megoldás a Character csomagoló osztállyal, lásd 16. fejezet
    char VEGJEL = '-';
    int nagy=0, kis=0, szam=0, egyeb=0;
    char kar;
    while ((kar = Console.readChar("Karakter: ")) != VEGJEL) {
      if (Character.isUpperCase(kar))
        nagy++;
      else if (Character.isLowerCase(kar))
        kis++;
      else if (Character.isDigit(kar))
        szam++;
      else
        egyeb++;
    }

    System.out.println("Nagybetûk száma: "+nagy);
    System.out.println("Kisbetûk száma: "+kis);
    System.out.println("Számjegyek száma: "+szam);
    System.out.println("Egyéb karakterek száma: "+egyeb);
  }
}
