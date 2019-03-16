/*
 * Feladatmegold�sok/18. fejezet
 * PrintDollarElado.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.JPanel;
import java.awt.print.*;
import java.awt.Graphics;
import java.awt.*;

class Lap implements Printable {
  public int print(Graphics gr, PageFormat pf, int pageIndex) throws PrinterException {
    // A k�pter�let bal fels� sarka lesz a (0,0) pont:
    int imX = (int)pf.getImageableX();
    int imY = (int)pf.getImageableY();
    gr.translate(imX,imY);

    // Sz�veg a lap bal fels� sark�ban:
    gr.setFont(new Font("SansSerif",Font.BOLD,30));
    // A sz�veg koordin�t�ja annak bal als� sarka (a bet� 30 pontos):
    gr.drawString((pageIndex+1)+" doll�r elad�!",0,30);

    return Printable.PAGE_EXISTS;
  }
}

public class PrintDollarElado {
  private PrinterJob pj = PrinterJob.getPrinterJob();
  private Lap lap = new Lap();

  public PrintDollarElado() {
    pj.setPrintable(lap);
    if (pj.printDialog()) {
      try {
        pj.print();
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    new PrintDollarElado();
  }
}
