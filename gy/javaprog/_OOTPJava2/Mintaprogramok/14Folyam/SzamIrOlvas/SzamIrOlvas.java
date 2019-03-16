/*
 * Mintaprogramok/14. fejezet
 * SzamIrOlvas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;
import extra.Console;

public class SzamIrOlvas {

  static void felvisz(String fileName) {
    try {
      int szam = 0;
      System.out.println("Eg�sz sz�mok felvitele. V�gjel: -1");
      DataOutputStream szamok=new DataOutputStream(
            new FileOutputStream(fileName+".dat"));        //1
      while ((szam=Console.readInt("Sz�m: ")) != -1)
        szamok.writeInt(szam);                             //2
      szamok.close();
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  static void listaz(String fileName) {
    DataInputStream szamok = null;                         //3
    PrintWriter lista = null;
    int szam = 0;
    try {
      DataInput df;
      szamok=new DataInputStream(
                     new FileInputStream(fileName+".dat"));
      lista=new PrintWriter(
                   new FileOutputStream(fileName+".txt"));
      System.out.println(fileName+".dat tartalma:");
      while (true) {
        szam = szamok.readInt();                           //4
        System.out.print(szam+" ");
        lista.print(szam+" ");                             //5
      }
    }
    catch (EOFException e) {
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
    finally {
      try {
        szamok.close();
        lista.close();
      }
      catch(IOException e) {
      }
    }
  }

  public static void main (String[] args) {
    String fNev="work/egeszek";
    felvisz(fNev);
    listaz(fNev);
  }
} // SzamIrOlvas
