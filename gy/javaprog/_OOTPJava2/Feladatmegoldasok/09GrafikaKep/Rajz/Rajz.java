/*
 * Feladatmegoldások/9. fejezet
 * Rajz.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Rajzlap extends JPanel {
  private Color lila = new Color(170,120,160);
  private Color vilagosKek = new Color(215,215,255);
  private Color sotetKek = new Color(0,0,180);

  public Rajzlap() {
    setBackground(vilagosKek);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int szel = getWidth();
    int mag = getHeight();
    g.setColor(lila);
    g.fill3DRect(0,0,80,50,true);
    g.fill3DRect(szel-80,0,80,50,true);
    g.fill3DRect(0,mag-50,80,50,true);
    g.fill3DRect(szel-80,mag-50,80,50,true);
    g.translate(szel/2,mag/2);
    g.setColor(sotetKek);
    g.drawRect(-100,-50,200,100);
    g.fillOval(-100,-50,200,100);
  }
}

public class Rajz extends JFrame {
  public Rajz() {
    setBounds(100,100,500,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(new Rajzlap());
    show();
  }

  public static void main (String args[]) {
    new Rajz();
  }
}
