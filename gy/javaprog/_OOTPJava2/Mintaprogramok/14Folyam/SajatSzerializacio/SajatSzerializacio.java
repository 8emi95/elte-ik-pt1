/*
 * Mintaprogramok/14. fejezet
 * SajatSzerializacio.java (a tankönyvben nem szerepel)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Vektor szerializációja saját algoritmus szerint.
 * A vektorhoz most egy fej is tartozik, ami kiírásra kerül.
 */

import java.io.*;
import java.util.Vector;

class CustomVector extends Vector implements Serializable {
  private String fej = "Vektor: ";

  // Az objektum kiírása (szerializálása) saját algoritmus szerint:
  private void writeObject(ObjectOutputStream out)  throws IOException, ClassNotFoundException {
    out.writeObject(fej);
    // Alapértelmezett kiírás (szerializálás):
    out.defaultWriteObject();
  }
  // Az objektum beolvasása saját algoritmus szerint:
  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    fej = (String)in.readObject();
    // Alapértelmezett beolvasás:
    in.defaultReadObject();
  }
  public String toString() {
    return fej + super.toString();
  }
}

public class SajatSzerializacio {
  public static void main(String[] args) {
    try {
      CustomVector cv = new CustomVector();
      cv.add("Egy");
      cv.add(new Integer(2));
      cv.add("Három");

      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("work/CustomVector.dat"));
      out.writeObject(cv);
      out.close();
    }
    catch (IOException ex) {
    }

    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("work/CustomVector.dat"));
      CustomVector cv = (CustomVector)in.readObject();
      System.out.println(cv);
      in.close();
    }
    catch (IOException ex) {
    }
    catch (ClassNotFoundException ex) {
    }
  }
}
