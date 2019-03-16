/*
 * Feladatmegoldások/9. fejezet
 * Orak.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Ora extends JPanel implements ActionListener {
  private int r;       // az óralap sugara
  private int ora;
  private int perc;
  private int mp;
  private Timer timer;

  public Ora(int ora, int perc, int mp) {
    this.ora = ora;
    this.perc = perc;
    this.mp = mp;
    timer = new Timer(1000,this);
    timer.start();
  }

  Point p (int szog, int sugar) {
    int x=(int)(sugar*Math.cos(Math.toRadians(szog)));
    int y=(int)(sugar*Math.sin(Math.toRadians(szog)));
    return new Point(x,y);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    setBackground(Color.lightGray);
    g.setColor(Color.lightGray);
    g.draw3DRect(1,1,getWidth()-2,getHeight()-2,true);
    g.translate(getWidth()/2,getHeight()/2);
    r = getWidth()/2-10;

    // Óralap megrajzolása:
    g.setColor(new Color(200,210,200));
    g.fillOval(-(r+1),-(r+1),2*(r+1),2*(r+1));
    g.setColor(Color.darkGray);
    g.setColor(Color.black);
    for (int ora=1; ora<=12; ora++) {
      int szog = ora*30-90;
      Point p1 = p(szog,r-1);
      Point p2 = p(szog,r-4);
      g.drawLine(p1.x,p1.y,p2.x,p2.y);
    }
    for (int ora=3; ora<=12; ora++) {
      int szog = ora*30-90;
      Point p = p(szog,r-10);
      if (ora%3==0)
        g.drawString(""+ora,p.x-3,p.y+5);
    }

    // Óra mutató:
    g.setColor(Color.black);
    Point p = p(ora*30-90,r-25);
    g.drawLine(0,0,p.x,p.y);

    // Perc mutató:
    p = p(perc*6-90,r-15);
    g.drawLine(0,0,p.x,p.y);

    // Másodperc mutató:
    g.setColor(Color.white);
    p = p(mp*6-90,r-2);
    g.drawLine(0,0,p.x,p.y);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==timer) {
      mp++;
      if (mp==60) {
        perc++;
        mp = 0;
        if (perc==60) {
          ora++;
          perc = 0;
          if (ora==24)
            ora = 0;
        }
      }
    }
    repaint();
  }
}

public class Orak extends JFrame {
  public Orak() {
    setBounds(100,100,280,180);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container cp = getContentPane();
    cp.setLayout(new GridLayout(1,2));
    cp.add(new Ora(8,12,0));
    cp.add(new Ora(10,7,32));
    show();
  }

  public static void main (String args[]) {
    new Orak();
  }
}
