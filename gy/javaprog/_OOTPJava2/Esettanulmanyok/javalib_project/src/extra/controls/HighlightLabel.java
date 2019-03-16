/*
 * Mintaprogramok/11. fejezet
 * Projekt: Komponens
 * HighLightLabel.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Ha felette van az eg�r, akkor f�nyes.
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
