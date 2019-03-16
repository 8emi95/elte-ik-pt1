import java.util.*;

public class VektorTulindexeles {
  public static void main (String args[]) {
    Vector v = new Vector();
    v.get(0);           // Hoppá! Nincs ilyen indexû elem!
  }
}

/*
java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 0
  at java.util.Vector.get(Vector.java:699)
  at VektorTulindexeles.main(VektorTulindexeles.java:6)
Exception in thread "main"
*/


/*
 * Azért van ez a végén, mert elrontaná a sorszámozást.
 *
 * Mintaprogramok/4. fejezet
 * VektorTulindexeles.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

