/*
 * Feladatmegold�sok/18. fejezet
 * PrintTilos.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.JPanel;
import java.awt.print.*;
import java.awt.Graphics;
import java.awt.*;

// A "Meg�llni tilos!" jelz�s egy piros vastag k�r, benne k�t vastag ferde piros egyenes.
class Lap implements Printable {
  private int x, y;    // a lap k�z�ppontj�nak x �s y koordin�t�i
  private int s=150;   // sug�r
  private int v=10;    // vastags�g
  private int fv=v/2;  // fele vastags�g
  // A ferde egyenes v�g�nek x, y t�vols�ga a k�z�ppontt�l:
  private int px=(int)(s*Math.cos(0.7));
  private int py=(int)(s*Math.sin(0.7));

  public int print(Graphics gr, PageFormat pf, int pageIndex) throws PrinterException {
    if (pageIndex>=1)
      return NO_SUCH_PAGE;

    // A k�z�ppont sz�m�t�sa:
    x=(int)pf.getWidth()/2;
    y=(int)pf.getHeight()/2;

    /* Mivel nem lehet megadni az egyenes vastags�g�t, ferde t�glalapokat
     * fogunk kit�lteni. ferde1 �s ferde2 egy-egy ferde t�glalap:
     */
    int[] x1Points = {x-px-fv,x-px+fv,x+px+fv,x+px-fv};
    int[] y1Points = {y-py+fv,y-py-fv,y+py-fv,y+py+fv};
    Polygon ferde1 = new Polygon(x1Points,y1Points,4);

    int[] x2Points = {x-px-fv,x-px+fv,x+px+fv,x+px-fv};
    int[] y2Points = {y+py-fv,y+py+fv,y-py+fv,y-py-fv};
    Polygon ferde2 = new Polygon(x2Points,y2Points,4);

    // Pirossal kit�ltj�k a teljes k�rlapot:
    gr.setColor(Color.red);
    gr.fillOval(x-s-v,y-s-v,2*(s+v),2*(s+v));

    // R�tesz�nk egy feh�r k�rlapot:
    gr.setColor(Color.white);
    gr.fillOval(x-s+v,y-s+v,2*(s-v),2*(s-v));

    // Megh�zzuk a k�t ferde egyenest pirossal:
    gr.setColor(Color.red);
    gr.fillPolygon(ferde1);
    gr.fillPolygon(ferde2);

    return Printable.PAGE_EXISTS;
  }
}

public class PrintTilos {
  private PrinterJob nyomtato = PrinterJob.getPrinterJob();
  private Lap lap = new Lap();

  public PrintTilos() {
    nyomtato.setPrintable(lap);
    try {
      nyomtato.print();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new PrintTilos();
  }
}
