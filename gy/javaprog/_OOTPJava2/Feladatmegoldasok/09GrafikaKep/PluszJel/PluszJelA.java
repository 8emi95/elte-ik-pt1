/*
 * Feladatmegoldások/9. fejezet
 * PluszJelA.java
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
    int x = getWidth();
    int y = getHeight();
    g.drawLine(x/2,0,x/2,y);
    g.drawLine(0,y/2,x,y/2);
  }
}

public class PluszJelA extends JFrame {
  public PluszJelA() {
    setBounds(100,100,500,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(new Rajz());
    show();
  }

  public static void main (String args[]) {
    new PluszJelA();
  }
}
