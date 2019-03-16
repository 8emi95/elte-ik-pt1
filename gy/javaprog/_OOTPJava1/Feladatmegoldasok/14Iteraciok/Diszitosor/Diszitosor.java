/*
 * Feladatmegoldások/14. fejezet
 * Diszitosor.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;

public class Diszitosor {
  public static void main(String[] args) {
    String elem = Console.readLine("A díszítõsor eleme: ");
    int db = Console.readInt("Ismétlések száma: ");
    for (int i=0; i<db; i++)
      System.out.print(elem);
    System.out.println();
  }
}
