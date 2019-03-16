/*
 * Feladatmegoldások/14. fejezet
 * Dump2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * 2. megoldás:
 * Ebben a megoldásban
    - nem használjuk az extra csomagot - a szabványos System.in
      bemenetrõl kérjük be a fájl nevét;
    - átirányítjuk a szabványos System.out kimenetet a dump.txt fájlba.
 */

import java.io.*;

public class Dump2 {
  static String right(String s, int len) {
    String st = "                                "+s;
    return st.substring(st.length()-len);
  }

  // A main nem kívánja lekezelni a kivételeket:
  public static void main (String args[]) throws IOException, FileNotFoundException {

    // A fájlnév beolvasása a konzolról a szabványos bemenetrõl (a Console osztály nélkül):
    System.out.print("Fájlnév: ");
    BufferedReader konBe = new BufferedReader(new InputStreamReader(System.in));
    String fNev = konBe.readLine();
    konBe.close();

    System.out.println("Eredmény a \"work/dump.txt\" fájlban.");

    // A szabványos kimenetet átirányítjuk a work/dump.txt szöveges fájlba:
    System.setOut(new PrintStream(new FileOutputStream("work/dump.txt")));

    // A dump elkészítése:
    FileInputStream in = new FileInputStream(fNev);
    System.out.println(fNev);
    int poz=0;
    byte[] b = new byte[10];
    int sikerult;
    while ((sikerult = in.read(b)) > 0) {
      // Max. 10 bájtot sikerült beolvasni egyszerre.
      // A bájtok kiírása szám és karakter formában, majd soremelés:
      for (int i=0; i<sikerult; i++)
        System.out.print(right(""+b[i],3)+" "+(char)b[i]+"|");
      System.out.println();
    }
    System.out.println("Vége");
    in.close();
  } // main
} // Dump2
