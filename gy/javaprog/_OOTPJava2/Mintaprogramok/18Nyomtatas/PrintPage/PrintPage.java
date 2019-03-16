/*
 * Mintaprogramok/18. fejezet
 * PrintPage.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.print.*;
import java.awt.*;

class Page implements Printable {
  // Pont átszámítása mm-re:                               //1
  private int mm(int point) {
    return (int)(25.4*point/72);
  }

  public int print(Graphics gr, PageFormat pf,
    int pageIndex) throws PrinterException {
    if (pageIndex >= 1)
      return NO_SUCH_PAGE;

    // Oldal adatai pontokban:                             //2
    int width = (int)pf.getWidth();
    int height = (int)pf.getHeight();
    int imX = (int)(pf.getImageableX()+1);
    int imY = (int)(pf.getImageableY()+1);
    int imWidth = (int)(pf.getImageableWidth()-1);
    int imHeight = (int)(pf.getImageableHeight()-1);

    // Képterület bekeretezése:                            //3
    gr.translate(imX,imY);
    gr.drawRect(0,0,imWidth,imHeight);

    // Oldal és margók adatai:
    gr.setFont(new Font("SansSerif",Font.BOLD,20));        //4
    FontMetrics fm = gr.getFontMetrics();                  //5

    String str = "Oldal: ("+mm(width)+","+mm(height)+")";  //6
    gr.drawString(str,(imWidth-fm.stringWidth(str))/2,200);

    str = "Képterület: ("+mm(imWidth)+","+mm(imHeight)+")";
    gr.drawString(str,(imWidth-fm.stringWidth(str))/2,250);

    str = "Margók: " + "Bal-"+mm(imX)+" Jobb-"+
      mm(width-imX-imWidth)+" Fent-"+mm(imY)+
      " Lent-"+mm(height-imY-imHeight);
    gr.drawString(str,(imWidth-fm.stringWidth(str))/2,300);

    return PAGE_EXISTS;
  }
}

public class PrintPage {
  private PrinterJob pj = PrinterJob.getPrinterJob();
  private PageFormat pf = pj.defaultPage();

  public PrintPage() {
    pf = pj.pageDialog(pf);                                //7
    pj.setPrintable(new Page(),pf);                        //8

    try {
      pj.print();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new PrintPage();
  }
}
