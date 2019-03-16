/*
 * Mintaprogramok/20. fejezet
 * Varosok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;
import java.util.*;

class Varos implements Comparable {
  private String nev;
  private int terulet;
  private int lakosokSzama;

  public Varos(String nev, int terulet, int lakosokSzama) {
    this.nev=nev;
    this.terulet=terulet;
    this.lakosokSzama=lakosokSzama;
  }

  public String getNev() {
    return nev;
  }

  public int getLakosokSzama() {
    return lakosokSzama;
  }

  public int nepsuruseg() {
    return lakosokSzama/terulet;
  }

  public boolean equals(Object obj) {
    return nev.equals(((Varos)obj).getNev());
  }

  public int compareTo(Object obj) {
    return nepsuruseg() - ((Varos)obj).nepsuruseg();
  }

  public String toString() {
    return Format.left(nev,10)+ Format.right(terulet,4)+
    Format.right(lakosokSzama,14)+Format.right(nepsuruseg(),12);
  }
}

public class Varosok {
  private Vector varosok= new Vector();

  void felvitel() {
    String nev = Console.readLine("\nVaros neve     : ");
    while (!nev.equals("")) {
      Varos varos = new Varos(nev,0,0);
      if(varosok.contains(varos))
        System.out.println("Mar van ilyen varos!");
      else {
        int terulet = Console.readInt("Varos terulete : ");
        int lakosok = Console.readInt("Varos lakossaga: ");
        varos = new Varos(nev,terulet,lakosok);
        varosok.add(varos);
      }
      nev = Console.readLine("\nVaros neve     : ");
    }
    Collections.sort(varosok);
  }

  void lista() {
    System.out.println("\nVarosok nepnepsuruseg szerint rendezve");
    System.out.println("Nev       Terulet  Lakosok szama  Nepsuruseg");
    for (int i=0; i<varosok.size(); i++) {
      System.out.println(varosok.get(i));
    }
  }

  void kimutatas() {
    int[] gyujto = new int[4];
    for (int i=0; i<varosok.size(); i++) {
      Varos varos = (Varos)(varosok.get(i));
      // Indexképzés a jegyek száma alapján:
      int index = (""+varos.getLakosokSzama()).length();
      index = index-5;
      if (index < 0)
        index = 0;
      if (index > 3)
        index = 3;
      gyujto[index]++;
    }
    System.out.println("\n  Lakosok szama   Varosok szama");
    System.out.println("       0-  99999 "+Format.right(gyujto[0],5));
    System.out.println("  100000- 999999 "+Format.right(gyujto[1],5));
    System.out.println(" 1000000-9999999 "+Format.right(gyujto[2],5));
    System.out.println("10000000-        "+Format.right(gyujto[3],5));
  }

  void menu() {
    char valasz;
    do {
      System.out.println("\n1- Felvitel");
      System.out.println("2- Lista");
      System.out.println("3- Kimutatas");
      System.out.print  ("0- Kilepes ");
      valasz=Console.readChar();
      switch (valasz) {
        case '1': {felvitel(); break;}
        case '2': {lista(); break;}
        case '3': {kimutatas(); break;}
      }
    }
    while (valasz!='0');
  }

  public static void main(String[] args) {
    new Varosok().menu();
  }
}
