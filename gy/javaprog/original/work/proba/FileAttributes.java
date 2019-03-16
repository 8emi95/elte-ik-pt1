/*
 * Mintaprogramok/12. fejezet
 * FileAttributes.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;                                          //1
import java.text.DateFormat;
import java.util.Date;

public class FileAttributes {
  public static void main (String args[]) {
    if (args.length == 0) {
      System.out.println(
        "Hasznalat: [Szulo utvonal] Gyermek utvonal");
      return;
    }
    File f;
    if (args.length == 1)
      f = new File(args[0]);
    else
      f = new File(args[0],args[1]);

    if (f.exists()) {
      System.out.println("Letezik, adatai:");
      System.out.println(f.isDirectory()?"Konyvtar":"Allomany");
      System.out.println("Utvonal: "+f.getPath());
      System.out.println("Abszolut utvonal: "+
          f.getAbsolutePath());
      System.out.println("Bennfoglalo konyvtar: "+
          f.getParent());
      System.out.println("Bejegyzes neve: "+f.getName());
      System.out.println("Hossza (byte): "+f.length());
      DateFormat df = DateFormat.getDateTimeInstance();
      String datum = df.format(new Date(f.lastModified()));
      System.out.println("Utolso modositas datuma: "+datum);
    }
    else
      System.out.println("Nincs ilyen file");
  } // main
} // FileAttributes
