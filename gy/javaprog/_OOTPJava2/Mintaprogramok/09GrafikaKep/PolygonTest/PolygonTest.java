/*
 * Mintaprogramok/9. fejezet
 * PolygonTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

class PolygonPanel extends JPanel {
  private int n;      // a szab�lyos soksz�g sz�geinek a sz�ma
  private int radius;    // a soksz�g k�r� �rhat� k�r sugara
  private Polygon poly;  // a soksz�g

  public PolygonPanel(int n, int radius) {
    this.n = n;
    this.radius = radius;
    int alfa = 360/n; // egy cikk sz�ge fokban

    poly = new Polygon();                                  //1
    for (int i=0; i<n; i++) {
      int x=(int)(radius*Math.cos(Math.toRadians(i*alfa)));
      int y=(int)(radius*Math.sin(Math.toRadians(i*alfa)));
      poly.addPoint(x,y);                                  //2
    }
  }

  protected void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    gr.translate(getWidth()/2,getHeight()/2);              //3
    setBackground(new Color(255,255,210));
    gr.setColor(Color.LIGHT_GRAY);
    gr.fillPolygon(poly);                                  //4
    gr.setColor(Color.BLACK);
    gr.drawPolygon(poly);                                  //5
    gr.fillOval(-5,-5,10,10);                              //6
  }
}

public class PolygonTest extends JFrame {

  public PolygonTest(int n, int radius) {
    setBounds(500,200,300,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(new PolygonPanel(n,radius));
    show();
  }

  public static void main (String args[]) {
    try {
      int n = Integer.parseInt(args[0]);
      int radius = Integer.parseInt(args[1]);
      new PolygonTest(n,radius);
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,
         "A program haszn�lata: \nPolygonTest n radius." +
         "\n\nP�ld�ul : PolygonTest 5 100",
         "Nincs programparam�ter!",
         JOptionPane.WARNING_MESSAGE);
         System.exit(0);
    }
  }
} // PolygonTest
