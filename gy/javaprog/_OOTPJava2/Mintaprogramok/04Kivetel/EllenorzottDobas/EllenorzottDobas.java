// EllenorzottDobas.java
import java.io.*;

public class EllenorzottDobas {
  static void metodusA() throws IOException {
    throw new IOException("Sz�mot k�rek!");
  }

  public static void main (String args[]) throws IOException {
    metodusA();
  }
}

/*
java.io.IOException: Sz�mot k�rek!
  at EllenorzottDobas.metodusA(EllenorzottDobas.java:6)
  at EllenorzottDobas.main(EllenorzottDobas.java:10)
Exception in thread "main"
*/


/*
 * Az�rt van ez a v�g�n, mert elrontan� a sorsz�moz�st.
 *
 * Mintaprogramok/4. fejezet
 * EllenorzottDobas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

