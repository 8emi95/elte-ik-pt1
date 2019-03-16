/*
 * Feladatmegold�sok/13. fejezet
 * Atnevezes.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;

class FiletypeFilter implements FilenameFilter {
  private String extension;

  public FiletypeFilter(String extension) {
    this.extension = extension.toUpperCase();
  }
  public boolean accept(File dir, String name) {
    return name.toUpperCase().endsWith(extension);
  }
}

public class Atnevezes {

  // A megadott k�nyvt�r list�z�sa:
  static void printDir(File dir) {
    System.out.println(dir+" k�nyvt�r bejegyz�sei:");
    String[] list = dir.list();
    // A k�nyvt�r bejegyz�seinek ki�r�sa:
    for (int i=0; i<list.length; i++)
      System.out.println(list[i]);
    System.out.println();
  }

  public static void main(String[] args) {
    String dirName = "work";
    File dir = new File(dirName);
    if (!dir.exists()) {
      System.out.println("A "+dir+" k�nyvt�r nem l�tezik!");
      return;
    }
    printDir(dir);
    System.out.println("A "+dir+" k�nyvt�rban jpg �llom�nyok �tnevez�se...");
    File[] imageFiles = dir.listFiles(new FiletypeFilter("jpg"));
    String fName;
    for (int i=0; i<imageFiles.length; i++) {
      fName = i+1+".jpg";
      imageFiles[i].renameTo(new File(dirName,fName));
    }
    printDir(dir);
  } // main
} // Atnevezes
