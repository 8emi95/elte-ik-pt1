/*
 * Mintaprogramok/14. fejezet
 * AppendAndList.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;
import extra.Console;                                      //1

public class AppendAndList {
  private String path;

  public AppendAndList(String path) {                      //2
    this.path = path;
    appendText();
    listText();
  }

  void appendText() {                                      //3
    try {
      FileWriter fw = new FileWriter(path,true);
      String line;
      while (!(line = Console.readLine("Sor: ")).equals("")) {
        fw.write(line+"\r\n");
      }
      fw.close();
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }

  void listText() {                                        //4
    try {
      FileReader fr = new FileReader(path);
      System.out.println("Lista:");
      while (fr.ready())
        System.out.print((char)fr.read());
      fr.close();
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }

  public static void main (String args[]) {
    new AppendAndList("work/Szoveg.txt");
  } // main
} // AppendAndList
