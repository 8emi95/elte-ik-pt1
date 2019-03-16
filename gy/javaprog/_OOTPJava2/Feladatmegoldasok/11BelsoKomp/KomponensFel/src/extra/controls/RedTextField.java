/*
 * Feladatmegoldások/11. fejezet
 * Projekt: KomponensFel
 * Csomag: extra.controls
 * RedTextField.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Minél nagyobb a kurzor poziciója, annál pirosabb.
 */

package extra.controls;

import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class RedTextField extends JTextField {

  public RedTextField(int columns) {
    super(columns);
    enableEvents(AWTEvent.KEY_EVENT_MASK+AWTEvent.MOUSE_EVENT_MASK);
  }

  private void setColor() {
    int pos = getCaretPosition();
    int n = (255-pos*3>105) ? 255-pos*3:105;
    setBackground(new Color(255,n,n));
  }

  public void processKeyEvent(KeyEvent e) {
    setColor();
    super.processKeyEvent(e);
  }

  public void processMouseEvent(MouseEvent e) {
    setColor();
    super.processMouseEvent(e);
  }
} // RedTextField
