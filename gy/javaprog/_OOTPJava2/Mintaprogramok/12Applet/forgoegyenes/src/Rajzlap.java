/*
 * Mintaprogramok/12. fejezet
 * Projekt: forgoegyenes
 * Rajzlap.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rajzlap extends JPanel implements ActionListener {
  private Timer timer = new Timer(50,this);
  private int szog = 0;
  private int r = 100;
  private Color vilagosSzurke = new Color(220,220,220);
  private Color lila = new Color(170,120,160);

  public Rajzlap() {
    setBackground(vilagosSzurke);
    timer.start();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.translate(getWidth()/2,getHeight()/2);
    int x = (int)(r*Math.cos(Math.toRadians(szog)));
    int y = (int)(r*Math.sin(Math.toRadians(szog)));
    g.setColor(lila);
    g.drawLine(-x,-y,x,y);
  }

  public void actionPerformed(ActionEvent e) {
    szog+=5;
    repaint();
  }
}
