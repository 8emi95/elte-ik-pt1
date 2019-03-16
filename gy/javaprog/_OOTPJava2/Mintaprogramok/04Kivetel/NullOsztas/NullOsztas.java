// NullOsztas.java
public class NullOsztas {
  public static void main (String args[]) {
    int osszeg = 200;
    int darab = 0;
    int atlag = osszeg/darab;  // Hopp�! Null�val oszt�s!
    // Ide m�r nem jut el a vez�rl�s:
    System.out.println("Minden rendben.");
  }
}

/*
java.lang.ArithmeticException: / by zero
  at NullOsztas.main(NullOsztas.java:6)
Exception in thread "main"
*/


/*
 * Az�rt van ez a v�g�n, mert elrontan� a sorsz�moz�st.
 *
 * Mintaprogramok/4. fejezet
 * NullOsztas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */
