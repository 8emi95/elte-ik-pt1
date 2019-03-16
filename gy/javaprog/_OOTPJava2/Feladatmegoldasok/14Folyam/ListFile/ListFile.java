/*
 * Feladatmegoldások/14. fejezet
 * ListFile.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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
      System.out.println("Adjon meg a program paramétereként egy szöveges állományt!");
    }
    catch (FileNotFoundException e) {
      System.out.println("A paraméterként megadott állomány ("+args[0]+") nem létezik!");
    }
    catch (IOException e) {
      System.out.println("I/O hiba!");
    }
  } // main
} // ListFile

