/*
 * Mintaprogramok/14. fejezet
 * SorokMasolasa.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class SorokMasolasa {
  String sourcePath = "work/Szoveg.txt";
  String destPath = "work/Szoveg2.txt";

  // Szöveges állomány listázása:
  void listFile(String fileName) {
    System.out.println("\n"+fileName+" állomány sorai:");
    String sor;
    try {
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      while (br.ready())
        System.out.println(br.readLine());
      br.close();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public SorokMasolasa() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(sourcePath));
      BufferedWriter bw = new BufferedWriter(new FileWriter(destPath));
      String sor;

      while (br.ready()) {
        sor = br.readLine();
        bw.write(sor); bw.newLine();
        bw.write("*"); bw.newLine();
      }
      bw.close();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    listFile(sourcePath);
    listFile(destPath);
  }

  public static void main (String args[]) {
    new SorokMasolasa();
  } // main
} // SorokMasolasa
