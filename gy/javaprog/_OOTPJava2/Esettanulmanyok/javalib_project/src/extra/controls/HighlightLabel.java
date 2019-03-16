/*
 * Mintaprogramok/11. fejezet
 * Projekt: Komponens
 * HighLightLabel.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Ha felette van az egér, akkor fényes.
 */

package extra.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HighlightLabel extends JLabel {
  private Color baseColor, highLightColor;

  public HighlightLabel(String text, Color baseColor,
                        Color highLightColor) {
    super(text);
    this.baseColor = baseColor;
    this.highLightColor = highLightColor;
    enableEvents(AWTEvent.MOUSE_EVENT_MASK);
  }

  public void processMouseEvent(MouseEvent e) {
    if (e.getID() == e.MOUSE_ENTERED)
      setForeground(highLightColor);
    else if (e.getID() == e.MOUSE_EXITED)
      setForeground(baseColor);
    super.processMouseEvent(e);
  }
} // HighlightLabel
