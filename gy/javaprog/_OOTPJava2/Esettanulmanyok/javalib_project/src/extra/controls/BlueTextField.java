/*
 * Mintaprogramok/11. fejezet
 * Projekt: Komponens
 * BlueTextField.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Minél hossszabb a szöveg, annál kékebb.
 */

package extra.controls;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class BlueTextField extends JTextField implements DocumentListener {
  public BlueTextField(int columns) {
    super(columns);
    this.getDocument().addDocumentListener(this);
  }

  void update() {
    int len = getText().length();
    int n = (255-len*5>100) ? 255-len*5:100 ;
    setBackground(new Color(n,n,255));
  }

  public void insertUpdate(DocumentEvent e) {
    update();
  }
  public void removeUpdate(DocumentEvent e) {
    update();
  }
  public void changedUpdate(DocumentEvent e) {
  }
} // BlueTextField

