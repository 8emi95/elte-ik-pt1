/*
 * Mintaprogramok/14. fejezet
 * CopyFile3.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class CopyFile3 {
  public static void main (String args[]) {
    String fSource = "work/Proba/App.java";
    String fDest;
    int index = fSource.lastIndexOf('.');
    fDest = fSource.substring(0,index) +
            ".~"+fSource.substring(index+1);

    FileInputStream in = null;
    FileOutputStream out = null;
    try {
      in = new FileInputStream(fSource);
      out = new FileOutputStream(fDest);
      byte[] bajtTomb = new byte[in.available()];
      in.read(bajtTomb);
      out.write(bajtTomb);
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
    finally {
      try {
        if (in != null)
          in.close();
        if (out != null)
          out.close();
      }
      catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
  } // main
} // CopyFile3
