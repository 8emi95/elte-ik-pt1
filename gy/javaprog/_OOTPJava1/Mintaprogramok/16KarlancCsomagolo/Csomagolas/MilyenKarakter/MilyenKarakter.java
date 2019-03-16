/*
 * Mintaprogramok/16. fejezet
 * MilyenKarakter.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class MilyenKarakter {

  public static void main(String[] args) {

    char kar = Console.readChar("Karakter:");
    while (kar != '-') {
      if (Character.isDigit(kar))
        System.out.println("Sz�m");
      else if (Character.isLetter(kar)) {
        if (Character.isUpperCase(kar))
          System.out.println("Nagybet�");
        else
          System.out.println("Kisbet�");
      }
      else if (Character.isSpaceChar(kar))
        System.out.println("Sz�k�z");
      else if (Character.isWhitespace(kar))
        System.out.println("Feh�r sz�k�z");
      else
        System.out.println("Egy�b");
      kar = Console.readChar("Karakter:");
    }
  }
}
