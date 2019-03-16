/*
 * Mintaprogramok/13. fejezet
 * Szures.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
      f = new File("."); // Aktu�lis k�nyvt�r

    if (!f.exists() || !f.isDirectory()) {
      System.out.println("Nincs, vagy nem k�nyvt�r.");
      return;
    }
    String[] list = f.list(new FiletypeFilter("exe"));     //4
    System.out.println(f.getAbsolutePath()+" k�nyvt�r exe �llom�nyai:");
    for(int i=0; i<list.length; i++)
      System.out.println(list[i]);
  }
} // Szures
