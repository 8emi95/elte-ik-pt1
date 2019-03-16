/*
 * Feladatmegold�sok/13. fejezet
 * Torles2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;

public class Torles2 {
  // A megadott k�nyvt�r list�z�sa:
  static void printDir(File dir) {
    System.out.println(dir+" k�nyvt�r bejegyz�sei:");
    String[] list = dir.list();
    // A k�nyvt�r bejegyz�seinek ki�r�sa:
    for (int i=0; i<list.length; i++)
      System.out.println(list[i]);
    System.out.println();
  }

  static boolean joKiterjesztes(File f, String[] kiterjesztesek) {
    boolean ok = false;
    for (int i = 0; i < kiterjesztesek.length; i++) {
      ok = f.getName().toUpperCase().endsWith(
              "."+kiterjesztesek[i].toUpperCase());
      if (ok) break;
    }
    return ok;
  }

  public static void main (String args[]) {
    if (args.length==0) {
      System.out.println("Nem adott meg param�tert!");
      System.exit(0);
    }

    File dir = new File(args[0]);
    if (!dir.exists() || dir.isFile()) {
      System.out.println(dir+" k�nyvt�r nem l�tezik!");
      System.exit(0);
    }

    if (args.length==1) {
      System.out.println("Nem adott meg egyetlen kiterjeszt�st sem!");
      System.exit(0);
    }

    printDir(dir);

    String[] kiterjesztesek = new String[args.length-1];
    for (int i = 1; i < args.length; i++) {
      kiterjesztesek[i-1] = args[i];
    }

    String[] list = dir.list();
    if (list!=null) {
      System.out.println("A megadott kiterjeszt�s� �llom�nyok t�rl�se...");
      for (int i=0; i<list.length; i++) {
        File torlendo = new File(dir.getPath(),list[i]);
        if (joKiterjesztes(torlendo,kiterjesztesek))
          torlendo.delete();
      }
      printDir(dir);
    }
  } // main
} // Torles2
