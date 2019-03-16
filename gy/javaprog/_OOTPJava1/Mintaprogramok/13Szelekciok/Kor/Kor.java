/*
 * Mintaprogramok/13. fejezet
 * Kor.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Kor {
  public static void main(String[] args) {
    int kor = Console.readInt("Hány éves? ");

    if (kor < 14)                        // kor =   ..13
      System.out.println("Gyerek");
    else if (kor < 18)                   // kor = 14..17
      System.out.println("Fiatalkorú");
    else if (kor < 24)                   // kor = 18..24
      System.out.println("Ifjú");
    else if (kor < 60)                   // kor = 25..59
      System.out.println("Felnõtt");
    else                                 // kor = 60..
      System.out.println("Idõs");
  }
}
