/*
 * Projekt: KissDraw
 *
 * KissDraw.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
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
        "Hiba! �rtes�tse a fejleszt�t! "+ex,"Program hiba",HuOptionPane.ERROR_MESSAGE);
    }
  }
}
