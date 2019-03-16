/*
 * Feladatmegold�sok/14. fejezet
 * VectorTarol.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    objektumok.add(new String("Elindultam sz�p haz�mb�l..."));
    objektumok.add(new Integer(500));
    objektumok.add(new Double(45.8));
    objektumok.add(new String("R�zsa, r�zsa, sz�zlevel� r�zsa..."));
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
      System.err.println("A f�jlt nem lehet l�trehozni!");
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
      System.err.println("Nincs ilyen f�jl!");
    }
    catch (ClassNotFoundException ex) {
      System.err.println("Rossz oszt�ly!");
    }
    catch (IOException ex) {
      System.err.println("I/O hiba! "+ex);
    }
  }

  public static void main(String[] args) {
    new VectorTarol();
  }
}
