/*
 * Mintafeladatok/20. fejezet
 * Projekt: TiliToli
 * Csomag: -
 * TiliToli.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * A program bel�p�si pontja. L�trehozza a j�t�k f� ablak�t.
 */

import gui.TiliToliFrame;
import play.*;
import extra.hu.HuOptionPane;

public class TiliToli {
  public static void main (String args[]) {
    try {
      new TiliToliFrame();
    }
    catch (Exception ex) {
      HuOptionPane.showMessageDialog(null,"Hiba! "+ex);
      ex.printStackTrace();
    }
  }
}
