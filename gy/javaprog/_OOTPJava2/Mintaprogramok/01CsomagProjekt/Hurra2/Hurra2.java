/*
 * Mintaprogramok/1. fejezet
 * Hurra2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.Console;

public class Hurra2 {
  public static void main(String[] args) {
    System.out.println("Hurra, fut a JAR...");
    int n = Console.readInt("Szam=");
    System.out.println("2*"+n+"="+2*n);
    Console.pressEnter();
  }
}
