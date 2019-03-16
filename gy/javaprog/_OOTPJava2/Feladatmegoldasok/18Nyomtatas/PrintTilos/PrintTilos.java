/*
 * Feladatmegoldások/18. fejezet
 * PrintTilos.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.JPanel;
import java.awt.print.*;
import java.awt.Graphics;
import java.awt.*;

// A "Megállni tilos!" jelzés egy piros vastag kör, benne két vastag ferde piros egyenes.
class Lap implements Printable {
  private int x, y;    // a lap középpontjának x és y koordinátái
  private int s=150;   // sugár
  private int v=10;    // vastagság
  private int fv=v/2;  // fele vastagság
  // A ferde egyenes végének x, y távolsága a középponttól:
  private int px=(int)(s*Math.cos(0.7));
  private int py=(int)(s*Math.sin(0.7));

  public int print(Graphics gr, PageFormat pf, int pageIndex) throws PrinterException {
    if (pageIndex>=1)
      return NO_SUCH_PAGE;

    // A középpont számítása:
    x=(int)pf.getWidth()/2;
    y=(int)pf.getHeight()/2;

    /* Mivel nem lehet megadni az egyenes vastagságát, ferde téglalapokat
     * fogunk kitölteni. ferde1 és ferde2 egy-egy ferde téglalap:
     */
    int[] x1Points = {x-px-fv,x-px+fv,x+px+fv,x+px-fv};
    int[] y1Points = {y-py+fv,y-py-fv,y+py-fv,y+py+fv};
    Polygon ferde1 = new Polygon(x1Points,y1Points,4);

    int[] x2Points = {x-px-fv,x-px+fv,x+px+fv,x+px-fv};
    int[] y2Points = {y+py-fv,y+py+fv,y-py+fv,y-py-fv};
    Polygon ferde2 = new Polygon(x2Points,y2Points,4);

    // Pirossal kitöltjük a teljes körlapot:
    gr.setColor(Color.red);
    gr.fillOval(x-s-v,y-s-v,2*(s+v),2*(s+v));

    // Ráteszünk egy fehér körlapot:
    gr.setColor(Color.white);
    gr.fillOval(x-s+v,y-s+v,2*(s-v),2*(s-v));

    // Meghúzzuk a két ferde egyenest pirossal:
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
