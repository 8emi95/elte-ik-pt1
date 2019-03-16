/*
 * Feladatmegold�sok/13. fejezet
 * Listazas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;
import java.util.*;
import java.text.DateFormat;
import extra.Format;

public class Listazas {

  // A c:\ mapp�inak list�z�sa. Ki�rja a mapp�k nev�t �s a l�trehoz�s d�tum�t:
  static void listaA() {
    File mappa = new File("c:/");
    if (!mappa.exists() || !mappa.isDirectory()) {
      System.out.println("Nincs ilyen k�nyvt�r.");
      return;
    }
    DateFormat df = DateFormat.getDateInstance();
    String datum;

    System.out.println(mappa+" k�nyvt�rai �s legutols� m�dos�t�si d�tumuk:");
    File[] list = mappa.listFiles();
    for (int i = 0; i < list.length; i++) {
      if (list[i].isDirectory()) {
        datum = df.format(new Date(list[i].lastModified()));
        System.out.println(Format.left(list[i].getName(),30) + datum);
      }
    }
  } // listaA

  // A c:\ com f�jljainak list�z�sa. Ki�rja a f�jlok nev�t �s hossz�t:
  static void listaB() {
    File mappa = new File("c:/");
    if (!mappa.exists() || !mappa.isDirectory()) {
      System.out.println("Nincs ilyen k�nyvt�r.");
      return;
    }

    System.out.println("\n"+mappa+" com kiterjeszt�s� f�jljai �s hosszuk:");
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
