/*
 * Feladatmegoldások/18. fejezet
 * PrintDollarElado.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.JPanel;
import java.awt.print.*;
import java.awt.Graphics;
import java.awt.*;

class Lap implements Printable {
  public int print(Graphics gr, PageFormat pf, int pageIndex) throws PrinterException {
    // A képterület bal felsõ sarka lesz a (0,0) pont:
    int imX = (int)pf.getImageableX();
    int imY = (int)pf.getImageableY();
    gr.translate(imX,imY);

    // Szöveg a lap bal felsõ sarkában:
    gr.setFont(new Font("SansSerif",Font.BOLD,30));
    // A szöveg koordinátája annak bal alsó sarka (a betû 30 pontos):
    gr.drawString((pageIndex+1)+" dollár eladó!",0,30);

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
