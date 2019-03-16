/*
 * Feladatmegoldások/13. fejezet
 * Koszones.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Koszones {
  public static void main(String[] args) {
    int ora = Console.readInt("Óra: ");
    if (ora<0 || ora>24)
      System.out.println("Ez nem óra!");
    else if (ora>=4 && ora<=9)
      System.out.println("Jó reggelt!");
    else if (ora>=10 && ora<=17)
      System.out.println("Jó napot!");
    else if (ora>=18 && ora<=21)
      System.out.println("Jó estét!");
    else //if (ora>=22 && ora<=24 || ora<4)
      System.out.println("Jo éjszakát!");
  }
}
