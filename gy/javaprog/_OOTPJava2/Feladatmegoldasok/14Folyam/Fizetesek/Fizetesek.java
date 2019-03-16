/*
 * Feladatmegoldások/14. fejezet
 * Fizetesek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;
import extra.*;

public class Fizetesek {
  private static File fizetesekFile = new File("work/fizetesek.dat");
  private static File jelentesFile  = new File("work/jelentes.txt");

  // Fizetések felvitele:
  private static void felvitel() {
    try {
      DataOutputStream fizetesek = new DataOutputStream(
                       new FileOutputStream(fizetesekFile));
      long fiz;
      while ((fiz = Console.readLong("Fizetés? ")) != 0) {
        fizetesek.writeLong(fiz);
      }
      fizetesek.close();
    }
    catch (IOException e) {
      System.out.println(e);
    }
  }

  // Jelentés készítése:
  private static void jelentes() {
    DataInputStream fizetesek = null;
    PrintWriter jelentes = null;
    int db=0;
    long fiz=0, osszeg=0;
    try {
      fizetesek = new DataInputStream(new FileInputStream(fizetesekFile));
      jelentes = new PrintWriter(new FileOutputStream(jelentesFile));
      jelentes.println("Fizetések:");
      while (true) {
        fiz = fizetesek.readLong(); // EOFException lehet
        db++;
        jelentes.println(db+". "+fiz);
        osszeg += fiz;
      }
    }
    catch (FileNotFoundException ex) {
      System.out.println(ex);
    }
    catch (EOFException ex) {
      try {
        fizetesek.close();
        jelentes.println("\r\nA fizetések átlaga: "+osszeg/db+" ft");
        jelentes.close();
      }
      catch (IOException iex) {
        System.out.println(iex);
      }
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }

  public static void main(String[] args) {
    felvitel();
    jelentes();
  }
}
