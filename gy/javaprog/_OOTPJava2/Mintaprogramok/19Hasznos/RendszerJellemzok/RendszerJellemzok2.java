/*
 * Mintaprogramok/19. fejezet
 * RendszerJellemzok2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;

public class RendszerJellemzok2 {
  public static void main(String[] args) {
    System.out.print("Java home konyvtár: ");
    System.out.println(System.getProperty("java.home"));

    System.out.print("Használó: ");
    System.out.println(System.getProperty("user.name"));

    System.out.print("Osztályútvonal: ");
    System.out.println(System.getProperty("java.class.path"));

    System.out.println("\nAz összes rendszerjellemzõ:");
    Properties prop = System.getProperties();
    prop.list(System.out);
  }
}
