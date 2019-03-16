/*
 * Feladatmegold�sok/14. fejezet
 * Terulet2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Terulet2 {
  public static void main (String args[]) {
    char valasz;
    double sugar, szog;
    double szelesseg, magassag;
    double terulet;
    final String menu=
      Format.left("T�glalap",20)+"t\n"+
      Format.left("K�r",20)+"k\n"+
      Format.left("K�rcikk",20)+"c\n"+
      Format.left("V�ge",20)+"v\n? ";
    while ((valasz = Console.readChar(menu))!='v') {
      switch (valasz) {
        case 't':
          szelesseg = Console.readDouble("Sz�less�g: ");
          magassag = Console.readDouble("Magass�g: ");
          terulet = szelesseg*magassag;
          System.out.println("A t�glalap ter�lete: "+Format.left(terulet,0,2));
          break;
        case 'k':
          sugar = Console.readDouble("A k�r sugara: ");
          terulet = Math.pow(sugar,2)*Math.PI;
          System.out.println("A k�r ter�lete: "+Format.left(terulet,0,2));
          break;
        case 'c':
          sugar = Console.readDouble("A k�rcikk sugara: ");
          szog = Console.readDouble("A sz�g fokban: ");
          terulet = Math.pow(sugar,2)*Math.PI/360*szog;
          System.out.println("A k�rcikk ter�lete: "+Format.left(terulet,0,2));
          break;
      }
      System.out.println();
    }
  }
}
