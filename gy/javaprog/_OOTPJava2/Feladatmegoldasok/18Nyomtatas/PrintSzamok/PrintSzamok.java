/*
 * Feladatmegoldások/18. fejezet
 * PrintSzamok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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

    // (imX,imY) a képterület bal felsõ sarka:
    int imX = (int)pf.getImageableX()+1;
    int imY = (int)pf.getImageableY()+1;
    // (imWidth,imHeight) a képterület mérete:
    int imWidth = (int)pf.getImageableWidth()-1;
    int imHeight = (int)pf.getImageableHeight()-1;

    gr.translate(imX,imY);

    // A képterület négy sarkában egy-egy kis tömör téglalap:
    gr.fillRect(0,0,10,10);
    gr.fillRect(imWidth-10,0,10,10);
    gr.fillRect(0,imHeight-10,10,10);
    gr.fillRect(imWidth-10,imHeight-10,10,10);

    // Oldalszám a lap közepén:
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
      System.out.println("Felhasználó neve: "+pj.getUserName());
      System.out.println("Példányszám: "+pj.getCopies()+"\n");
      // Az aktuális lapformátum adatai (szélesség és magasság margóval és anélkül):
      System.out.println("A lap adatai: ");
      System.out.println("Szélesség: "+(int)pj.defaultPage().getWidth());
      System.out.println("Magasság: "+(int)pj.defaultPage().getHeight());
      System.out.println("Írható szélesség: "+(int)pj.defaultPage().getImageableWidth());
      System.out.println("Írható magasság: "+(int)pj.defaultPage().getImageableHeight());
      System.out.println("Írható bal felsõ X: "+(int)pj.defaultPage().getImageableX());
      System.out.println("Írható bal felsõ Y: "+(int)pj.defaultPage().getImageableY());

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
