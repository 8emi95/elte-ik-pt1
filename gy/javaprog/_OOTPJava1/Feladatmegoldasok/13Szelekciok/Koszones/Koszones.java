/*
 * Feladatmegold�sok/13. fejezet
 * Koszones.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Koszones {
  public static void main(String[] args) {
    int ora = Console.readInt("�ra: ");
    if (ora<0 || ora>24)
      System.out.println("Ez nem �ra!");
    else if (ora>=4 && ora<=9)
      System.out.println("J� reggelt!");
    else if (ora>=10 && ora<=17)
      System.out.println("J� napot!");
    else if (ora>=18 && ora<=21)
      System.out.println("J� est�t!");
    else //if (ora>=22 && ora<=24 || ora<4)
      System.out.println("Jo �jszak�t!");
  }
}
