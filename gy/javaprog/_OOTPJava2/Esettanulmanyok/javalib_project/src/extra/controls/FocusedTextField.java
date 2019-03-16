/*
 * Mintaprogramok/11. fejezet
 * Projekt: Komponens
 * FocusedTextField.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Ha f�kuszban van, feh�r.
 */

package extra.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FocusedTextField extends JTextField {
  Color szin=Color.lightGray;

  public FocusedTextField(int columns) {
    super(columns);
    enableEvents(AWTEvent.FOCUS_EVENT_MASK);
    setBackground(szin);
  }

  public void processFocusEvent(FocusEvent e) {
    if (e.getID()==FocusEvent.FOCUS_GAINED)
      setBackground(Color.white);
    else
      setBackground(szin);
    super.processFocusEvent(e);
  }
} // FocusedTextField
