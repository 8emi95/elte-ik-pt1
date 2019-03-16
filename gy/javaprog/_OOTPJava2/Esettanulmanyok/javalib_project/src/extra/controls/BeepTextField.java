/*
 * Feladatmegoldások/11. fejezet
 * Projekt: KomponensFel
 * Csomag: extra.controls
 * BeepTextField.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Billentyûleütéskor sípol egyet.
 */

package extra.controls;

import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class BeepTextField extends JTextField {
  public BeepTextField(int columns) {
    super(columns);
    enableEvents(AWTEvent.KEY_EVENT_MASK);
  }

  public void processKeyEvent(KeyEvent e) {
    if (e.getID() == e.KEY_TYPED) {
      Toolkit.getDefaultToolkit().beep();
    }
    super.processKeyEvent(e);
  }
} // BeepTextField

