/*
 * Feladatmegold�sok/13. fejezet
 * Karakter2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Karakter2 {
  public static void main(String[] args) {
    // megold�s a Character csomagol� oszt�llyal, l�sd 16. fejezet
    char kar = Console.readChar("Karakter: ");

    System.out.println("\nUnik�d: "+(int)kar);
    if (Character.isUpperCase(kar)) {
      System.out.println("Nagybet�");
      System.out.println("Kisbet�s forma: "+Character.toLowerCase(kar));
    }
    else if (Character.isLowerCase(kar)) {
      System.out.println("Kisbet�");
      System.out.println("Nagybet�s forma: "+Character.toUpperCase(kar));
    }
    else if (Character.isDigit(kar))
      System.out.println("Sz�m");
    else
      System.out.println("Egy�b");
  }
}
