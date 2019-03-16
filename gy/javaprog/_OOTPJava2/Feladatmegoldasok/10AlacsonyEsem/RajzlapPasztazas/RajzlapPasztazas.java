/*
 * Feladatmegoldások/10. fejezet
 * RajzlapPasztazas.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Pásztázás görgetõpanel (JScrollPane) segítségével
 */

import javax.swing.*;
import java.awt.*;

/*
 Egy olyan rajzlap, amelynek csak egy része látható.
 A teljes rajzlap mérete width*height.
 */
class Rajzlap extends JPanel {

  public Rajzlap(int width, int height) {
    Dimension size = new Dimension(width,height);
    this.setPreferredSize(size);
  }

  // A rajzlap elkészítése. Halványzöld alapon egy nagy fekete X és egy kör.
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    // A rajzlap színezése:
    setBackground(new Color(230,240,220));
    setOpaque(true);

    // Nagy X húzása:
    g.setColor(Color.black);
    g.drawLine(0,0,getWidth(),getHeight()); // vonal balról jobbra
    g.drawLine(getWidth(),0,0,getHeight()); // vonal jobbról balra

    // Kör húzása:
    g.drawOval(0,0,getWidth(),getHeight());
  }

}

public class RajzlapPasztazas extends JFrame {

  public RajzlapPasztazas() {
    setSize(800,500);
    setTitle("Rajzlap pásztázása JScrollPane segítségével");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JScrollPane sp = new JScrollPane(new Rajzlap(2000,1000));
    getContentPane().add(sp,"Center");

    show();
  }

  public static void main (String args[]) {
    new RajzlapPasztazas();
  }
}
