/*
 * Csomag: extra.hu
 * HuFileManager.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 *
 * Az extra.util.FileManager magyar v�ltozata.
 * Ahhoz, hogy a FileManager m�s nyelven jelenjen meg,
 * ezeket a met�dusokat kell �t�rni.
 */

package extra.hu;

import javax.swing.*;
import java.awt.Component;
import extra.util.*;

public class HuFileManager extends FileManager {
  public HuFileManager(Component parent, Savable savable) {
    super(parent,savable);
  }

  // A f�jlv�laszt� magyar nyelv� lesz:
  public void setFileChooser() {
    fc = new HuFileChooser(".");
  }

  public void setMessages() {
    textNoname = "N�vtelen";
    description = "Minden f�jl";
  }

  /* Megk�rdezi, hogy fel�l�rja-e a m�r l�tez� �llom�nyt.
   * A lehets�ges visszat�r�si �rt�kek: YES_OPTION �s NO_OPTION.
   */
  protected int showExistsMessage() {
    return HuOptionPane.showConfirmDialog(parent,getFileName() +
      " f�jl l�tezik. Fel�l�rjam?","Figyelmeztet�s",JOptionPane.YES_NO_OPTION,
      JOptionPane.WARNING_MESSAGE);
  }

  /* Megk�rdezi, hogy elmentse-e a m�dos�tott �llom�nyt.
   * A lehets�ges visszat�r�si �rt�kek: YES_OPTION, NO_OPTION �s CANCEL_OPTION.
   */
  protected int showModifiedMessage() {
    return HuOptionPane.showConfirmDialog(parent,
      getFileName() + " f�jl m�dosult. Elmentsem?", "Figyelmeztet�s",
      JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
  }

  /* Ki�rja a "Hiba az �llom�ny �r�sa k�zben!" �zenetet.
   * Nincs visszat�r�si �rt�k, csak nyugt�zni kell.
   */
  protected void showWriteErrorMessage() {
    HuOptionPane.showMessageDialog(parent, "Hiba a f�jl �r�sa k�zben!", "Hiba",
      JOptionPane.ERROR_MESSAGE);
  }

  /* Ki�rja a "Hiba az �llom�ny olvas�sa k�zben!" �zenetet.
   * Nincs visszat�r�si �rt�k, csak nyugt�zni kell.
   */
  protected void showReadErrorMessage() {
    HuOptionPane.showMessageDialog(parent, "Hiba a f�jl olvas�sa k�zben!", "Hiba",
      JOptionPane.ERROR_MESSAGE);
  }

}
