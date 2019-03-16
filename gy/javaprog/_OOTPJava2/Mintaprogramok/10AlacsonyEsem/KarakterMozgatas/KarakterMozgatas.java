/*
 * Mintaprogramok/10. fejezet
 * KarakterMozgatas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class KarakterVaszon extends JPanel implements KeyListener {
  private static final int STEP=10; // az elmozdul�s l�pt�ke
  private static final int INCR=5;  // a bet�m�ret n�vekm�nye
  private char karakter='?';    // a v�sznon megjelen� karakter
  private int meret=35;         // a bet� aktu�lis m�rete
  private int x=100,y=100;      // a bet� aktu�lis poz�ci�ja

  public KarakterVaszon() {
    addKeyListener(this);                                  //1
  }

  public void paintComponent(Graphics gr) {                //2
    super.paintComponent(gr);
    requestFocus();
    gr.setFont(new Font("Dialog",Font.PLAIN,meret));
    gr.drawString(""+karakter,x,y);
  }

  public void keyPressed(KeyEvent ev) {                    //3
    if (ev.getKeyCode() == ev.VK_UP)
      y -= STEP;
    else if (ev.getKeyCode() == ev.VK_DOWN)
      y += STEP;
    else if (ev.getKeyCode() == ev.VK_LEFT)
      x -= STEP;
    else if (ev.getKeyCode() == ev.VK_RIGHT)
      x += STEP;
    else if (ev.getKeyCode() == ev.VK_F5)
      meret += INCR;
    else if (ev.getKeyCode() == ev.VK_F6 && meret >= INCR)
      meret -= INCR;
    else if (ev.getKeyCode() == ev.VK_ESCAPE)
      System.exit(0);
    repaint();
  }

  public void keyReleased(KeyEvent ev) {
  }

  public void keyTyped(KeyEvent ev) {                      //4
    karakter = ev.getKeyChar();
    repaint();
  }
}

public class KarakterMozgatas extends JFrame {
  public KarakterMozgatas() {
    setBounds(100,100,500,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Karaktermozgat�s. Bet�, Fel, Le, Balra, "+
                   "Jobbra, F5, F6");
    Container cp = getContentPane();
    cp.add(new KarakterVaszon());
    show();
  }

  public static void main(String args[]) {
    new KarakterMozgatas();
  } // main
} // KarakterMozgatas
