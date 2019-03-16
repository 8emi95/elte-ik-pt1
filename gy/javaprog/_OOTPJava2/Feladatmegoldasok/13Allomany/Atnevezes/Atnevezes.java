/*
 * Feladatmegoldások/13. fejezet
 * Atnevezes.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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

  // A megadott könyvtár listázása:
  static void printDir(File dir) {
    System.out.println(dir+" könyvtár bejegyzései:");
    String[] list = dir.list();
    // A könyvtár bejegyzéseinek kiírása:
    for (int i=0; i<list.length; i++)
      System.out.println(list[i]);
    System.out.println();
  }

  public static void main(String[] args) {
    String dirName = "work";
    File dir = new File(dirName);
    if (!dir.exists()) {
      System.out.println("A "+dir+" könyvtár nem létezik!");
      return;
    }
    printDir(dir);
    System.out.println("A "+dir+" könyvtárban jpg állományok átnevezése...");
    File[] imageFiles = dir.listFiles(new FiletypeFilter("jpg"));
    String fName;
    for (int i=0; i<imageFiles.length; i++) {
      fName = i+1+".jpg";
      imageFiles[i].renameTo(new File(dirName,fName));
    }
    printDir(dir);
  } // main
} // Atnevezes
