/*
 * Feladatmegold�sok/14. fejezet
 * Diszitosor.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

public class Diszitosor {
  public static void main(String[] args) {
    String elem = Console.readLine("A d�sz�t�sor eleme: ");
    int db = Console.readInt("Ism�tl�sek sz�ma: ");
    for (int i=0; i<db; i++)
      System.out.print(elem);
    System.out.println();
  }
}
