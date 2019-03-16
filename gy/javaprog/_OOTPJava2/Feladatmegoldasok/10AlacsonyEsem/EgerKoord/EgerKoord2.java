/*
 * Feladatmegoldások/10. fejezet
 * EgerKoord2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

class EgerVaszon2 extends JPanel {
  private Vector pontok = new Vector();  // az összes pont

  public EgerVaszon2() {
    addMouseListener(new EgerFigyelo());
  }

  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    for (int i=0; i<pontok.size(); i++) {
      Point pont = (Point)pontok.get(i);
      gr.drawString("("+pont.x+","+pont.y+")",pont.x,pont.y);
    }
  }

  // Ha legalább kettõt kattintanak, hozzáadjuk a vektorhoz a legutolsó pontot, és újrarajzoljuk a panelt:
  class EgerFigyelo extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
      if (e.getClickCount()>=2) {
        pontok.add(new Point(e.getX(),e.getY()));
        repaint();
      }
    }
  }
}

public class EgerKoord2 extends JFrame {

  public EgerKoord2() {
    setTitle("Utolsó egérkoordináta");
    setBounds(0,0,640,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(new EgerVaszon2());
    show();
  }

  public static void main (String args[]) {
    new EgerKoord2();
  } // main
} // EgerKoord2
