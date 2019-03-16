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
 * Azért van ez a végén, mert elrontaná a sorszámozást.
 *
 * Mintaprogramok/4. fejezet
 * MestersegesNullOsztas.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */
