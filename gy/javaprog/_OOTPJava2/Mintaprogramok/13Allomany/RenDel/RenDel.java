/*
 * Mintaprogramok/13. fejezet
 * RenDel.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;

public class RenDel {
  // A megadott k�nyvt�r list�z�sa:
  static void printDir(String dir) {
    File f = new File(dir);
    if (!f.exists() || f.isFile()) {
      System.out.println(dir+" nem egy k�nyvt�r.");
      return;
    }
    System.out.println(dir+" bejegyz�sei:");
    String[] list = f.list();
    // A k�nyvt�r bejegyz�seinek ki�r�sa:
    for (int i=0; i<list.length; i++)
      System.out.println(list[i]);
    System.out.println();
  }

  public static void main (String args[]) {
    String dir = "c:/javaprog/work/proba";
    printDir(dir);

    // dir-ben az App.java file �tnevez�se App.~jav -ra:
    File f = new File(dir,"App.java");
    if (f.renameTo(new File(dir,"App.~jav")))
      System.out.println("Az �tnevez�s siker�lt.");
    else
      System.out.println("Az �tnevez�s nem siker�lt.");
    printDir(dir);

    // Az icons k�nyvt�r t�rl�se, el�tte �r�t�se:
    f = new File(dir,"icons");
    File[] list = f.listFiles();
    if (list!=null) {
      for (int i=0; i<list.length; i++)
        list[i].delete();
      if (f.delete())
        System.out.println("A t�rl�s siker�lt.");
      else
        System.out.println("A t�rl�s nem siker�lt.");
      printDir(dir);
    }
    else
      System.out.println("Nincs ilyen k�nyvt�r.");

    // A readme.txt l�trehoz�sa:
    f = new File(dir,"readme.txt");
    try {
      f.createNewFile();
      System.out.println("A l�trehoz�s siker�lt.");
    }
    catch(IOException e) {
      System.out.println("A l�trehoz�s nem siker�lt.");
    }
    printDir(dir);
  } // main
} // RenDel
