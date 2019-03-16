/*
 * Feladatmegold�sok/11. fejezet
 * Projekt: KomponensFel
 * Csomag: extra.controls
 * ControlledTextField.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Nem engedi ki a f�kuszb�l, ha az els� karakter nem A vagy B bet�.
 */

package extra.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlledTextField extends JTextField implements FocusListener {
  int n;

  public ControlledTextField(String text,int columns) {
    super(text,columns);
    addFocusListener(this);
  }

  public ControlledTextField(int columns) {
    this("A",columns);
    setCaretPosition(1);
  }

  // Akkor helyes a mez�, ha az els� karakter 'A' vagy 'B':
  public boolean ok() {
    return (getText().length()>0 &&
      (getText().charAt(0)=='A' || getText().charAt(0)=='B'));
  }

  public void focusGained(FocusEvent e) {
  }

  public void focusLost(FocusEvent e) {
    if (!ok()) {
      Toolkit.getDefaultToolkit().beep();
      requestFocus();
      setCaretPosition(0);
    }
  }
} // ControlledTextField
