/*
 * Feladatmegoldások/14. fejezet
 * VectorTarol.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;
import java.util.*;

public class VectorTarol {
  private Vector objektumok = new Vector();
  private File vektorFile = new File("work/vektor.dat");

  public VectorTarol() {
    letrehoz();
    listaz();
    ment();
    objektumok = null;
    betolt();
    listaz();
  }

  void letrehoz() {
    objektumok.add(new String("Elindultam szép hazámból..."));
    objektumok.add(new Integer(500));
    objektumok.add(new Double(45.8));
    objektumok.add(new String("Rózsa, rózsa, százlevelû rózsa..."));
  }

  void listaz() {
    System.out.println("\nObjektumok:");
    for (int i = 0; i < objektumok.size(); i++) {
      System.out.println(objektumok.get(i));
    }
  }

  void ment() {
    try {
      ObjectOutputStream out = new ObjectOutputStream(
                 new FileOutputStream(vektorFile));
      out.writeObject(objektumok);
      out.close();
    }
    catch (FileNotFoundException ex) {
      System.err.println("A fájlt nem lehet létrehozni!");
    }
    catch (IOException ex) {
      System.err.println("I/O hiba! "+ex);
    }
  }

  void betolt() {
    try {
      ObjectInputStream in = new ObjectInputStream(
                     new FileInputStream(vektorFile));

      objektumok = (Vector)in.readObject();
      in.close();
    }
    catch (FileNotFoundException ex) {
      System.err.println("Nincs ilyen fájl!");
    }
    catch (ClassNotFoundException ex) {
      System.err.println("Rossz osztály!");
    }
    catch (IOException ex) {
      System.err.println("I/O hiba! "+ex);
    }
  }

  public static void main(String[] args) {
    new VectorTarol();
  }
}
