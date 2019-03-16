/*
 * Feladatmegoldások/15. fejezet
 * Egeszek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;
import extra.Console;

public class Egeszek {
  private byte hossz = 8;
  private RandomAccessFile egeszek;

  public Egeszek() {
    try {
      egeszek = new RandomAccessFile("work/Egeszek.dat","rw");
      egeszek.setLength(0);     // az eddigi adatokat töröljük

      bovites();                // alapfeladat
      lista("A számok: ");      // a) feladat
      otodikSzam();             // b) feladat
      bovites();                // c) feladat
      lista("A számok (bõvítés után): ");
      listaVissza();            // d) feladat
      setHossz(80);             // e) feladat
      lista("A számok (nullákkal való kiegészítés vagy levágás után): ");
      valogatas();              // f) feladat

      egeszek.close();
    }
    catch (Exception ex) {
      System.out.println(ex);
    }
  }

  // A számok felvitele:
  public void bovites() throws IOException {
    egeszek.seek(egeszek.length());
    long szam;
    System.out.println("Adjon meg számokat 0 végjelig:");
    while ((szam = Console.readLong("Szám: ")) != 0)
      egeszek.writeLong(szam);  // egesz felvitele
  }

  // A paraméterben megadott egészek kiírása sorban:
  public void lista(RandomAccessFile egeszek, String info) throws IOException {
    egeszek.seek(0);  // pozicionálás a fájl elejére
    System.out.println(info);
    for (long i = 0; i < egeszek.length()/hossz; i++) {  // a long 8 bájtos
      System.out.print(egeszek.readLong()+"  ");
    }
    System.out.println();
  }

  // Az egészek kiírása sorban:
  public void lista(String info) throws IOException {
    lista(egeszek,info);
  }

  // Az egészek kiírása visszafelé:
  public void listaVissza() throws IOException {
    egeszek.seek(egeszek.length());  // pozicionálás a fájl végére
    System.out.println("A számok visszafelé:");
    for (long poz = egeszek.length()-hossz; poz>=0; poz-=hossz) {  // a long 8 bájtos
      egeszek.seek(poz);
      System.out.print(egeszek.readLong()+"  ");
    }
    System.out.println();
  }

  // Az 5. egész kiírása:
  public void otodikSzam() throws IOException {
    try {
      egeszek.seek((5-1)*hossz);
      System.out.println("\nAz 5. szám: "+egeszek.readLong());
    }
    catch (IOException ex) {
      System.out.println("\nNincs 5. szám!");
    }
  }

  // A fájl hosszának beállítása pontosan a megadottra:
  public void setHossz(long hossz) throws IOException {
    long eredetiHossz = egeszek.length();

    // Beállítjuk a pontos hosszt:
    egeszek.setLength(hossz);
    // Az esetleges bõvítményt feltöltjük nullákkal:
    egeszek.seek(eredetiHossz);
    while (egeszek.getFilePointer()<hossz)
      egeszek.writeLong(0);
  }

  // A számok szétválogatása:
  public void valogatas() throws IOException {
    egeszek.seek(0);
    RandomAccessFile egeszek1 = new RandomAccessFile("work/Egeszek1.dat","rw");
    RandomAccessFile egeszek2 = new RandomAccessFile("work/Egeszek2.dat","rw");
    egeszek1.setLength(0);
    egeszek2.setLength(0);
    long szam;
    try {
      while (true) {
        szam = egeszek.readLong();
        if (szam < 100)
          egeszek1.writeLong(szam);
        else
          egeszek2.writeLong(szam);
      }
    }
    catch (EOFException ex) {
      lista(egeszek1,"100-nél kisebb számok: ");
      lista(egeszek2,"100-nél nagyobb számok: ");

      egeszek1.close();
      egeszek2.close();
    }
  }

  public static void main(String[] args) {
    new Egeszek();
  }
}
