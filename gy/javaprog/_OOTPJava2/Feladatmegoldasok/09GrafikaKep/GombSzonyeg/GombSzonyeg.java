/*
 * Feladatmegold�sok/9. fejezet
 * GombSzonyegApp.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    // A sz�n piros r�sz�nek kezdeti �rt�ke:
    int red = szin.getRed();
    // A piros sz�n n�vekm�ny. Az egyenletes vil�gosod�shoz kell:
    int nRed = (255-red)*2/atmero;

    int green = szin.getGreen();
    int nGreen = (255-green)*2/atmero;

    int blue = szin.getBlue();
    int nBlue = (255-blue)*2/atmero;

     /* Egy g�mb�cske megrajzol�sa a bal fels� sarokban.
      * Egym�sra tesz�nk egyre vil�gosabb k�rlapokat:
      */
    for (int i=1, d=atmero-2; d>2; i+=1, d-=2) {
      gr.setColor(new Color(red,green,blue));
      gr.fillOval(i,i,d,d);
      // A sz�nek vil�gos�t�sa:
      red+=nRed; if (red>255) red = 255;
      green+=nGreen; if (green>255) green = 255;
      blue+=nBlue; if (blue>255) blue = 255;
    }

    // A megrajzolt g�mb�csk�vel beter�ti az eg�sz sz�nyeget:
    for (int i=0; i*atmero<getHeight();i++)
      for (int j=0; j*atmero<getWidth();j++)
        gr.copyArea(0,0,atmero,atmero,j*atmero,i*atmero);
  }
}

public class GombSzonyeg extends JFrame {

  public GombSzonyeg() {
    setTitle("G�mb sz�nyeg");
    setBounds(100,100,400,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    getContentPane().add(new GombSzonyegPanel(50,Color.red));
    show();
  }

  public static void main (String args[]) {
    new GombSzonyeg();
  }
}
