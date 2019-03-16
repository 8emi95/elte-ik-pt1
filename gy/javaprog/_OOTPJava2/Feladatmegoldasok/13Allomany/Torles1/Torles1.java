/*
 * Feladatmegold�sok/13. fejezet
 * Torles1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;

public class Torles1 {
  // A megadott k�nyvt�r list�z�sa:
  static void printDir(File dir) {
    System.out.println(dir+" k�nyvt�r bejegyz�sei:");
    String[] list = dir.list();
    // A k�nyvt�r bejegyz�seinek ki�r�sa:
    for (int i=0; i<list.length; i++)
      System.out.println(list[i]);
    System.out.println();
  }

  public static void main (String args[]) {
    if (args.length==0) {
      System.out.println("Nem adott meg param�tert!");
      System.exit(0);
    }

    File dir = new File(args[0]);
    if (!dir.exists() || !dir.isDirectory()) {
      System.out.println(dir+" k�nyvt�r nem l�tezik!");
      System.exit(0);
    }
    printDir(dir);

    String[] list = dir.list();
    if (list!=null) {
      System.out.println("~JAV kiterjeszt�s� �llom�nyok t�rl�se...");
      for (int i=0; i<list.length; i++) {
        File torlendo = new File(dir,list[i]);
        if (torlendo.getName().toUpperCase().endsWith(".~JAV"))
          torlendo.delete();
      }
      printDir(dir);
    }
  } // main
} // Torles1
