/*
 * Mintaprogramok/13. fejezet
 * Kor.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Kor {
  public static void main(String[] args) {
    int kor = Console.readInt("H�ny �ves? ");

    if (kor < 14)                        // kor =   ..13
      System.out.println("Gyerek");
    else if (kor < 18)                   // kor = 14..17
      System.out.println("Fiatalkor�");
    else if (kor < 24)                   // kor = 18..24
      System.out.println("Ifj�");
    else if (kor < 60)                   // kor = 25..59
      System.out.println("Feln�tt");
    else                                 // kor = 60..
      System.out.println("Id�s");
  }
}
