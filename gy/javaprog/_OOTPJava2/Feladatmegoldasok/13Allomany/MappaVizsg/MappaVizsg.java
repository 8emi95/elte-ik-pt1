/*
 * Feladatmegold�sok/13. fejezet
 * UtvonalVizsg.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
  */

import java.io.*;

public class MappaVizsg {
  public static void main(String[] args) {
    File f = new File(".");
    //File f = new File("OOTPJava2/Mintafeladatok/../Feladatmegoldasok/12Allomany/UtvonalVizsg");
    if (!f.exists() || !f.isDirectory()) {
      System.out.println("A bejegyz�s nem l�tezik, vagy nem mappa!");
      return;
    }
    try {
      f = f.getCanonicalFile();
    }
    catch (IOException e) {
      System.out.println(e);
    }
    System.out.println("Abszol�t �tvonal: "+f.getAbsolutePath());
    System.out.println("Sz�l�mappa: "+f.getParent());
  } // main
} // MappaVizsg
