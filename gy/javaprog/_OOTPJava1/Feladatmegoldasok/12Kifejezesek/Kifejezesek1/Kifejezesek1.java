/*
 * Feladatmegold�sok/12. fejezet
 * Kifejezesek1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
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
    System.out.println("a �rt�ke 0 �s 1 k�z� esik: "+nulla_egy_kozott);

    // b) feladat:
    boolean a_5_10_b_15_20_kozott = 5<=a && a<=10 && 15<=b && b<=20 ;
    System.out.println("a �rt�ke 5 �s 10, b �rt�ke pedig 15 �s 20 k�z� esik: "+
                        a_5_10_b_15_20_kozott);

    // c) feladat:
    boolean nemElozo = a<5 || a>10 || b<15 || b>20 ;
    System.out.println("nem igaz az el�z� �ll�t�s: "+nemElozo);

    // d) feladat:
    boolean nem0 = a*b*c != 0 ;
    // 2. megold�s: a!=0 && b!=0 && c!=0
    System.out.println("sem a, sem b, sem c nem 0: "+nem0);

    // e) feladat:
    boolean egesz = a==Math.floor(a) ;
    // 2. megold�s: a==Math.ceil(a)
    // 3. megold�s: a==(long)a
    System.out.println("a eg�sz: "+egesz);

    // f) feladat:
    boolean min2egesz =
      a==Math.floor(a) && b==Math.floor(b) ||
      a==Math.floor(a) && c==Math.floor(c) ||
      b==Math.floor(b) && c==Math.floor(c) ;
    System.out.println("a, b �s c k�z�l legal�bb 2 sz�m eg�sz: "+min2egesz);

    // g) feladat:
    boolean egyikPozMasikNeg = a*b < 0 ;
    // 2. megold�s: a>0 && b<0 || a<0 && b>0
    System.out.println("a �s b k�z�l az egyik pozit�v a m�sik negat�v: "+
                        egyikPozMasikNeg);

    // h) feladat:
    boolean max2poz = a<=0 || b<=0 || c<=0 ;
    System.out.println("a �s b k�z�l legfeljebb kett� pozit�v: "+max2poz);
  }
}
