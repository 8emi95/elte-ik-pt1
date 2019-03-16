/*
 * Mintaprogramok/14. fejezet
 * ObjStreamDemo.java
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

public class ObjStreamDemo {
  static void letrehoz() {
    try {
      ObjectOutputStream out = new ObjectOutputStream(
           new FileOutputStream("work/objektumok.dat"));   //1
      // Az objektumfolyamra objektumot �s primit�v adatot is �runk:
      out.writeObject(new String("Rol�d Roland"));
      out.writeObject(new String("Teliv�r Oliv�r"));
      out.writeInt(54321);  // primit�v adat
      out.writeObject(new MyClass());
      out.close();
    }
    catch (FileNotFoundException ex) {
      System.out.println("Az �llom�nyt nem lehet l�trehozni!");
    }
    catch (IOException ex) {
      System.out.println("I/O hiba! "+ex);
    }
  }

  static void listaz() {
    try {
      ObjectOutput o;
      ObjectInputStream in = new ObjectInputStream(
           new FileInputStream("work/objektumok.dat"));
      // A visszaolvas�s a fel�r�si sorrendben t�rt�nik:
      String s1 = (String)in.readObject();                 //2
      String s2 = (String)in.readObject();
      int i = in.readInt();
      MyClass obj = (MyClass)in.readObject();
      in.close();
      System.out.println(s1+" "+s2+" "+i+" "+obj);
    }
    catch (FileNotFoundException ex) {
      System.out.println("Nincs ilyen �llom�ny!");
    }
    catch (ClassNotFoundException ex) {
      System.out.println("Rossz oszt�ly!");
    }
    catch (IOException ex) {
      System.out.println("I/O hiba! "+ex);
    }
  }

  public static void main(String[] args) {
    letrehoz();
    listaz();
  }
}
