/*
 * Feladatmegold�sok/10. fejezet
 * RajzlapPasztazas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * P�szt�z�s g�rget�panel (JScrollPane) seg�ts�g�vel
 */

import javax.swing.*;
import java.awt.*;

/*
 Egy olyan rajzlap, amelynek csak egy r�sze l�that�.
 A teljes rajzlap m�rete width*height.
 */
class Rajzlap extends JPanel {

  public Rajzlap(int width, int height) {
    Dimension size = new Dimension(width,height);
    this.setPreferredSize(size);
  }

  // A rajzlap elk�sz�t�se. Halv�nyz�ld alapon egy nagy fekete X �s egy k�r.
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    // A rajzlap sz�nez�se:
    setBackground(new Color(230,240,220));
    setOpaque(true);

    // Nagy X h�z�sa:
    g.setColor(Color.black);
    g.drawLine(0,0,getWidth(),getHeight()); // vonal balr�l jobbra
    g.drawLine(getWidth(),0,0,getHeight()); // vonal jobbr�l balra

    // K�r h�z�sa:
    g.drawOval(0,0,getWidth(),getHeight());
  }

}

public class RajzlapPasztazas extends JFrame {

  public RajzlapPasztazas() {
    setSize(800,500);
    setTitle("Rajzlap p�szt�z�sa JScrollPane seg�ts�g�vel");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JScrollPane sp = new JScrollPane(new Rajzlap(2000,1000));
    getContentPane().add(sp,"Center");

    show();
  }

  public static void main (String args[]) {
    new RajzlapPasztazas();
  }
}
