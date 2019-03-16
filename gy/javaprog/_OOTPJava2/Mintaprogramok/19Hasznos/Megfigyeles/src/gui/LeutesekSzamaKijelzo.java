/*
 * Mintaprogramok/19. fejezet
 * Projekt: Megfigyeles
 * Csomag: gui
 * LeutesekSzamaKijelzo.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package gui;
import db.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class LeutesekSzamaKijelzo extends JPanel implements Observer {
  private int szel = 0;

  public void update(Observable obj, Object arg) {
    if (!(obj instanceof BetuStatisztika))
      return;
    BetuStatisztika bs = (BetuStatisztika)obj;
    szel = bs.leutesekSzama();
    repaint();
  }

  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    int mag = getHeight();
    if (szel>getWidth())
      szel = getWidth();

    gr.fillRect(0,0,szel-1,mag-1);
  }
}
