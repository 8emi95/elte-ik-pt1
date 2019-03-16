/*
 * Feladatmegoldások/14. fejezet
 * Terulet2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
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
      Format.left("Téglalap",20)+"t\n"+
      Format.left("Kör",20)+"k\n"+
      Format.left("Körcikk",20)+"c\n"+
      Format.left("Vége",20)+"v\n? ";
    while ((valasz = Console.readChar(menu))!='v') {
      switch (valasz) {
        case 't':
          szelesseg = Console.readDouble("Szélesség: ");
          magassag = Console.readDouble("Magasság: ");
          terulet = szelesseg*magassag;
          System.out.println("A téglalap területe: "+Format.left(terulet,0,2));
          break;
        case 'k':
          sugar = Console.readDouble("A kör sugara: ");
          terulet = Math.pow(sugar,2)*Math.PI;
          System.out.println("A kör területe: "+Format.left(terulet,0,2));
          break;
        case 'c':
          sugar = Console.readDouble("A körcikk sugara: ");
          szog = Console.readDouble("A szög fokban: ");
          terulet = Math.pow(sugar,2)*Math.PI/360*szog;
          System.out.println("A körcikk területe: "+Format.left(terulet,0,2));
          break;
      }
      System.out.println();
    }
  }
}
