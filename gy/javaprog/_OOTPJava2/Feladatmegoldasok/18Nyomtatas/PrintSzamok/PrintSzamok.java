/*
 * Feladatmegold�sok/18. fejezet
 * PrintSzamok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.JPanel;
import java.awt.print.*;
import java.awt.*;

class Szamok implements Printable {
  public int print(Graphics gr, PageFormat pf, int pageIndex)
                                    throws PrinterException {
    if (pageIndex >= 3)
      return NO_SUCH_PAGE;

    // (imX,imY) a k�pter�let bal fels� sarka:
    int imX = (int)pf.getImageableX()+1;
    int imY = (int)pf.getImageableY()+1;
    // (imWidth,imHeight) a k�pter�let m�rete:
    int imWidth = (int)pf.getImageableWidth()-1;
    int imHeight = (int)pf.getImageableHeight()-1;

    gr.translate(imX,imY);

    // A k�pter�let n�gy sark�ban egy-egy kis t�m�r t�glalap:
    gr.fillRect(0,0,10,10);
    gr.fillRect(imWidth-10,0,10,10);
    gr.fillRect(0,imHeight-10,10,10);
    gr.fillRect(imWidth-10,imHeight-10,10,10);

    // Oldalsz�m a lap k�zep�n:
    String szoveg = String.valueOf(pageIndex+1);
    gr.setFont(new Font("Dialog",Font.PLAIN,200));
    gr.setColor(new Color(200,200,200));
    FontMetrics fm = gr.getFontMetrics();
    gr.drawString(szoveg,(imWidth-fm.stringWidth(szoveg))/2,
                                (imHeight+fm.getHeight())/2);

    return PAGE_EXISTS;
  }
}

public class PrintSzamok {
  private PrinterJob pj = PrinterJob.getPrinterJob();
  private Szamok szamok = new Szamok();

  public PrintSzamok() {
    pj.setPrintable(szamok);
    try {
      // A printer job adatai:
      System.out.println("A job adatai: ");
      System.out.println("Job neve: "+pj.getJobName());
      System.out.println("Felhaszn�l� neve: "+pj.getUserName());
      System.out.println("P�ld�nysz�m: "+pj.getCopies()+"\n");
      // Az aktu�lis lapform�tum adatai (sz�less�g �s magass�g marg�val �s an�lk�l):
      System.out.println("A lap adatai: ");
      System.out.println("Sz�less�g: "+(int)pj.defaultPage().getWidth());
      System.out.println("Magass�g: "+(int)pj.defaultPage().getHeight());
      System.out.println("�rhat� sz�less�g: "+(int)pj.defaultPage().getImageableWidth());
      System.out.println("�rhat� magass�g: "+(int)pj.defaultPage().getImageableHeight());
      System.out.println("�rhat� bal fels� X: "+(int)pj.defaultPage().getImageableX());
      System.out.println("�rhat� bal fels� Y: "+(int)pj.defaultPage().getImageableY());

      pj.print();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new PrintSzamok();
  }
}
