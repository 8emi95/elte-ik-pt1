/*
 * Feladatmegoldások/14. fejezet
 * Dump1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * 1. megoldás.
 * Ebben a megoldásban használjuk az extra csomagot.
 */

import java.io.*;
import extra.*;

public class Dump1 {

  // A main nem kívánja lekezelni a kivételeket:
  public static void main (String args[]) throws IOException, FileNotFoundException {

    // A feldolgozandó fájl nevének bekérése és megnyitása:
    String fIn = Console.readLine("Fájlnév: ");
    // fIn = "work/proba.txt";
    FileInputStream in = new FileInputStream(fIn);

    // A dump.txt-be fogunk írni:
    String fOut = "work/dump.txt";
    PrintWriter out = new PrintWriter(new FileWriter(fOut));

    // A dump elkészítése:
    out.println(fIn);
    int poz=0;
    byte[] b = new byte[10];
    int sikerult;
    while ((sikerult = in.read(b)) > 0) {
      // Max. 10 bájtot sikerült beolvasni egyszerre.
      // A bájtok kiírása szám és karakter formában, majd soremelés:
      for (int i=0; i<sikerult; i++)
        out.print(Format.right(b[i],3)+" "+(char)b[i]+"|");
      out.println();
    }
    in.close();
    out.println("Vége");
    out.close();
    System.out.println("Eredmény a \""+fOut+"\" fájlban.");
  } // main
} // Dump1
