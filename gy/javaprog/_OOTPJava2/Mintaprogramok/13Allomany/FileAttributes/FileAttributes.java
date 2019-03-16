/*
 * Mintaprogramok/13. fejezet
 * FileAttributes.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;                                          //1
import java.text.DateFormat;                               //2
import java.util.Date;

public class FileAttributes {
  public static void main (String args[]) {
    if (args.length == 0) {
      System.out.println(
        "Használat: [Szülõútvonal] Gyermekútvonal");
      return;
    }
    File f;
    if (args.length == 1)
      f = new File(args[0]);
    else
      f = new File(args[0],args[1]);

    if (f.exists()) {
      System.out.println("Létezik, adatai:");
      System.out.println(f.isDirectory()?"Könyvtár":"Állomány");
      System.out.println("Útvonal: "+f.getPath());
      System.out.println("Abszolút útvonal: "+
          f.getAbsolutePath());
      System.out.println("Bennfoglaló könyvtár: "+
          f.getParent());
      System.out.println("Bejegyzés neve: "+f.getName());
      System.out.println("Hossza (byte): "+f.length());
      DateFormat df = DateFormat.getDateTimeInstance();
      String datum = df.format(new Date(f.lastModified()));
      System.out.println("Utolsó módosítás dátuma: "+datum);
    }
    else
      System.out.println("Nincs ilyen bejegyzés.");
  } // main
} // FileAttributes
