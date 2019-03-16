public class TombTulindexeles {
  static void metodusA() {
    int[] egeszek = new int[5];
    egeszek[5] = 12;                // Hopp�! T�lindexel�s!
    // Ide m�r nem jut el a vez�rl�s:
    System.out.println("Minden rendben a MetodusA-ban.");
  }

  public static void main (String args[]) {
    metodusA();
    // Ide m�r nem jut el a vez�rl�s:
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
 * Az�rt van ez a v�g�n, mert elrontan� a sorsz�moz�st.
 *
 * Mintaprogramok/4. fejezet
 * TombTulindexeles.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */
