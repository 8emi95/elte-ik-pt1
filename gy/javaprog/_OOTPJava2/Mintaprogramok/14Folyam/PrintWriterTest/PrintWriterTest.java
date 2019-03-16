/*
 * Mintaprogramok/14. fejezet
 * PrintWriterTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class PrintWriterTest {
  public static void main(String[] args) {
    try {
      PrintWriter writer = new PrintWriter(new FileWriter("work/print.txt"));
      writer.println("Double: "+12.78);
      writer.print('A');
      writer.println(new Integer(66));
      writer.close();

      FileReader reader = new FileReader("work/print.txt");
      while (reader.ready()) {
        char ch = (char)reader.read();
        System.out.print(ch);
      }
      reader.close();
    }
    catch (IOException ex) {
    }
  }
}
