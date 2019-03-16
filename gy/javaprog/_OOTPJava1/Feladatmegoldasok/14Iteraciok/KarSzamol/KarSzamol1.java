/*
 * Feladatmegoldások/14. fejezet
 * KarSzamol1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class KarSzamol1 {
  public static void main (String args[]) {
    char VEGJEL = '-';
    int nagy=0, kis=0, szam=0, egyeb=0;
    char kar;
    while ((kar = Console.readChar("Karakter: ")) != VEGJEL) {
      if (kar>='A' && kar<='Z')
        nagy++;
      else if (kar>='a' && kar<='z')
        kis++;
      else if (kar>='0' && kar<='9')
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
