/*
 * Feladatmegoldások/13. fejezet
 * UtvonalVizsg.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
  */

import java.io.*;

public class MappaVizsg {
  public static void main(String[] args) {
    File f = new File(".");
    //File f = new File("OOTPJava2/Mintafeladatok/../Feladatmegoldasok/12Allomany/UtvonalVizsg");
    if (!f.exists() || !f.isDirectory()) {
      System.out.println("A bejegyzés nem létezik, vagy nem mappa!");
      return;
    }
    try {
      f = f.getCanonicalFile();
    }
    catch (IOException e) {
      System.out.println(e);
    }
    System.out.println("Abszolút útvonal: "+f.getAbsolutePath());
    System.out.println("Szülõmappa: "+f.getParent());
  } // main
} // MappaVizsg
