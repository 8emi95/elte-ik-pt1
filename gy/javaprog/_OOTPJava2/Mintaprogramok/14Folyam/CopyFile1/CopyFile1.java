/*
 * Mintaprogramok/14. fejezet
 * CopyFile1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class CopyFile1 {
  public static void main (String args[]) {
    String fSource = "work/Proba/App.java";
    String fDest;                                         //1
    int index = fSource.lastIndexOf('.');
    fDest = fSource.substring(0,index) +
            ".~"+fSource.substring(index+1);

    try {
      FileInputStream in = new FileInputStream(fSource);   //2
      FileOutputStream out = new FileOutputStream(fDest);

      int b;
      while ((b = in.read()) != -1) {                      //3
        out.write(b);
      }

      in.close();                                          //4
      out.close();
    }
    catch (IOException e) {
      System.out.println(e.getMessage());                  //5
    }
  } // main
} // CopyFile1
