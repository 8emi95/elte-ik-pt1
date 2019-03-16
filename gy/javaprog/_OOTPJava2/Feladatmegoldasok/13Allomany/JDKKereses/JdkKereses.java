/*
 * Feladatmegoldások/13. fejezet
 * JDKKereses.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class JDKKereses {
  public static void main(String[] args) {
    File[] roots, list;

    // A rendszer fõkönyvtáraiban keresünk:
    roots = File.listRoots();
    for (int i = 0; i < roots.length; i++) {
      if (!roots[i].exists()) { // ha az eszköz nem elérhetõ
        System.out.println(roots[i].getAbsolutePath()+" lemezegység nem elérhetõ");
        continue;
      }
      System.out.println(roots[i].getAbsolutePath()+" lemezegység vizsgálata...");
      list = roots[i].listFiles(); // a fõkönyvtár bejegyzései
      for (int j = 0; j < list.length; j++) {
        if (list[j].isDirectory() && list[j].getName().toUpperCase().startsWith("JDK"))
          System.out.println(list[j].getAbsolutePath());
      } // for j
    } // for i
  } // main

} // JDKKereses
