/*
 * Mintaprogramok/13. fejezet
 * Szures.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

class FiletypeFilter implements FilenameFilter {           //1
  private String extension;

  public FiletypeFilter(String extension) {
    this.extension = extension.toUpperCase();
  }

  public boolean accept(File dir, String name) {           //2
    return name.toUpperCase().endsWith('.'+extension);
  }
}

public class Szures {
  public static void main(String[] args) {
    File f;                                                //3
    if (args.length>0)
      f = new File(args[0]);
    else
      f = new File("."); // Aktuális könyvtár

    if (!f.exists() || !f.isDirectory()) {
      System.out.println("Nincs, vagy nem könyvtár.");
      return;
    }
    String[] list = f.list(new FiletypeFilter("exe"));     //4
    System.out.println(f.getAbsolutePath()+" könyvtár exe állományai:");
    for(int i=0; i<list.length; i++)
      System.out.println(list[i]);
  }
} // Szures
