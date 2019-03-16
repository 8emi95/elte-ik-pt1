/*
 * Feladatmegold�sok/14. fejezet
 * ListFile.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;

public class ListFile {
  public static void main (String[] args) {
    FileReader fr = null;
    try {
      fr = new FileReader(args[0]);
      int ch;
      while ((ch = fr.read()) != -1)
        System.out.print((char)ch);
      fr.close();
    }
    catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Adjon meg a program param�terek�nt egy sz�veges �llom�nyt!");
    }
    catch (FileNotFoundException e) {
      System.out.println("A param�terk�nt megadott �llom�ny ("+args[0]+") nem l�tezik!");
    }
    catch (IOException e) {
      System.out.println("I/O hiba!");
    }
  } // main
} // ListFile

