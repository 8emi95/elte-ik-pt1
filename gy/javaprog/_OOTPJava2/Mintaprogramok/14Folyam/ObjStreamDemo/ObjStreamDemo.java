/*
 * Mintaprogramok/14. fejezet
 * ObjStreamDemo.java
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

public class ObjStreamDemo {
  static void letrehoz() {
    try {
      ObjectOutputStream out = new ObjectOutputStream(
           new FileOutputStream("work/objektumok.dat"));   //1
      // Az objektumfolyamra objektumot és primitív adatot is írunk:
      out.writeObject(new String("Rolád Roland"));
      out.writeObject(new String("Telivér Olivér"));
      out.writeInt(54321);  // primitív adat
      out.writeObject(new MyClass());
      out.close();
    }
    catch (FileNotFoundException ex) {
      System.out.println("Az állományt nem lehet létrehozni!");
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
      // A visszaolvasás a felírási sorrendben történik:
      String s1 = (String)in.readObject();                 //2
      String s2 = (String)in.readObject();
      int i = in.readInt();
      MyClass obj = (MyClass)in.readObject();
      in.close();
      System.out.println(s1+" "+s2+" "+i+" "+obj);
    }
    catch (FileNotFoundException ex) {
      System.out.println("Nincs ilyen állomány!");
    }
    catch (ClassNotFoundException ex) {
      System.out.println("Rossz osztály!");
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
