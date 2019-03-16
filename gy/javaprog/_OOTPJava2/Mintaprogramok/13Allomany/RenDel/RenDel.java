/*
 * Mintaprogramok/13. fejezet
 * RenDel.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class RenDel {
  // A megadott könyvtár listázása:
  static void printDir(String dir) {
    File f = new File(dir);
    if (!f.exists() || f.isFile()) {
      System.out.println(dir+" nem egy könyvtár.");
      return;
    }
    System.out.println(dir+" bejegyzései:");
    String[] list = f.list();
    // A könyvtár bejegyzéseinek kiírása:
    for (int i=0; i<list.length; i++)
      System.out.println(list[i]);
    System.out.println();
  }

  public static void main (String args[]) {
    String dir = "c:/javaprog/work/proba";
    printDir(dir);

    // dir-ben az App.java file átnevezése App.~jav -ra:
    File f = new File(dir,"App.java");
    if (f.renameTo(new File(dir,"App.~jav")))
      System.out.println("Az átnevezés sikerült.");
    else
      System.out.println("Az átnevezés nem sikerült.");
    printDir(dir);

    // Az icons könyvtár törlése, elõtte ürítése:
    f = new File(dir,"icons");
    File[] list = f.listFiles();
    if (list!=null) {
      for (int i=0; i<list.length; i++)
        list[i].delete();
      if (f.delete())
        System.out.println("A törlés sikerült.");
      else
        System.out.println("A törlés nem sikerült.");
      printDir(dir);
    }
    else
      System.out.println("Nincs ilyen könyvtár.");

    // A readme.txt létrehozása:
    f = new File(dir,"readme.txt");
    try {
      f.createNewFile();
      System.out.println("A létrehozás sikerült.");
    }
    catch(IOException e) {
      System.out.println("A létrehozás nem sikerült.");
    }
    printDir(dir);
  } // main
} // RenDel
