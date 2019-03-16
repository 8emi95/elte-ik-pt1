/*
 * Feladatmegoldások/13. fejezet
 * Karakter2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Karakter2 {
  public static void main(String[] args) {
    // megoldás a Character csomagoló osztállyal, lásd 16. fejezet
    char kar = Console.readChar("Karakter: ");

    System.out.println("\nUnikód: "+(int)kar);
    if (Character.isUpperCase(kar)) {
      System.out.println("Nagybetû");
      System.out.println("Kisbetûs forma: "+Character.toLowerCase(kar));
    }
    else if (Character.isLowerCase(kar)) {
      System.out.println("Kisbetû");
      System.out.println("Nagybetûs forma: "+Character.toUpperCase(kar));
    }
    else if (Character.isDigit(kar))
      System.out.println("Szám");
    else
      System.out.println("Egyéb");
  }
}
