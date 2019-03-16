/*
 * Feladatmegoldások/9. fejezet
 * PacMan.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// Egy kis plusz. Ezek a csámcsogáshoz kellenek:
import java.applet.*;

class PacMan extends JPanel implements ActionListener {
  private Timer timer;
  private int delay;
  private int pozX, pozY;   // Pacman pozíciója
  private int radius;       // Pacman átmérõje
  private Color color;      // Pacman színe
  private int szajSzog = 0; // felsõ ajka ekkor szövege zár be a vízszintes tengellyel
  private int maxSzajSzog = 30; // kétszer ekkorára tudja kinyitni a száját
  private int szajSzogInc = 2;  // egy lépésben ennyivel lesz nagyobb a szája
  private AudioClip ac;     // csámcsogás hangja

  public PacMan(int r, Color c, int d) {
    radius = r;
    color = c;
    delay = d;
    setBackground(Color.lightGray);
    pozX = 0; pozY = 0;
    // Csámcsogás hangjának betöltése:
    /*
    try {
      ac = Applet.newAudioClip(new URL("file:///c:/javaprog/sounds/csam.wav"));
      ac.play();
    }
    catch (Exception e){
    }
    */
    // Idõzítõ indul:
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
      ac.play(); // csámcsogás
    */
    if (ujSzog>maxSzajSzog || ujSzog<0)
      szajSzogInc = -szajSzogInc;
    szajSzog += szajSzogInc;
    repaint();
  }
}
