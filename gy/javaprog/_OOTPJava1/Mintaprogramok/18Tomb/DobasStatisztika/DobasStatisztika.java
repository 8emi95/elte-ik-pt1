/*
 * Mintaprogramok/18. fejezet
 * DobasStatisztika.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

class DoboKocka {
  private static int n = 6;
  private String tulaj;
  private int felul;
  private int[] dobasok = new int[n+1]; // 0. elem nem használatos

  public DoboKocka(String tulaj) {
    this.tulaj = tulaj;
    felul = 1;
  }

  public int dobas() {
    felul = (int)(Math.random()*n+1);   // 1 és n között
    dobasok[felul]++;      // gyûjtés
    return felul;          // a dobott értéket visszaadja
  }

  public double atlag() {
    int osszeg=0, dobasSzam=0;
    for (int i=1; i<=n; i++) {
      dobasSzam += dobasok[i];
      osszeg += dobasok[i]*i;
    }
    return osszeg*1.0/dobasSzam;
  }

  public String toString() {
    String str=tulaj;
    for (int i=1; i<=n; i++) {
      str = str+" "+dobasok[i];
    }
    str = str+" Átlag: "+atlag();
    return str;
  }
}

public class DobasStatisztika {
  public static void main(String[] args) {
    final int DOBASSZAM = 10;
    DoboKocka d1 = new DoboKocka("Bush ");
    DoboKocka d2 = new DoboKocka("Gates");

    // Mindketten dobnak tizet:
    for (int i=1; i<=DOBASSZAM; i++) {
      d1.dobas();
      d2.dobas();
    }

    // Eredmény kiírása:
    System.out.println(d1);
    System.out.println(d2);
  }
}
