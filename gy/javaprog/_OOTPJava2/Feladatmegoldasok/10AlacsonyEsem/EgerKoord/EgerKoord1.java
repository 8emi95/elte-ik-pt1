/*
 * Feladatmegold�sok/10. fejezet
 * EgerKoord1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EgerVaszon1 extends JPanel {
  private Point pont; // a legutols� pont

  public EgerVaszon1() {
    addMouseListener(new EgerFigyelo());
  }

  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    if (pont!=null)
      gr.drawString("("+pont.x+","+pont.y+")",pont.x,pont.y);
  }

  // Ha legal�bb kett�t kattintanak, megjegyezz�k a legutols� pontot, �s �jrarajzoljuk a panelt:
  class EgerFigyelo extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
      if (e.getClickCount()>=2) {
        pont = new Point(e.getX(),e.getY());
        repaint();
      }
    }
  }
}

public class EgerKoord1 extends JFrame {

  public EgerKoord1() {
    setTitle("Utols� eg�rkoordin�ta");
    setBounds(0,0,640,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(new EgerVaszon1());
    show();
  }

  public static void main (String args[]) {
    new EgerKoord1();
  } // main
} // EgerKoord1
