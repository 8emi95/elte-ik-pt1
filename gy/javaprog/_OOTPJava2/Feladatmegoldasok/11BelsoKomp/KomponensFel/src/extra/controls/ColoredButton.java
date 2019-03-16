/*
 * Feladatmegoldások/11. fejezet
 * Projekt: KomponensFel
 * Csomag: extra.controls
 * ColoredButton.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Lenyomáskor a gomb elszínezõdik, felengedéskor az eredeti színû.
 */

package extra.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColoredButton extends JButton {
  private Color origColor;
  private Color color;

  public ColoredButton(String text, Color color) {
    super(text);
    this.color = color;
    origColor = getBackground();
    enableEvents(AWTEvent.MOUSE_EVENT_MASK);
  }

  public void processMouseEvent(MouseEvent e) {
    if (e.getID() == e.MOUSE_PRESSED)
      setBackground(color);
    if (e.getID() == e.MOUSE_RELEASED)
      setBackground(origColor);
  }
} // ColoredButton
