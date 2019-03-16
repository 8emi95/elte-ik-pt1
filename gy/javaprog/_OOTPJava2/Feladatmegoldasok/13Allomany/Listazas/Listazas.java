/*
 * Feladatmegoldások/13. fejezet
 * Listazas.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;
import java.util.*;
import java.text.DateFormat;
import extra.Format;

public class Listazas {

  // A c:\ mappáinak listázása. Kiírja a mappák nevét és a létrehozás dátumát:
  static void listaA() {
    File mappa = new File("c:/");
    if (!mappa.exists() || !mappa.isDirectory()) {
      System.out.println("Nincs ilyen könyvtár.");
      return;
    }
    DateFormat df = DateFormat.getDateInstance();
    String datum;

    System.out.println(mappa+" könyvtárai és legutolsó módosítási dátumuk:");
    File[] list = mappa.listFiles();
    for (int i = 0; i < list.length; i++) {
      if (list[i].isDirectory()) {
        datum = df.format(new Date(list[i].lastModified()));
        System.out.println(Format.left(list[i].getName(),30) + datum);
      }
    }
  } // listaA

  // A c:\ com fájljainak listázása. Kiírja a fájlok nevét és hosszát:
  static void listaB() {
    File mappa = new File("c:/");
    if (!mappa.exists() || !mappa.isDirectory()) {
      System.out.println("Nincs ilyen könyvtár.");
      return;
    }

    System.out.println("\n"+mappa+" com kiterjesztésû fájljai és hosszuk:");
    File[] list = mappa.listFiles();
    for (int i = 0; i < list.length; i++) {
      if (list[i].getName().toUpperCase().endsWith(".COM")) {
        System.out.println(Format.left(list[i].getName(),30) + list[i].length());
      }
    }
  } // listaB

  public static void main(String[] args) {
    listaA();
    listaB();
  } // main
} // Listazas
