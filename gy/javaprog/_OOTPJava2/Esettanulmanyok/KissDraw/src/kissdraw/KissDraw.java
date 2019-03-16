/*
 * Projekt: KissDraw
 *
 * KissDraw.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package kissdraw;

import extra.hu.HuOptionPane;

public class KissDraw {
  public static void main(String[] args) {
    try {
      new gui.DrawFrame();
    }
    catch (Exception ex) {
      extra.hu.HuOptionPane.showMessageDialog(null,
        "Hiba! Értesítse a fejlesztõt! "+ex,"Program hiba",HuOptionPane.ERROR_MESSAGE);
    }
  }
}
