/*
 * Feladatmegoldások/13. fejezet
 * Karakter1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Karakter1 {
  public static void main(String[] args) {
    char kar = Console.readChar("Karakter: ");

    boolean nagybetu = kar>='A' && kar<='Z';
    boolean kisbetu = kar>='a' && kar<='z';
    boolean szam = kar>='0' && kar<='9';
    int eltolas = 'a'-'A';

    System.out.println("\nUnikód: "+(int)kar);
    if (nagybetu) {
      System.out.println("Nagybetû");
      System.out.println("Kisbetûs forma: "+(char)(kar+eltolas));
    }
    else if (kisbetu) {
      System.out.println("Kisbetû");
      System.out.println("Nagybetûs forma: "+(char)(kar-eltolas));
    }
    else if (szam)
      System.out.println("Szám");
    else
      System.out.println("Egyéb");
  }
}
