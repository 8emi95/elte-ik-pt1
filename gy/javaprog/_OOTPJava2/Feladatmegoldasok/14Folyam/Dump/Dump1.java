/*
 * Feladatmegold�sok/14. fejezet
 * Dump1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * 1. megold�s.
 * Ebben a megold�sban haszn�ljuk az extra csomagot.
 */

import java.io.*;
import extra.*;

public class Dump1 {

  // A main nem k�v�nja lekezelni a kiv�teleket:
  public static void main (String args[]) throws IOException, FileNotFoundException {

    // A feldolgozand� f�jl nev�nek bek�r�se �s megnyit�sa:
    String fIn = Console.readLine("F�jln�v: ");
    // fIn = "work/proba.txt";
    FileInputStream in = new FileInputStream(fIn);

    // A dump.txt-be fogunk �rni:
    String fOut = "work/dump.txt";
    PrintWriter out = new PrintWriter(new FileWriter(fOut));

    // A dump elk�sz�t�se:
    out.println(fIn);
    int poz=0;
    byte[] b = new byte[10];
    int sikerult;
    while ((sikerult = in.read(b)) > 0) {
      // Max. 10 b�jtot siker�lt beolvasni egyszerre.
      // A b�jtok ki�r�sa sz�m �s karakter form�ban, majd soremel�s:
      for (int i=0; i<sikerult; i++)
        out.print(Format.right(b[i],3)+" "+(char)b[i]+"|");
      out.println();
    }
    in.close();
    out.println("V�ge");
    out.close();
    System.out.println("Eredm�ny a \""+fOut+"\" f�jlban.");
  } // main
} // Dump1
