// MestersegesNullOsztas.java
public class MestersegesNullOsztas {
  public static void main (String args[]) {
    throw new ArithmeticException("Osztogatunk nullaval?");
  }
}

/*
java.lang.ArithmeticException: Osztogatunk nullaval?
  at MestersegesNullOsztas.main(MestersegesNullOsztas.java:3)
Exception in thread "main"
*/


/*
 * Az�rt van ez a v�g�n, mert elrontan� a sorsz�moz�st.
 *
 * Mintaprogramok/4. fejezet
 * MestersegesNullOsztas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */
