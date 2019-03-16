/*
 * Mintaprogramok/10. fejezet
 * Pontozo.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

class PontozoVaszon extends JPanel {
  private Vector pontok = new Vector();                    //1

  public PontozoVaszon() {
    setBackground(Color.PINK);
    setOpaque(true);
    addMouseListener(new EgerFigyelo());                   //2
  }

  public void paintComponent(Graphics gr) {                //3
    super.paintComponent(gr);
    Point p;
    for (int i=0; i<pontok.size(); i++) {
      p = (Point)(pontok.get(i));
      gr.fillOval(p.x,p.y,5,5);
    }
  }

  class EgerFigyelo extends MouseAdapter {
    public void mousePressed(MouseEvent e) {               //4
      pontok.add(new Point(e.getX(),e.getY()));
      Graphics gr = getGraphics();
      gr.fillOval(e.getX(),e.getY(),5,5);
      gr.dispose();
    }
  }
}

public class Pontozo extends JFrame {
  public Pontozo() {
    setTitle("Pontozás");
    setBounds(0,0,640,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(new PontozoVaszon());
    show();
  }

  public static void main (String args[]) {
    new Pontozo();
  } // main
} // Pontozo
