/*
 * Feladatmegold�sok/19. fejezet
 * Nevsor.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Nevsor {
  private String[] nevsor=new String[100];
  int nevekSzama=0;

  public Nevsor() {
    String nev;
    for (nevekSzama=0; nevekSzama<nevsor.length; nevekSzama++) {
      nev = Console.readLine("Nev: ");
      if (nev.equals(""))
        return;
      nevsor[nevekSzama] = nev;
    }
  }

  // a) �s b) feladat:
  public void rendez(boolean novekvo) {
    for (int i=0; i<=nevekSzama-2; i++) {
      int minIndex = i;
      for (int j=i+1; j<=nevekSzama-1; j++)
        if ((novekvo && nevsor[j].compareTo(nevsor[minIndex]) < 0) || (!novekvo && nevsor[j].compareTo(nevsor[minIndex]) > 0))
          minIndex = j;
      if (i != minIndex) {
        String seged = nevsor[i];      // i. �s minIndex. elem cser�je
        nevsor[i] = nevsor[minIndex];
        nevsor[minIndex] = seged;
      }
    }
  }

  // c) feladat:
  private boolean rendezettKeresztnev(String nev1, String nev2) {
    nev1=nev1.substring(nev1.indexOf(' ')+1);
    nev2=nev2.substring(nev2.indexOf(' ')+1);
    // Ha nincs keresztnev, akkor az egesz nevet veszi figyelembe!
    return nev1.compareTo(nev2) < 0;
  }

  public void rendezKeresztnev() {
    for (int i=0; i<=nevekSzama-2; i++) {
      int minIndex = i;
      for (int j=i+1; j<=nevekSzama-1; j++)
        if (rendezettKeresztnev(nevsor[j],nevsor[minIndex]))
          minIndex = j;
      if (i != minIndex) {
        String seged = nevsor[i];      // i. �s minIndex. elem cser�je
        nevsor[i] = nevsor[minIndex];
        nevsor[minIndex] = seged;
      }
    }
  }

  public void listaz() {
    for (int i=0; i<nevekSzama; i++)
      System.out.println(nevsor[i]);
    System.out.println();
  }

  public static void main(String[] args) {
    Nevsor prg = new Nevsor();
    System.out.println("\nNevek rendez�se n�vekv� sorrendben:");
    prg.rendez(true);
    prg.listaz();

    System.out.println("\nNevek rendez�se cs�kken� sorrendben:");
    prg.rendez(false);
    prg.listaz();

    System.out.println("\nNevek rendez�se keresztn�v szerint n�vekv� sorrendben:");
    prg.rendezKeresztnev();
    prg.listaz();
  }
}
