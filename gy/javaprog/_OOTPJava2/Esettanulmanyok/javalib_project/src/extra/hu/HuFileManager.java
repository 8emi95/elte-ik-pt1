/*
 * Csomag: extra.hu
 * HuFileManager.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 *
 * Az extra.util.FileManager magyar változata.
 * Ahhoz, hogy a FileManager más nyelven jelenjen meg,
 * ezeket a metódusokat kell átírni.
 */

package extra.hu;

import javax.swing.*;
import java.awt.Component;
import extra.util.*;

public class HuFileManager extends FileManager {
  public HuFileManager(Component parent, Savable savable) {
    super(parent,savable);
  }

  // A fájlválasztó magyar nyelvû lesz:
  public void setFileChooser() {
    fc = new HuFileChooser(".");
  }

  public void setMessages() {
    textNoname = "Névtelen";
    description = "Minden fájl";
  }

  /* Megkérdezi, hogy felülírja-e a már létezõ állományt.
   * A lehetséges visszatérési értékek: YES_OPTION és NO_OPTION.
   */
  protected int showExistsMessage() {
    return HuOptionPane.showConfirmDialog(parent,getFileName() +
      " fájl létezik. Felülírjam?","Figyelmeztetés",JOptionPane.YES_NO_OPTION,
      JOptionPane.WARNING_MESSAGE);
  }

  /* Megkérdezi, hogy elmentse-e a módosított állományt.
   * A lehetséges visszatérési értékek: YES_OPTION, NO_OPTION és CANCEL_OPTION.
   */
  protected int showModifiedMessage() {
    return HuOptionPane.showConfirmDialog(parent,
      getFileName() + " fájl módosult. Elmentsem?", "Figyelmeztetés",
      JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
  }

  /* Kiírja a "Hiba az állomány írása közben!" üzenetet.
   * Nincs visszatérési érték, csak nyugtázni kell.
   */
  protected void showWriteErrorMessage() {
    HuOptionPane.showMessageDialog(parent, "Hiba a fájl írása közben!", "Hiba",
      JOptionPane.ERROR_MESSAGE);
  }

  /* Kiírja a "Hiba az állomány olvasása közben!" üzenetet.
   * Nincs visszatérési érték, csak nyugtázni kell.
   */
  protected void showReadErrorMessage() {
    HuOptionPane.showMessageDialog(parent, "Hiba a fájl olvasása közben!", "Hiba",
      JOptionPane.ERROR_MESSAGE);
  }

}
