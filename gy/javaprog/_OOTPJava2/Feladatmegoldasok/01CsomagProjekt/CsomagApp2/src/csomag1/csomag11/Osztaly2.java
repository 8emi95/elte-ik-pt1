/*
 * Feladatmegoldások/1. fejezet
 * Projekt: CsomapApp2
 * Osztaly2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package csomag1.csomag11;
import csomag2.*;

public class Osztaly2 extends Osztaly1 {
  Osztaly6 obj6 = new Osztaly6();

  public String toString() {
    return "Osztaly2 " + super.toString() + obj6;
  }
}
