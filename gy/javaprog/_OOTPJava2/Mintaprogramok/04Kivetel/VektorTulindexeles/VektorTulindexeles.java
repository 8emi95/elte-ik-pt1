import java.util.*;

public class VektorTulindexeles {
  public static void main (String args[]) {
    Vector v = new Vector();
    v.get(0);           // Hopp�! Nincs ilyen index� elem!
  }
}

/*
java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 0
  at java.util.Vector.get(Vector.java:699)
  at VektorTulindexeles.main(VektorTulindexeles.java:6)
Exception in thread "main"
*/


/*
 * Az�rt van ez a v�g�n, mert elrontan� a sorsz�moz�st.
 *
 * Mintaprogramok/4. fejezet
 * VektorTulindexeles.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

