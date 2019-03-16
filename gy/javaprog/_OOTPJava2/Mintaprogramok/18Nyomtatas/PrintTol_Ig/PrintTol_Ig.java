/*
 * Mintaprogramok/18. fejezet
 * PrintTol_Ig.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.print.*;
import java.awt.Graphics;

class EgyszeruDoksi implements Printable {
  public int print(Graphics gr, PageFormat pf, int pageIndex)
                                    throws PrinterException {
    if (pageIndex >= 10)                                //1
      return Printable.NO_SUCH_PAGE;
    gr.drawString((pageIndex+1)+". oldal",100,100);     //2
    gr.drawString("Pipacs",100,150);
    return Printable.PAGE_EXISTS;
  }
}

public class PrintTol_Ig {
  private PrinterJob nyomtato = PrinterJob.getPrinterJob();

  public PrintTol_Ig() {
    nyomtato.setPrintable(new EgyszeruDoksi());
    if (nyomtato.printDialog()) {                       //3
      try {
        nyomtato.print();
      }
      catch (PrinterException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    new PrintTol_Ig();
  }
}
