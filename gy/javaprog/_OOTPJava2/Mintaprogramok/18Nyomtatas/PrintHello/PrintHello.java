/*
 * Mintaprogramok/18. fejezet
 * PrintHello.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.print.*;                                  //1
import java.awt.Graphics;

class Hello implements Printable {                        //2
  public int print(Graphics gr, PageFormat pf,
          int pageIndex) throws PrinterException {        //3
    if (pageIndex >= 1)                                   //4
      return NO_SUCH_PAGE;
    gr.drawString("Hello",100,100);                       //5
    return PAGE_EXISTS;                                   //6
  }
}

public class PrintHello {
  private PrinterJob nyomtato = PrinterJob.getPrinterJob();//7
  private Printable nyomtatando = new Hello();            //8

  public PrintHello() {
    nyomtato.setPrintable(nyomtatando);                   //9
    try {
      nyomtato.print();                                   //10
    }
    catch (PrinterException e) {                          //11
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new PrintHello();
  }
}
