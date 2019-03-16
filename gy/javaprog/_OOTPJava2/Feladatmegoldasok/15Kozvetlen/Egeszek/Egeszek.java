/*
 * Feladatmegold�sok/15. fejezet
 * Egeszek.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
      egeszek.setLength(0);     // az eddigi adatokat t�r�lj�k

      bovites();                // alapfeladat
      lista("A sz�mok: ");      // a) feladat
      otodikSzam();             // b) feladat
      bovites();                // c) feladat
      lista("A sz�mok (b�v�t�s ut�n): ");
      listaVissza();            // d) feladat
      setHossz(80);             // e) feladat
      lista("A sz�mok (null�kkal val� kieg�sz�t�s vagy lev�g�s ut�n): ");
      valogatas();              // f) feladat

      egeszek.close();
    }
    catch (Exception ex) {
      System.out.println(ex);
    }
  }

  // A sz�mok felvitele:
  public void bovites() throws IOException {
    egeszek.seek(egeszek.length());
    long szam;
    System.out.println("Adjon meg sz�mokat 0 v�gjelig:");
    while ((szam = Console.readLong("Sz�m: ")) != 0)
      egeszek.writeLong(szam);  // egesz felvitele
  }

  // A param�terben megadott eg�szek ki�r�sa sorban:
  public void lista(RandomAccessFile egeszek, String info) throws IOException {
    egeszek.seek(0);  // pozicion�l�s a f�jl elej�re
    System.out.println(info);
    for (long i = 0; i < egeszek.length()/hossz; i++) {  // a long 8 b�jtos
      System.out.print(egeszek.readLong()+"  ");
    }
    System.out.println();
  }

  // Az eg�szek ki�r�sa sorban:
  public void lista(String info) throws IOException {
    lista(egeszek,info);
  }

  // Az eg�szek ki�r�sa visszafel�:
  public void listaVissza() throws IOException {
    egeszek.seek(egeszek.length());  // pozicion�l�s a f�jl v�g�re
    System.out.println("A sz�mok visszafel�:");
    for (long poz = egeszek.length()-hossz; poz>=0; poz-=hossz) {  // a long 8 b�jtos
      egeszek.seek(poz);
      System.out.print(egeszek.readLong()+"  ");
    }
    System.out.println();
  }

  // Az 5. eg�sz ki�r�sa:
  public void otodikSzam() throws IOException {
    try {
      egeszek.seek((5-1)*hossz);
      System.out.println("\nAz 5. sz�m: "+egeszek.readLong());
    }
    catch (IOException ex) {
      System.out.println("\nNincs 5. sz�m!");
    }
  }

  // A f�jl hossz�nak be�ll�t�sa pontosan a megadottra:
  public void setHossz(long hossz) throws IOException {
    long eredetiHossz = egeszek.length();

    // Be�ll�tjuk a pontos hosszt:
    egeszek.setLength(hossz);
    // Az esetleges b�v�tm�nyt felt�ltj�k null�kkal:
    egeszek.seek(eredetiHossz);
    while (egeszek.getFilePointer()<hossz)
      egeszek.writeLong(0);
  }

  // A sz�mok sz�tv�logat�sa:
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
      lista(egeszek1,"100-n�l kisebb sz�mok: ");
      lista(egeszek2,"100-n�l nagyobb sz�mok: ");

      egeszek1.close();
      egeszek2.close();
    }
  }

  public static void main(String[] args) {
    new Egeszek();
  }
}
