/*
 * Feladatmegoldások/13. fejezet
 * Projekt: KepNezegeto
 * ImagePanel.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Képet tartó panel
 */

import javax.swing.*;
import java.io.*;
import java.awt.*;

public class ImagePanel extends JPanel {
  private Image img = null;

  public ImagePanel() {
    setBorder(BorderFactory.createEtchedBorder());
  }

  // Az f képfájl betöltése:
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

