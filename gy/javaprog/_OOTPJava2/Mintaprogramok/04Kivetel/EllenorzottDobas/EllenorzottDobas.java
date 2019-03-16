// EllenorzottDobas.java
import java.io.*;

public class EllenorzottDobas {
  static void metodusA() throws IOException {
    throw new IOException("Számot kérek!");
  }

  public static void main (String args[]) throws IOException {
    metodusA();
  }
}

/*
java.io.IOException: Számot kérek!
  at EllenorzottDobas.metodusA(EllenorzottDobas.java:6)
  at EllenorzottDobas.main(EllenorzottDobas.java:10)
Exception in thread "main"
*/


/*
 * Azért van ez a végén, mert elrontaná a sorszámozást.
 *
 * Mintaprogramok/4. fejezet
 * EllenorzottDobas.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

