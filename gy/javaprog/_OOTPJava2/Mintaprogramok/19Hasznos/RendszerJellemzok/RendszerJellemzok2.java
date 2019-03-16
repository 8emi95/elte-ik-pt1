/*
 * Mintaprogramok/19. fejezet
 * RendszerJellemzok2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

public class RendszerJellemzok2 {
  public static void main(String[] args) {
    System.out.print("Java home konyvt�r: ");
    System.out.println(System.getProperty("java.home"));

    System.out.print("Haszn�l�: ");
    System.out.println(System.getProperty("user.name"));

    System.out.print("Oszt�ly�tvonal: ");
    System.out.println(System.getProperty("java.class.path"));

    System.out.println("\nAz �sszes rendszerjellemz�:");
    Properties prop = System.getProperties();
    prop.list(System.out);
  }
}
