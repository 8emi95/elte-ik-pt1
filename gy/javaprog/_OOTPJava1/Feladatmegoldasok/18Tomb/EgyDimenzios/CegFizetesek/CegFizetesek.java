/*
 * Feladatmegoldások/18. fejezet
 * CegFizetesek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

class Dolgozo {
  private String nev;
  private int fizetes;

  public Dolgozo(String nev, int fizetes) {
    this.nev = nev;
    this.fizetes = fizetes;
  }

  public int getFizetes() { return fizetes; }

  public void fizuEmel(int szazalek) {
    fizetes *= 1+(double)szazalek/100;
  }

  public String toString() {
    return Format.left(nev,15)+Format.right(fizetes,8);
  }
}

public class CegFizetesek {
  private Dolgozo[] dolgozok = new Dolgozo[100];
  int size = 0;

  void adatBekeres() {
    System.out.println("Adatbekérés:");
    String nev;
    while (!(nev = Console.readLine("\nDolgozó neve: ")).equals(""))
      dolgozok[size++] = new Dolgozo(nev,Console.readInt("Fizetése: "));
  }

  void lista() {
    System.out.println("Lista:");
    for (int i=0; i<size; i++)
      System.out.println(dolgozok[i]);
  }

  int atlag() {
    double osszeg = 0;
    for (int i=0; i<size; i++)
      osszeg += dolgozok[i].getFizetes();
    return (int)(osszeg/size);
  }

  void legnagyobbElteres() {
    int atlag = atlag();
    int elter, maxElter = 0;
    for (int i=0; i<size; i++) {
      elter = Math.abs(dolgozok[i].getFizetes()-atlag);
      if (elter > maxElter)
        maxElter = elter;
    }
    System.out.println("\nMaximális eltérés: "+maxElter);
    System.out.println("A következõk fizetése tér el legjobban az átlagtól:");
    for (int i=0; i<size; i++)
    if ((Math.abs(dolgozok[i].getFizetes()-atlag) == maxElter))
      System.out.println(dolgozok[i]);
  }

  void fizuEmeles(int szazalek) {
    System.out.println("\n"+szazalek+"%-os fizetésemelés");
    for (int i=0; i<size; i++)
      dolgozok[i].fizuEmel(szazalek);
  }

  void run() {
    adatBekeres();
    lista();
    System.out.println("\nFizetések átlaga: "+atlag());
    legnagyobbElteres();
    fizuEmeles(10);
    lista();
  }

  public static void main(String[] args) {
    new CegFizetesek().run();
  }
}
