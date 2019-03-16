/*
 * Feladatmegold�sok/13. fejezet
 * Karakter1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Karakter1 {
  public static void main(String[] args) {
    char kar = Console.readChar("Karakter: ");

    boolean nagybetu = kar>='A' && kar<='Z';
    boolean kisbetu = kar>='a' && kar<='z';
    boolean szam = kar>='0' && kar<='9';
    int eltolas = 'a'-'A';

    System.out.println("\nUnik�d: "+(int)kar);
    if (nagybetu) {
      System.out.println("Nagybet�");
      System.out.println("Kisbet�s forma: "+(char)(kar+eltolas));
    }
    else if (kisbetu) {
      System.out.println("Kisbet�");
      System.out.println("Nagybet�s forma: "+(char)(kar-eltolas));
    }
    else if (szam)
      System.out.println("Sz�m");
    else
      System.out.println("Egy�b");
  }
}
