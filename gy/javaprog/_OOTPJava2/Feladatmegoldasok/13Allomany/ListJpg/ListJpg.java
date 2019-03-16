/*
 * Feladatmegold�sok/13. fejezet
 * ListJpg.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * List�zza ki egy adott k�nyvt�r JPG kietrjeszt�s� �llom�nyait!
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
      System.out.println("A bejegyz�s nem l�tezik!");
      return;
    }
    File[] imageFiles = dir.listFiles(new FiletypeFilter("jpg"));

    System.out.println("\n"+dir+" mappa jpg �llom�nyai:");
    for (int i=0; i<imageFiles.length; i++) {
      System.out.println(imageFiles[i].getName());
    }
  } // main
} // ListJpg
