/*
 * Feladatmegoldások/16. fejezet
 * Atvaltas2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Atvaltas2 {
  static boolean changeFirstDollarToForint(StringBuffer szoveg) {
    final double ARFOLYAM = 280; // 1$ = 280 Ft
    int szamKezd=0,szamVeg=0;
    boolean van$ = false;
    for (szamKezd=0; szamKezd<szoveg.length()-2 && !van$; szamKezd++) {
      szamVeg = szamKezd;
      while (szamVeg<szoveg.length()-2 && Character.isDigit(szoveg.charAt(szamVeg)))
        szamVeg++;
      van$ = szamVeg>szamKezd && szoveg.charAt(szamVeg)==' ' && szoveg.charAt(szamVeg+1)=='$';
    }
    if (van$) {
      szamKezd--;
      long dollar = Long.parseLong(szoveg.toString().substring(szamKezd,szamVeg));
      double ft = dollar * ARFOLYAM;
      String forintStr = Format.left(ft,0,2)+" Ft";
      szoveg.delete(szamKezd,szamVeg+2);
      szoveg.insert(szamKezd,forintStr);
    }
    return van$;
  }

  public static void main(String[] args) {
    StringBuffer szov;
    boolean van;
    do {
      szov = new StringBuffer(Console.readLine("Szöveg: "));
      van = changeFirstDollarToForint(szov);
      if (!van)
        System.out.println("Nincs benne dollárösszeg! Újra!");
    } while (!van);
    do {
      van = changeFirstDollarToForint(szov);
    } while (van);
    System.out.println("Új szöveg: "+szov);
 }
}
