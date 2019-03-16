/*
 * Feladatmegoldások/13. fejezet
 * Torles1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class Torles1 {
  // A megadott könyvtár listázása:
  static void printDir(File dir) {
    System.out.println(dir+" könyvtár bejegyzései:");
    String[] list = dir.list();
    // A könyvtár bejegyzéseinek kiírása:
    for (int i=0; i<list.length; i++)
      System.out.println(list[i]);
    System.out.println();
  }

  public static void main (String args[]) {
    if (args.length==0) {
      System.out.println("Nem adott meg paramétert!");
      System.exit(0);
    }

    File dir = new File(args[0]);
    if (!dir.exists() || !dir.isDirectory()) {
      System.out.println(dir+" könyvtár nem létezik!");
      System.exit(0);
    }
    printDir(dir);

    String[] list = dir.list();
    if (list!=null) {
      System.out.println("~JAV kiterjesztésû állományok törlése...");
      for (int i=0; i<list.length; i++) {
        File torlendo = new File(dir,list[i]);
        if (torlendo.getName().toUpperCase().endsWith(".~JAV"))
          torlendo.delete();
      }
      printDir(dir);
    }
  } // main
} // Torles1
