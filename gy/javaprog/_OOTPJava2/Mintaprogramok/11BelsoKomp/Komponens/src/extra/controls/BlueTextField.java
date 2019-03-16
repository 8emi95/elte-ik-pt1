/*
 * Mintaprogramok/11. fejezet
 * Projekt: Komponens
 * BlueTextField.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Min�l hossszabb a sz�veg, ann�l k�kebb.
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

