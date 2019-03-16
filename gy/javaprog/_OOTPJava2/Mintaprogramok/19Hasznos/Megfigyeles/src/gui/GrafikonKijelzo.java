package gui;
import java.util.*;
import javax.swing.*;
import java.awt.Graphics;

public class GrafikonKijelzo extends JPanel implements Observer {
  BetuStatisztika bs;

  public void update(Observable o, Object arg) {
    bs = (BetuStatisztika)o;
    repaint();
  }
  public void paintComponent(Graphics gr) {
    int oszlopSzel = getWidth()/26;
    double egyseg = (double)(getHeight()-20)/bs.max();
    for (char c = 'A'; c < 'Z'; c++) {
      int oszlopMag = (int)(egyseg * bs.hany(c));
      int i = c-'A';
      gr.drawRect(i*oszlopSzel,oszlopMag,(i+1)*oszlopSzel,getHeight());
    }
  }
}
