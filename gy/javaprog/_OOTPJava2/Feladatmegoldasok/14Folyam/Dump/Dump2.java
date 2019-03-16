/*
 * Feladatmegold�sok/14. fejezet
 * Dump2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * 2. megold�s:
 * Ebben a megold�sban
    - nem haszn�ljuk az extra csomagot - a szabv�nyos System.in
      bemenetr�l k�rj�k be a f�jl nev�t;
    - �tir�ny�tjuk a szabv�nyos System.out kimenetet a dump.txt f�jlba.
 */

import java.io.*;

public class Dump2 {
  static String right(String s, int len) {
    String st = "                                "+s;
    return st.substring(st.length()-len);
  }

  // A main nem k�v�nja lekezelni a kiv�teleket:
  public static void main (String args[]) throws IOException, FileNotFoundException {

    // A f�jln�v beolvas�sa a konzolr�l a szabv�nyos bemenetr�l (a Console oszt�ly n�lk�l):
    System.out.print("F�jln�v: ");
    BufferedReader konBe = new BufferedReader(new InputStreamReader(System.in));
    String fNev = konBe.readLine();
    konBe.close();

    System.out.println("Eredm�ny a \"work/dump.txt\" f�jlban.");

    // A szabv�nyos kimenetet �tir�ny�tjuk a work/dump.txt sz�veges f�jlba:
    System.setOut(new PrintStream(new FileOutputStream("work/dump.txt")));

    // A dump elk�sz�t�se:
    FileInputStream in = new FileInputStream(fNev);
    System.out.println(fNev);
    int poz=0;
    byte[] b = new byte[10];
    int sikerult;
    while ((sikerult = in.read(b)) > 0) {
      // Max. 10 b�jtot siker�lt beolvasni egyszerre.
      // A b�jtok ki�r�sa sz�m �s karakter form�ban, majd soremel�s:
      for (int i=0; i<sikerult; i++)
        System.out.print(right(""+b[i],3)+" "+(char)b[i]+"|");
      System.out.println();
    }
    System.out.println("V�ge");
    in.close();
  } // main
} // Dump2
