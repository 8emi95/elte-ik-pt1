public class TombTulindexeles {
  static void metodusA() {
    int[] egeszek = new int[5];
    egeszek[5] = 12;                // Hoppá! Túlindexelés!
    // Ide már nem jut el a vezérlés:
    System.out.println("Minden rendben a MetodusA-ban.");
  }

  public static void main (String args[]) {
    metodusA();
    // Ide már nem jut el a vezérlés:
    System.out.println("Minden rendben a main-ben.");
  }
}

/*
java.lang.ArrayIndexOutOfBoundsException
        at TombTulindexeles.metodusA(TombTulindexeles.java:4)
        at TombTulindexeles.main(TombTulindexeles.java:10)
Exception in thread "main"
*/


/*
 * Azért van ez a végén, mert elrontaná a sorszámozást.
 *
 * Mintaprogramok/4. fejezet
 * TombTulindexeles.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */
