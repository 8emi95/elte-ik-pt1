/*
 * Feladatmegoldások/9. fejezet
 * GombSzonyegApp.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

class GombSzonyegPanel extends JPanel {
  private int atmero;
  private Color szin;

  public GombSzonyegPanel(int atmero, Color szin) {
    this.atmero = atmero;
    this.szin = szin;
  }

  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    // A szín piros részének kezdeti értéke:
    int red = szin.getRed();
    // A piros szín növekmény. Az egyenletes világosodáshoz kell:
    int nRed = (255-red)*2/atmero;

    int green = szin.getGreen();
    int nGreen = (255-green)*2/atmero;

    int blue = szin.getBlue();
    int nBlue = (255-blue)*2/atmero;

     /* Egy gömböcske megrajzolása a bal felsõ sarokban.
      * Egymásra teszünk egyre világosabb körlapokat:
      */
    for (int i=1, d=atmero-2; d>2; i+=1, d-=2) {
      gr.setColor(new Color(red,green,blue));
      gr.fillOval(i,i,d,d);
      // A színek világosítása:
      red+=nRed; if (red>255) red = 255;
      green+=nGreen; if (green>255) green = 255;
      blue+=nBlue; if (blue>255) blue = 255;
    }

    // A megrajzolt gömböcskével beteríti az egész szõnyeget:
    for (int i=0; i*atmero<getHeight();i++)
      for (int j=0; j*atmero<getWidth();j++)
        gr.copyArea(0,0,atmero,atmero,j*atmero,i*atmero);
  }
}

public class GombSzonyeg extends JFrame {

  public GombSzonyeg() {
    setTitle("Gömb szõnyeg");
    setBounds(100,100,400,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    getContentPane().add(new GombSzonyegPanel(50,Color.red));
    show();
  }

  public static void main (String args[]) {
    new GombSzonyeg();
  }
}
