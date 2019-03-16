/*
 * Mintaprogramok/14. fejezet
 * ObjStreamDemo2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
      // Az objektumfolyamot tov�bb�r�sra nyitjuk meg (append==true):
      ObjectOutputStream out = new ObjectOutputStream(
           new FileOutputStream("work/objektumok2.dat"));
      // Csak objektumot �runk ki (primit�v adatot nem):
      out.writeObject(new String("Rol�d Roland"));
      out.writeObject(new String("Teliv�r Oliv�r"));
      out.writeObject(new Integer(54321));
      out.writeObject(new MyClass());
      out.close();
    }
    catch (FileNotFoundException ex) {
      System.out.println("A f�jlt nem lehet l�trehozni!");
    }
    catch (IOException ex) {
      System.out.println("I/O hiba a l�trehoz�skor! "+ex);
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
        in.close(); // �llom�ny v�ge
      }
    }
    catch (FileNotFoundException ex) {
      System.out.println("Nincs ilyen f�jl!");
    }
    catch (ClassNotFoundException ex) {
      System.out.println("Rossz oszt�ly!");
    }
    catch (IOException ex) {
      System.out.println("I/O hiba olvas�skor! "+ex);
    }
  }

  public static void main(String[] args) {
    letrehoz();
    listaz();
  }
}
