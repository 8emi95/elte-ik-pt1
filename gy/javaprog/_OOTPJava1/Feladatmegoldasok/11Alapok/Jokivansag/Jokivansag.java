/*
 * Feladatmegoldások/11. fejezet
 * Jokivansag.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Jokivansag {
  public static void main(String[] args) {
    final String NYELV = "Java";
    String nev = Console.readLine("Mi a neved? ");
    System.out.println("Kedves "+nev+"! Sikeres "+NYELV+" programozást!");
  }
}
