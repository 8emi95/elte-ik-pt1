/*
 * Mintaprogramok/13. fejezet
 * FileAttributes.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;                                          //1
import java.text.DateFormat;                               //2
import java.util.Date;

public class FileAttributes {
  public static void main (String args[]) {
    if (args.length == 0) {
      System.out.println(
        "Haszn�lat: [Sz�l��tvonal] Gyermek�tvonal");
      return;
    }
    File f;
    if (args.length == 1)
      f = new File(args[0]);
    else
      f = new File(args[0],args[1]);

    if (f.exists()) {
      System.out.println("L�tezik, adatai:");
      System.out.println(f.isDirectory()?"K�nyvt�r":"�llom�ny");
      System.out.println("�tvonal: "+f.getPath());
      System.out.println("Abszol�t �tvonal: "+
          f.getAbsolutePath());
      System.out.println("Bennfoglal� k�nyvt�r: "+
          f.getParent());
      System.out.println("Bejegyz�s neve: "+f.getName());
      System.out.println("Hossza (byte): "+f.length());
      DateFormat df = DateFormat.getDateTimeInstance();
      String datum = df.format(new Date(f.lastModified()));
      System.out.println("Utols� m�dos�t�s d�tuma: "+datum);
    }
    else
      System.out.println("Nincs ilyen bejegyz�s.");
  } // main
} // FileAttributes
