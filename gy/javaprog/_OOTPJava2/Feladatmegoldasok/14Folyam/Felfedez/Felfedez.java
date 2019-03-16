/*
 * Feladatmegold�sok/14. fejezet
 * Felfedez.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;

public class Felfedez {
  public static void main(String[] args) {
    String fileName = "c:/config.sys";
    //String fileName = "c:/javaprog/lib/javalib.jar";
    try {
      FileInputStream fIsmeretlen = new FileInputStream(fileName);
      int bajt;
      int n=0;
      while ((bajt=fIsmeretlen.read())!=-1) {
        n++;
        if (n>40) {
          System.out.println();
          n=0;
        }
        if (!Character.isISOControl((char)bajt))
          System.out.print((char)bajt+" ");
        else
          System.out.print(". ");
      }
      fIsmeretlen.close();
    }
    catch (FileNotFoundException ex) {
      System.out.println("A f�jl nem l�tezik!");
    }
    catch (IOException ex) {
      System.out.println("I/O hiba! "+ex.getMessage());
    }
  }
}
