/*
 * Mintaprogramok/14. fejezet
 * SajatSzerializacio.java (a tank�nyvben nem szerepel)
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Vektor szerializ�ci�ja saj�t algoritmus szerint.
 * A vektorhoz most egy fej is tartozik, ami ki�r�sra ker�l.
 */

import java.io.*;
import java.util.Vector;

class CustomVector extends Vector implements Serializable {
  private String fej = "Vektor: ";

  // Az objektum ki�r�sa (szerializ�l�sa) saj�t algoritmus szerint:
  private void writeObject(ObjectOutputStream out)  throws IOException, ClassNotFoundException {
    out.writeObject(fej);
    // Alap�rtelmezett ki�r�s (szerializ�l�s):
    out.defaultWriteObject();
  }
  // Az objektum beolvas�sa saj�t algoritmus szerint:
  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    fej = (String)in.readObject();
    // Alap�rtelmezett beolvas�s:
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
      cv.add("H�rom");

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
