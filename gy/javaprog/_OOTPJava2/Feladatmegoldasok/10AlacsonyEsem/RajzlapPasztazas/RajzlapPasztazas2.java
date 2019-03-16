/*
 * Feladatmegold�sok/10. fejezet
 * RajzlapPasztazas2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * P�szt�z�s v�zszintes �s f�gg�leges g�rget�s�vok (JScrollBar) seg�ts�g�vel
 * A JScrollPane haszn�lat�val sokkal egyszer�bb a megold�s.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 Egy olyan rajzlap, amelynek csak egy r�sze l�that�.
 A teljes rajzlap m�rete totalWidth*totalHeight.
 A l�that� r�sz bal fels� sarka a rajzlap (x,y) pontja.
 */
class Rajzlap extends JPanel {
  private int totalWidth, totalHeight; // a rajzlap teljes m�rete
  private int x,y; // a l�that� r�sz bal fels� sarka a rajzlaphoz viszony�tva

  public Rajzlap(int totalWidth, int totalHeight) {
    this.totalWidth = totalWidth;
    this.totalHeight = totalHeight;
    x = 0;
    y = 0;
  }

  public int getTotalWidth() { return totalWidth; }
  public int getTotalHeight() { return totalHeight; }

  // A rajzlap elk�sz�t�se. Halv�nyz�ld alapon egy nagy fekete X �s egy k�r.
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Eltol�s: a rajzlap (x,y) pontja a l�that� r�sz bal fels� sarka:
    g.translate(-x,-y);

    // A rajzlap sz�nez�se:
    g.setColor(new Color(230,240,220));
    g.fillRect(0,0,totalWidth,totalHeight);

    // Nagy X h�z�sa:
    g.setColor(Color.black);
    g.drawLine(0,0,totalWidth,totalHeight); // vonal balr�l jobbra
    g.drawLine(totalWidth,0,0,totalHeight); // vonal jobbr�l balra

    // K�r h�z�sa:
    g.drawOval(0,0,totalWidth,totalHeight);
  }

  // A l�that� r�sz bal fels� sark�nak �t�ll�t�sa:
  public void translate(int x, int y) {
    this.x = x;
    this.y = y;
    repaint();
  }
}

// F�oszt�ly:
public class RajzlapPasztazas2 extends JFrame implements AdjustmentListener {
  private Container cp = getContentPane();
  private Rajzlap rajzlap;

  private JScrollBar sbVizszintes; // V�zszintes g�rget�s�v
  private JScrollBar sbFuggoleges; // F�gg��eges g�rget�s�v

  public RajzlapPasztazas2() {
    setSize(800,500);
    setTitle("Rajzlap p�szt�z�sa k�t JScrollBar seg�ts�g�vel");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    cp.add(rajzlap = new Rajzlap(2000,1000),"Center");
    /* ScrollBar konstruktor param�terei:
     * orientation, value, visible, minimum, maximum */
    cp.add(sbVizszintes = new JScrollBar(
      JScrollBar.HORIZONTAL,0,0,0,rajzlap.getTotalWidth()),"South");
    cp.add(sbFuggoleges = new JScrollBar(
      JScrollBar.VERTICAL,0,0,0,rajzlap.getTotalHeight()),"East");
    sbVizszintes.addAdjustmentListener(this);
    sbFuggoleges.addAdjustmentListener(this);

    // A g�rget�s�v cs�szkam�ret�nek figyel�se �s �ll�t�sa:
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
