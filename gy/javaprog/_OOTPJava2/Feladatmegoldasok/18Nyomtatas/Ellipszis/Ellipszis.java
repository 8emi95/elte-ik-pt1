/*
 * Feladatmegold�sok/18. fejezet
 * Ellipszis.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.awt.print.*;
import java.awt.Graphics;

class Nyomtatando implements Printable {
  public int print(Graphics gr, PageFormat pf,
                      int pageIndex) throws PrinterException {
    if (pageIndex >= 1)
      return NO_SUCH_PAGE;
    /* A met�dus int param�tereket v�r. Felfel� kell kerek�teni,
     * k�l�nben nem f�r r� a k�pter�letre az ellipszis:
     */
    gr.drawOval((int)pf.getImageableX()+1,(int)pf.getImageableY()+1,
        (int)pf.getImageableWidth()-1,(int)pf.getImageableHeight()-1);
    return PAGE_EXISTS;
  }
}

public class Ellipszis {
  private PrinterJob nyomtato = PrinterJob.getPrinterJob();
  private Printable nyomtatando = new Nyomtatando();

  public Ellipszis() {
    nyomtato.setPrintable(nyomtatando);
    try {
      nyomtato.print();
    }
    catch (PrinterException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Ellipszis();
  }
}
