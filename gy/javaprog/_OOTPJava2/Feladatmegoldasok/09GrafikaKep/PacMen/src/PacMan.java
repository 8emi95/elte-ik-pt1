/*
 * Feladatmegold�sok/9. fejezet
 * PacMan.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// Egy kis plusz. Ezek a cs�mcsog�shoz kellenek:
import java.applet.*;

class PacMan extends JPanel implements ActionListener {
  private Timer timer;
  private int delay;
  private int pozX, pozY;   // Pacman poz�ci�ja
  private int radius;       // Pacman �tm�r�je
  private Color color;      // Pacman sz�ne
  private int szajSzog = 0; // fels� ajka ekkor sz�vege z�r be a v�zszintes tengellyel
  private int maxSzajSzog = 30; // k�tszer ekkor�ra tudja kinyitni a sz�j�t
  private int szajSzogInc = 2;  // egy l�p�sben ennyivel lesz nagyobb a sz�ja
  private AudioClip ac;     // cs�mcsog�s hangja

  public PacMan(int r, Color c, int d) {
    radius = r;
    color = c;
    delay = d;
    setBackground(Color.lightGray);
    pozX = 0; pozY = 0;
    // Cs�mcsog�s hangj�nak bet�lt�se:
    /*
    try {
      ac = Applet.newAudioClip(new URL("file:///c:/javaprog/sounds/csam.wav"));
      ac.play();
    }
    catch (Exception e){
    }
    */
    // Id�z�t� indul:
    timer = new Timer(delay,this);
    timer.start();
  }

  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    gr.translate(pozX,getHeight()/2);
    gr.setColor(color);
    gr.fillArc(-radius,-radius,
      2*radius,2*radius,szajSzog,360-2*szajSzog);
  }

  public void actionPerformed(ActionEvent e) {
    pozX+=1;
    if (isShowing() && pozX > getWidth()-20)
      timer.stop();
    int ujSzog = szajSzog+=szajSzogInc;
    /*
    if (ujSzog < 0)
      ac.play(); // cs�mcsog�s
    */
    if (ujSzog>maxSzajSzog || ujSzog<0)
      szajSzogInc = -szajSzogInc;
    szajSzog += szajSzogInc;
    repaint();
  }
}
