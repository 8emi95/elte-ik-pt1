/*
 * Feladatmegold�sok/13. fejezet
 * JDKKereses.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;

public class JDKKereses {
  public static void main(String[] args) {
    File[] roots, list;

    // A rendszer f�k�nyvt�raiban keres�nk:
    roots = File.listRoots();
    for (int i = 0; i < roots.length; i++) {
      if (!roots[i].exists()) { // ha az eszk�z nem el�rhet�
        System.out.println(roots[i].getAbsolutePath()+" lemezegys�g nem el�rhet�");
        continue;
      }
      System.out.println(roots[i].getAbsolutePath()+" lemezegys�g vizsg�lata...");
      list = roots[i].listFiles(); // a f�k�nyvt�r bejegyz�sei
      for (int j = 0; j < list.length; j++) {
        if (list[j].isDirectory() && list[j].getName().toUpperCase().startsWith("JDK"))
          System.out.println(list[j].getAbsolutePath());
      } // for j
    } // for i
  } // main

} // JDKKereses
