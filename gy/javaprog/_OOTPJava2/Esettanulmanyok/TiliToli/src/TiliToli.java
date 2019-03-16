/*
 * Mintafeladatok/20. fejezet
 * Projekt: TiliToli
 * Csomag: -
 * TiliToli.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * A program belépési pontja. Létrehozza a játék fõ ablakát.
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
