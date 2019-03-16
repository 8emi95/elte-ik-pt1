/*
 * Feladatmegoldások/12. fejezet
 * Kifejezesek1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Kifejezesek1 {
  public static void main(String[] args) {
    double a = Console.readDouble("a = ");
    double b = Console.readDouble("b = ");
    double c = Console.readDouble("c = ");
    System.out.println();

    // a) feladat:
    boolean nulla_egy_kozott = 0<=a && a<=1 ;
    System.out.println("a értéke 0 és 1 közé esik: "+nulla_egy_kozott);

    // b) feladat:
    boolean a_5_10_b_15_20_kozott = 5<=a && a<=10 && 15<=b && b<=20 ;
    System.out.println("a értéke 5 és 10, b értéke pedig 15 és 20 közé esik: "+
                        a_5_10_b_15_20_kozott);

    // c) feladat:
    boolean nemElozo = a<5 || a>10 || b<15 || b>20 ;
    System.out.println("nem igaz az elõzõ állítás: "+nemElozo);

    // d) feladat:
    boolean nem0 = a*b*c != 0 ;
    // 2. megoldás: a!=0 && b!=0 && c!=0
    System.out.println("sem a, sem b, sem c nem 0: "+nem0);

    // e) feladat:
    boolean egesz = a==Math.floor(a) ;
    // 2. megoldás: a==Math.ceil(a)
    // 3. megoldás: a==(long)a
    System.out.println("a egész: "+egesz);

    // f) feladat:
    boolean min2egesz =
      a==Math.floor(a) && b==Math.floor(b) ||
      a==Math.floor(a) && c==Math.floor(c) ||
      b==Math.floor(b) && c==Math.floor(c) ;
    System.out.println("a, b és c közül legalább 2 szám egész: "+min2egesz);

    // g) feladat:
    boolean egyikPozMasikNeg = a*b < 0 ;
    // 2. megoldás: a>0 && b<0 || a<0 && b>0
    System.out.println("a és b közül az egyik pozitív a másik negatív: "+
                        egyikPozMasikNeg);

    // h) feladat:
    boolean max2poz = a<=0 || b<=0 || c<=0 ;
    System.out.println("a és b közül legfeljebb kettõ pozitív: "+max2poz);
  }
}
