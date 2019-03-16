/*
 * Feladatmegold�sok/13. fejezet
 * Projekt: KepNezegeto
 * ImagePanel.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * K�pet tart� panel
 */

import javax.swing.*;
import java.io.*;
import java.awt.*;

public class ImagePanel extends JPanel {
  private Image img = null;

  public ImagePanel() {
    setBorder(BorderFactory.createEtchedBorder());
  }

  // Az f k�pf�jl bet�lt�se:
  public void load(File f) {
    img = Toolkit.getDefaultToolkit().createImage(f.getAbsolutePath());
    MediaTracker tr = new MediaTracker(this);
    tr.addImage(img,0);
    try {
      tr.waitForID(0);
    }
    catch(InterruptedException e) {
    }
    repaint();
  }

  public void clear() {
    img = null;
    repaint();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (img != null)
      g.drawImage(img,0,0,this);
  }

}

