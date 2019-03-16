/*
 * Mintaprogramok/14. fejezet
 * FonokFizetese.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;

public class FonokFizetese {
  public static void main(String[] args) {
    int fonokFiz = Console.readInt("Fõnök fizetése : ");
    int sajatFiz = Console.readInt("Saját fizetésem: ");

    if (fonokFiz > sajatFiz)
      System.out.println("Igazságos, de nem tetszik.");
    else if (fonokFiz < sajatFiz)
      System.out.println("Nem igazságos, de tetszik.");
    else
      System.out.println("Nem tévedés?");
  }
}
