/*
 * Mintaprogramok/11. fejezet
 * Projekt: Komponens
 * NumberTextField.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Sz�vegmez� sz�mok bevitel�re. A megjelen�thet� billenty�k
 * k�z�l csak a sz�mokat fogadja el.
 */

package extra.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberTextField extends JTextField {
  public NumberTextField(int columns) {
    super(columns);
    enableEvents(AWTEvent.KEY_EVENT_MASK);
  }

  public void processKeyEvent(KeyEvent e) {
    if (e.getID() == e.KEY_TYPED) {                        //1
      char c = e.getKeyChar();
      if ((c < '0' || c > '9') & (c != e.VK_BACK_SPACE))   //2
        e.consume();                                       //3
    }
    super.processKeyEvent(e);
  }
} // NumberTextField
