/*
 * Feladatmegold�sok/10. fejezet
 * KepMozgatas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MozgoKep extends JPanel implements KeyListener, ComponentListener {
  private Image kep;           // mozgathat� k�p
  private int x,y;             // k�p kezdeti koordin�t�ja
  private final int STEP = 10; // k�p mozgat�s�nak l�pt�ke
  private boolean lathato;     // k�p l�that�s�ga
  private int prevWidth=0, prevHeight=0;

  // Mozg� k�p. Neve: kepNev, helyzete a sz�l� panelen: x,y
  public MozgoKep(String kepNev, int x, int y) {
    this.x = x;
    this.y = y;
    lathato = true;
    setBackground(SystemColor.menu);

    // K�p bet�lt�se:
    MediaTracker tr = new MediaTracker(this);
    kep = Toolkit.getDefaultToolkit().createImage(kepNev);
    tr.addImage(kep,0);
    try {
      tr.waitForID(0);
    }
    catch(InterruptedException e) {
    }

    // A k�p m�ret�nek tized�re cs�kkent�se:
    kep = kep.getScaledInstance(kep.getWidth(this)/10,
          kep.getHeight(this)/10,Image.SCALE_FAST);

    // A mozg� k�p saj�t mag�t ir�ny�tja:
    addKeyListener(this);
    addComponentListener(this);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    requestFocus();
    if (lathato)
      g.drawImage(kep,x,y,this);
  }

  public void keyTyped(KeyEvent e) {
  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == e.VK_UP) {
      y -= STEP;
      if (y < 0)
        y = 0;
      repaint();
    }
    else if (e.getKeyCode() == e.VK_DOWN) {
      y += STEP;
      int hatar = this.getHeight()-kep.getHeight(this);
      if (y > hatar)
        y = hatar;
      repaint();
    }
    else if (e.getKeyCode() == e.VK_LEFT) {
      x -= STEP;
      if (x < 0)
        x = 0;
      repaint();
    }
    else if (e.getKeyCode() == e.VK_RIGHT) {
      x += STEP;
      int hatar = this.getWidth()-kep.getWidth(this);
      if (x > hatar)
        x = hatar;
      repaint();
    }
    else if (e.getKeyCode() == e.VK_F1) {
      lathato = !lathato;
      repaint();
    }
  }

  public void keyReleased(KeyEvent e) {
  }

  public void componentHidden(ComponentEvent e) {
  }

  public void componentMoved(ComponentEvent e) {
  }

  // Ha �tm�retezik a panelt, akkor a k�p poz�ci�ja ar�nyosan
  // v�ltozik a panel m�ret�vel:
  public void componentResized(ComponentEvent e) {
    if (prevWidth!=0)
      x = (int)(1.0*getWidth()*x/prevWidth);
    if (prevHeight!=0)
      y = (int)(1.0*getHeight()*y/prevHeight);
    prevWidth = getWidth();
    prevHeight = getHeight();
    System.out.println(prevWidth+","+prevHeight);
    repaint();
  }

  public void componentShown(ComponentEvent e) {
  }
}

public class KepMozgatas extends JFrame {
  private Container cp = getContentPane();

  public KepMozgatas() {
    setBounds(100,100,600,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.add(new MozgoKep("images/amhappy.jpg",100,100));
    show();
  }

  public static void main (String args[]) {
    new KepMozgatas();
  } // main
} // KepMozgatas
