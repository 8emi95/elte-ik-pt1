/*
 * Mintaprogramok/14. fejezet
 * ObjStreamDemo2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

class MyClass implements Serializable {
  int n=67;

  public String toString() {
    return Integer.toString(n);
  }
}

public class ObjStreamDemo2 {
  static void letrehoz() {
    try {
      // Az objektumfolyamot továbbírásra nyitjuk meg (append==true):
      ObjectOutputStream out = new ObjectOutputStream(
           new FileOutputStream("work/objektumok2.dat"));
      // Csak objektumot írunk ki (primitív adatot nem):
      out.writeObject(new String("Rolád Roland"));
      out.writeObject(new String("Telivér Olivér"));
      out.writeObject(new Integer(54321));
      out.writeObject(new MyClass());
      out.close();
    }
    catch (FileNotFoundException ex) {
      System.out.println("A fájlt nem lehet létrehozni!");
    }
    catch (IOException ex) {
      System.out.println("I/O hiba a létrehozáskor! "+ex);
    }
  }

  static void listaz() {
    try {
      ObjectInputStream in = new ObjectInputStream(
           new FileInputStream("work/objektumok2.dat"));
      try {
        while (true)
          System.out.println(in.readObject());
      }
      catch (IOException ex) {
        in.close(); // állomány vége
      }
    }
    catch (FileNotFoundException ex) {
      System.out.println("Nincs ilyen fájl!");
    }
    catch (ClassNotFoundException ex) {
      System.out.println("Rossz osztály!");
    }
    catch (IOException ex) {
      System.out.println("I/O hiba olvasáskor! "+ex);
    }
  }

  public static void main(String[] args) {
    letrehoz();
    listaz();
  }
}
