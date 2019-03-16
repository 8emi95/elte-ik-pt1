// NullOsztas.java
public class NullOsztas {
  public static void main (String args[]) {
    int osszeg = 200;
    int darab = 0;
    int atlag = osszeg/darab;  // Hoppá! Nullával osztás!
    // Ide már nem jut el a vezérlés:
    System.out.println("Minden rendben.");
  }
}

/*
java.lang.ArithmeticException: / by zero
  at NullOsztas.main(NullOsztas.java:6)
Exception in thread "main"
*/


/*
 * Azért van ez a végén, mert elrontaná a sorszámozást.
 *
 * Mintaprogramok/4. fejezet
 * NullOsztas.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */
