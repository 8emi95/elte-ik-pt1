/*
 * Mintaprogramok/15. fejezet
 * RandomTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class RandomTest {
  public static void main(String[] args) {
    try {
      RandomAccessFile raf =
          new RandomAccessFile("work/adatok.dat","rw");
      raf.writeChars("ElejeX1908Vege");                    //1
      System.out.println("Állományhossz: "+raf.length());  //2
      raf.seek(10);                                        //3
      char ch = raf.readChar();                            //4
      System.out.println(ch);
      raf.writeChar(ch);                                   //5
      long poz = raf.getFilePointer();                     //6
      System.out.println("Állománypozíció: "+poz);
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }
}
