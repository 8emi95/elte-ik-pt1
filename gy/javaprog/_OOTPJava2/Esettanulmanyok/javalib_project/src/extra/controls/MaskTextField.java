/*
 * Feladatmegold�sok/11. fejezet
 * Projekt: KomponensFel
 * Csomag: extra.controls
 * MaskTextField.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * A megadott maszk szerinti mez�t szerkeszti. Fel�l�r� �zemm�dban m�k�dik, a delete hat�stalan.
 * Maszkok: A: bet�; 9: sz�m; X: b�rmilyen karakter.
 * A getError met�dus megadja az utolj�ra bek�vetkezett hiba sz�veg�t.
 */

package extra.controls;

import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class MaskTextField extends JTextField {
  private String mask;
  private String error = "";
  private boolean beep=true;

  public MaskTextField(String text,String mask) {
    super(text,mask.length()+1);
    this.mask = mask;
    // Ha nem j� hossz�s�g� ind�t� sz�veget adnak meg, akkor a sz�veg maga a maszk lesz:
    if (text.length()!=mask.length())
      text = mask;

    enableEvents(AWTEvent.KEY_EVENT_MASK);
  }

  public MaskTextField(String mask) {
    this("",mask);
  }

  public void setBeep(boolean b) {
    beep = b;
  }

  public String getError() {
    return error;
  }

  public void processKeyEvent(KeyEvent e) {
    if (e.getID() == e.KEY_PRESSED && e.getKeyCode() == e.VK_DELETE)
      e.consume();
    if (e.getID() == e.KEY_TYPED && e.getKeyChar() == e.VK_BACK_SPACE)
      e.consume();

    if (e.getID() == e.KEY_TYPED && e.getKeyChar() != e.VK_BACK_SPACE) {
      try {
        int poz = getCaretPosition();
        if (poz >= mask.length())
          throw new Exception("Mez� v�ge!");
        char c = e.getKeyChar();
        char maskChar = mask.charAt(poz);
        switch (maskChar) {
          case '9':
            if (!Character.isDigit(c))
              throw new Exception("Nem sz�m!");
            break;
          case 'A':
            c = Character.toUpperCase(c);
            if (c < 'A' | c > 'Z')
              throw new Exception("Nem bet�");
            break;
          case 'X':
            break;
          default :
            if (c != maskChar)
              throw new Exception("Nem karakter");
            break;
        }
        // A karakter lecser�l�se a poz poz�ci�ban.
        // Az �s lekezel� nem j�, mert az insert m�dban dolgozik:
        StringBuffer text = new StringBuffer(getText());
        text.setCharAt(poz,e.getKeyChar());
        setText(text.toString());
        setCaretPosition(poz+1);
      }
      catch (Exception ex) {
        e.consume();
        error = ex.getMessage();
        if (beep)
          Toolkit.getDefaultToolkit().beep();
      }
    }
    else
      super.processKeyEvent(e);
  }
} // MaskTextField
