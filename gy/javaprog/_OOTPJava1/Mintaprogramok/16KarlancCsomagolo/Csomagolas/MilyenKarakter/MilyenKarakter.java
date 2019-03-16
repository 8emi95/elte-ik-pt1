/*
 * Mintaprogramok/16. fejezet
 * MilyenKarakter.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class MilyenKarakter {

  public static void main(String[] args) {

    char kar = Console.readChar("Karakter:");
    while (kar != '-') {
      if (Character.isDigit(kar))
        System.out.println("Szám");
      else if (Character.isLetter(kar)) {
        if (Character.isUpperCase(kar))
          System.out.println("Nagybetû");
        else
          System.out.println("Kisbetû");
      }
      else if (Character.isSpaceChar(kar))
        System.out.println("Szóköz");
      else if (Character.isWhitespace(kar))
        System.out.println("Fehér szóköz");
      else
        System.out.println("Egyéb");
      kar = Console.readChar("Karakter:");
    }
  }
}
