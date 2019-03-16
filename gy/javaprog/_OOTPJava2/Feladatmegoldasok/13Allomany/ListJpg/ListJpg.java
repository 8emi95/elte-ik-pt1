/*
 * Feladatmegoldások/13. fejezet
 * ListJpg.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Listázza ki egy adott könyvtár JPG kietrjesztésû állományait!
 */

import java.io.*;

class FiletypeFilter implements FilenameFilter {
  private String extension;

  public FiletypeFilter(String extension) {
    this.extension = extension.toUpperCase();
  }

  public boolean accept(File dir, String name) {
    return name.toUpperCase().endsWith("."+extension);
  }
}

public class ListJpg {
  public static void main(String[] args) {
    File dir = new File("images");
    if (!dir.exists()) {
      System.out.println("A bejegyzés nem létezik!");
      return;
    }
    File[] imageFiles = dir.listFiles(new FiletypeFilter("jpg"));

    System.out.println("\n"+dir+" mappa jpg állományai:");
    for (int i=0; i<imageFiles.length; i++) {
      System.out.println(imageFiles[i].getName());
    }
  } // main
} // ListJpg
