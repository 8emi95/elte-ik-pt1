/*
 * Mintaprogramok/13. fejezet
 * Jellemzok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class Jellemzok {
  public static void main (String args[]) {
    System.out.println("Szeparátor: "+File.separator);     //1
    System.out.println("Útv. szeparátor: "+File.pathSeparator);

    File f = new File("");                                 //2
    System.out.println("Aktuális könyvtár: "+
        f.getAbsolutePath());

    f = f.getAbsoluteFile();                               //3
    while (f != null) {
      System.out.println(f.getPath()+" ["+f.getName()+"]");
      f = f.getParentFile();
    }
  } // main
} // Jellemzok
