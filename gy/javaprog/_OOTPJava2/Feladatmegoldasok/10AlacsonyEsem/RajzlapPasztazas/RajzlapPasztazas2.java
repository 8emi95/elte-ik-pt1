/*
 * Feladatmegoldások/10. fejezet
 * RajzlapPasztazas2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Pásztázás vízszintes és függõleges görgetõsávok (JScrollBar) segítségével
 * A JScrollPane használatával sokkal egyszerûbb a megoldás.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 Egy olyan rajzlap, amelynek csak egy része látható.
 A teljes rajzlap mérete totalWidth*totalHeight.
 A látható rész bal felsõ sarka a rajzlap (x,y) pontja.
 */
class Rajzlap extends JPanel {
  private int totalWidth, totalHeight; // a rajzlap teljes mérete
  private int x,y; // a látható rész bal felsõ sarka a rajzlaphoz viszonyítva

  public Rajzlap(int totalWidth, int totalHeight) {
    this.totalWidth = totalWidth;
    this.totalHeight = totalHeight;
    x = 0;
    y = 0;
  }

  public int getTotalWidth() { return totalWidth; }
  public int getTotalHeight() { return totalHeight; }

  // A rajzlap elkészítése. Halványzöld alapon egy nagy fekete X és egy kör.
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Eltolás: a rajzlap (x,y) pontja a látható rész bal felsõ sarka:
    g.translate(-x,-y);

    // A rajzlap színezése:
    g.setColor(new Color(230,240,220));
    g.fillRect(0,0,totalWidth,totalHeight);

    // Nagy X húzása:
    g.setColor(Color.black);
    g.drawLine(0,0,totalWidth,totalHeight); // vonal balról jobbra
    g.drawLine(totalWidth,0,0,totalHeight); // vonal jobbról balra

    // Kör húzása:
    g.drawOval(0,0,totalWidth,totalHeight);
  }

  // A látható rész bal felsõ sarkának átállítása:
  public void translate(int x, int y) {
    this.x = x;
    this.y = y;
    repaint();
  }
}

// Fõosztály:
public class RajzlapPasztazas2 extends JFrame implements AdjustmentListener {
  private Container cp = getContentPane();
  private Rajzlap rajzlap;

  private JScrollBar sbVizszintes; // Vízszintes görgetõsáv
  private JScrollBar sbFuggoleges; // Függõéeges görgetõsáv

  public RajzlapPasztazas2() {
    setSize(800,500);
    setTitle("Rajzlap pásztázása két JScrollBar segítségével");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    cp.add(rajzlap = new Rajzlap(2000,1000),"Center");
    /* ScrollBar konstruktor paraméterei:
     * orientation, value, visible, minimum, maximum */
    cp.add(sbVizszintes = new JScrollBar(
      JScrollBar.HORIZONTAL,0,0,0,rajzlap.getTotalWidth()),"South");
    cp.add(sbFuggoleges = new JScrollBar(
      JScrollBar.VERTICAL,0,0,0,rajzlap.getTotalHeight()),"East");
    sbVizszintes.addAdjustmentListener(this);
    sbFuggoleges.addAdjustmentListener(this);

    // A görgetõsáv csúszkaméretének figyelése és állítása:
    addComponentListener(new ComponentAdapter() {
      public void componentShown(ComponentEvent e) {
        setVisibleAmounts();
      }
      public void componentResized(ComponentEvent e) {
        setVisibleAmounts();
      }
      void setVisibleAmounts() {
        sbVizszintes.setVisibleAmount(rajzlap.getWidth());
        sbFuggoleges.setVisibleAmount(rajzlap.getHeight());
        rajzlap.translate(sbVizszintes.getValue(),sbFuggoleges.getValue());
      }
    });
    show();
  }

  public void adjustmentValueChanged(AdjustmentEvent e) {
    rajzlap.translate(sbVizszintes.getValue(),sbFuggoleges.getValue());
  }

  public static void main (String args[]) {
    new RajzlapPasztazas2();
  }
}
