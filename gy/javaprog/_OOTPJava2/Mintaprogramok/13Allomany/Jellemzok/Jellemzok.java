/*
 * Mintaprogramok/13. fejezet
 * Jellemzok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;

public class Jellemzok {
  public static void main (String args[]) {
    System.out.println("Szepar�tor: "+File.separator);     //1
    System.out.println("�tv. szepar�tor: "+File.pathSeparator);

    File f = new File("");                                 //2
    System.out.println("Aktu�lis k�nyvt�r: "+
        f.getAbsolutePath());

    f = f.getAbsoluteFile();                               //3
    while (f != null) {
      System.out.println(f.getPath()+" ["+f.getName()+"]");
      f = f.getParentFile();
    }
  } // main
} // Jellemzok
