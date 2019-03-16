/*
 * Feladatmegoldások/16. fejezet
 * SzovegAlakit.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class SzovegAlakit {
  public static void main(String[] args) {
    String szoveg = Console.readLine("Szöveg: ");
    String ujSzoveg;

    // a) feladat:
    ujSzoveg = szoveg.toLowerCase();
    System.out.println("Kisbetûvel: "+ujSzoveg);

    // b) feladat:
    ujSzoveg = szoveg;
    for (int i=1; i<10; i++)
      ujSzoveg = ujSzoveg+"+"+szoveg;
    System.out.println("Tízszer: "+ujSzoveg);

    // c) feladat:
    ujSzoveg = szoveg.replace('_','-');
    System.out.println("_ helyett -: "+ujSzoveg);

    // d) feladat:
    int n = szoveg.length();
    if (n%2 == 0)
      ujSzoveg = szoveg.substring(n/2)+szoveg.substring(0,n/2);
    else
      ujSzoveg = szoveg.substring(n/2+1)+szoveg.charAt(n/2)+
        szoveg.substring(0,n/2);
    System.out.println("Elsõ, második fele felcserélve: "+ujSzoveg);

    // e) feladat:
    int poz = szoveg.indexOf(' ');
    ujSzoveg = szoveg;
    if (poz>=0)
      ujSzoveg = szoveg.substring(poz+1) + ' ' + szoveg.substring(0,poz);
    System.out.println("Két szó felcserélve: "+ujSzoveg);
  }
}
