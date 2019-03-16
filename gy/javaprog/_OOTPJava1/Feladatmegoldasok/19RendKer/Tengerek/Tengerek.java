/*
 * Feladatmegoldások/19. fejezet
 * Tengerek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

class Tenger {
  private String nev;
  private int terulet;

  public Tenger(String nev, int terulet) {
    this.nev = nev;
    this.terulet = terulet;
  }

  public String getNev() {
    return nev;
  }

  public int getTerulet() {
    return terulet;
  }

  public int compareTo(Tenger tenger) {
    return terulet - tenger.getTerulet();
  }

  public String toString() {
    return Format.left(nev,10)+Format.right(terulet,5)+" km2";
  }
}

public class Tengerek {
  private Tenger[] tengerek = {
    new Tenger("Jeges",10512),
    new Tenger("Korall",4791),
    new Tenger("Arab",3683),
    new Tenger("Földközi",2969),
    new Tenger("Weddel",2890),
    new Tenger("Karib",2754)
  };

  void kiir(String info) {
    System.out.println(info);
    for (int i=0; i<tengerek.length; i++)
      System.out.println(tengerek[i]+" ");
    System.out.println();
  }

  void rendez(boolean novekvo) {
    for (int i=0; i<=tengerek.length-2; i++) {
      int minIndex = i;
      for (int j=i+1; j<=tengerek.length-1; j++) {
        if (novekvo) {
          if (tengerek[j].compareTo(tengerek[minIndex])<0)
            minIndex = j;
        }
        else {
          if (tengerek[j].compareTo(tengerek[minIndex])>0)
            minIndex = j;
        }
      }
      if (i != minIndex) {
        Tenger seged = tengerek[i];   // i. és minIndex. elemek cseréje
        tengerek[i] = tengerek[minIndex];
        tengerek[minIndex] = seged;
      }
    }
  }

  public static void main(String[] args) {
    Tengerek tengerek = new Tengerek();
    tengerek.kiir("Tengerek:");
    tengerek.rendez(true);
    tengerek.kiir("Rendezés terület szerint növekvõ rendezettségben:");
    tengerek.rendez(false);
    tengerek.kiir("Rendezés terület szerint csökkenõ rendezettségben:");
  }
}
