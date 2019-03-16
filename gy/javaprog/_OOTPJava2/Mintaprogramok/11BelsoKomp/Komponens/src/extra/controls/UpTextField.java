/*
 * Mintaprogramok/11. fejezet
 * Projekt: Komponens
 * UpTextField.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Minden betût nagybetûvé alakít.
 */

package extra.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpTextField extends JTextField {
  public UpTextField(int columns) {
    super(columns);
    enableEvents(AWTEvent.KEY_EVENT_MASK);                 //1
  }

  public void processKeyEvent(KeyEvent e) {                //2
    if (e.getID() == e.KEY_TYPED) {
      char c = Character.toUpperCase(e.getKeyChar());      //3
      e.setKeyChar(c);
    }
    super.processKeyEvent(e);                              //4
  }
} // UpTextField
