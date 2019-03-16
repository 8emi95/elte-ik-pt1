/*
 * Mintaprogramok/18. fejezet
 * Eletkor.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

class Ember {
  private String nev;
  private int eletkor;

  public Ember() {
    System.out.println("\nAz ember adatai");
    nev = Console.readLine("Név: ");
    eletkor = Console.readInt("Életkor: ");
  }

  public static int evAlso(int korcsop) {
    return korcsop*10;
  }

  public static int evFelso(int korcsop) {
    return korcsop*10+9;
  }

  // Visszaadja az ember korcsoportját:
  public int korcsoport() {
    int korcsop = eletkor/10;
    if (korcsop > 9) korcsop = 9;
    return korcsop;
  }
}

public class Eletkor {
  private final int LETSZAM=5;
  private int[] korcsGyujto = new int[10];
  private Ember[] emberek = new Ember[LETSZAM];

  public void adatGyujtes() {
    for (int i=0; i<LETSZAM; i++)
      emberek[i] = new Ember();
  }

  public void statisztika() {
    for (int i=0; i<LETSZAM; i++)
      korcsGyujto[emberek[i].korcsoport()]++;

    System.out.println("\nKorcsoport Darab");
    for (int i=0; i<korcsGyujto.length; i++) {
      System.out.print(Format.right(Ember.evAlso(i),2)+"-"+
        Format.right(Ember.evFelso(i),2));
      System.out.println(Format.right(korcsGyujto[i],3));
    }
  }

  public static void main(String[] args) {
    Eletkor ek = new Eletkor();
    ek.adatGyujtes();
    ek.statisztika();
  }
}
