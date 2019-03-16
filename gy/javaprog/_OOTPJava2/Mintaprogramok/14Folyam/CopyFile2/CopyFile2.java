/*
 * Mintaprogramok/14. fejezet
 * CopyFile2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class CopyFile2 {
  public static void main (String args[]) {
    String fSource = "work/Proba/App.java";
    String fDest;                                         //1
    int index = fSource.lastIndexOf('.');
    fDest = fSource.substring(0,index) +
            ".~"+fSource.substring(index+1);

    try {
      FileInputStream in = new FileInputStream(fSource);   //2
      FileOutputStream out = new FileOutputStream(fDest);

      byte[] bajtTomb = new byte[in.available()];          //3
      in.read(bajtTomb);
      out.write(bajtTomb);

      in.close();                                          //4
      out.close();
    }
    catch (IOException e) {
      System.out.println(e.getMessage());                  //5
    }
  } // main
} // CopyFile2
