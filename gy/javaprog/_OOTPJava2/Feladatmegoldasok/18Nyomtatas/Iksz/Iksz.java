/*
 * Feladatmegoldások/18. fejezet
 * Iksz.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.print.*;
import java.awt.Graphics;

class Nyomtatando implements Printable {
  public int print(Graphics gr, PageFormat pf,
                      int pageIndex) throws PrinterException {
    if (pageIndex >= 1)
      return NO_SUCH_PAGE;
    int imX = (int)pf.getImageableX()+1;
    int imY = (int)pf.getImageableY()+1;
    int imWidth = (int)pf.getImageableWidth()-1;
    int imHeight = (int)pf.getImageableHeight()-1;
    gr.translate(imX,imY);
    gr.drawLine(0,0,imWidth,imHeight);
    gr.drawLine(imWidth,0,0,imHeight);
    gr.drawString("Ez egy iksz.",20,20);
    return PAGE_EXISTS;
  }
}

public class Iksz {
  private PrinterJob nyomtato = PrinterJob.getPrinterJob();
  private Printable nyomtatando = new Nyomtatando();

  public Iksz() {
    nyomtato.setPrintable(nyomtatando,
               nyomtato.pageDialog(nyomtato.defaultPage()));
    try {
      nyomtato.print();
    }
    catch (PrinterException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new Iksz();
  }
}

