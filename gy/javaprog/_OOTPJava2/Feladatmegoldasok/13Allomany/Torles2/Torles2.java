/*
 * Feladatmegoldások/13. fejezet
 * Torles2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class Torles2 {
  // A megadott könyvtár listázása:
  static void printDir(File dir) {
    System.out.println(dir+" könyvtár bejegyzései:");
    String[] list = dir.list();
    // A könyvtár bejegyzéseinek kiírása:
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
      System.out.println("Nem adott meg paramétert!");
      System.exit(0);
    }

    File dir = new File(args[0]);
    if (!dir.exists() || dir.isFile()) {
      System.out.println(dir+" könyvtár nem létezik!");
      System.exit(0);
    }

    if (args.length==1) {
      System.out.println("Nem adott meg egyetlen kiterjesztést sem!");
      System.exit(0);
    }

    printDir(dir);

    String[] kiterjesztesek = new String[args.length-1];
    for (int i = 1; i < args.length; i++) {
      kiterjesztesek[i-1] = args[i];
    }

    String[] list = dir.list();
    if (list!=null) {
      System.out.println("A megadott kiterjesztésû állományok törlése...");
      for (int i=0; i<list.length; i++) {
        File torlendo = new File(dir.getPath(),list[i]);
        if (joKiterjesztes(torlendo,kiterjesztesek))
          torlendo.delete();
      }
      printDir(dir);
    }
  } // main
} // Torles2
