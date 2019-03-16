/*
 * Feladatmegoldások/11. fejezet
 * Projekt: KomponensFel
 * Csomag: extra.controls
 * MaskTextField.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * A megadott maszk szerinti mezõt szerkeszti. Felülíró üzemmódban mûködik, a delete hatástalan.
 * Maszkok: A: betû; 9: szám; X: bármilyen karakter.
 * A getError metódus megadja az utoljára bekövetkezett hiba szövegét.
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
    // Ha nem jó hosszúságú indító szöveget adnak meg, akkor a szöveg maga a maszk lesz:
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
          throw new Exception("Mezõ vége!");
        char c = e.getKeyChar();
        char maskChar = mask.charAt(poz);
        switch (maskChar) {
          case '9':
            if (!Character.isDigit(c))
              throw new Exception("Nem szám!");
            break;
          case 'A':
            c = Character.toUpperCase(c);
            if (c < 'A' | c > 'Z')
              throw new Exception("Nem betû");
            break;
          case 'X':
            break;
          default :
            if (c != maskChar)
              throw new Exception("Nem karakter");
            break;
        }
        // A karakter lecserélése a poz pozícióban.
        // Az õs lekezelõ nem jó, mert az insert módban dolgozik:
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
