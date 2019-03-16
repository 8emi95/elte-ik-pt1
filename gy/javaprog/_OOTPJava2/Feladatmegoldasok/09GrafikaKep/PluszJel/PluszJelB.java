/*
 * Feladatmegoldások/9. fejezet
 * PluszJelB.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Rajz extends JPanel {

  public void paint(Graphics g) {
    super.paintComponent(g);
    g.setColor(new Color(0,150,0));
    int x = getWidth();
    int y = getHeight();
    for (int i = 1; i<=5; i++)
      g.drawLine(x/2-2+i,0,x/2-2+i,y);

    for (int i = 1; i<=5; i++)
      g.drawLine(0,y/2-2+i,x,y/2-2+i);
  }
}

public class PluszJelB extends JFrame {
  public PluszJelB() {
    setBounds(100,100,500,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(new Rajz());
    show();
  }

  public static void main (String args[]) {
    new PluszJelB();
  }
}
