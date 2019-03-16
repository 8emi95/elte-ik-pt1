/*
 * Feladatmegoldások/18. fejezet
 * PrintSorokFolyt.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import java.awt.print.*;
import java.awt.*;
import java.util.*;

class Page implements Printable {
  private Graphics gr;
  private PageFormat pf;
  private Vector lines = new Vector();
  private int lineHeight = 24;

  public Page() {
    fillVector();
  }

  // Vektor feltöltése:
  private void fillVector() {
    for (int i = 1; i <= 100; i++) {
      lines.add(i+". "+"sor");
    }
  }

  public int imX() {
    return (int) (pf.getImageableX()+1);
  }

  public int imY() {
    return (int) (pf.getImageableY()+1);
  }

  public int imWidth() {
    return (int) (pf.getImageableWidth()-1);
  }

  public int imHeight() {
    return (int) (pf.getImageableHeight()-1);
  }


  // Képterület bekeretezése:
  private void drawBorder() {
    // Képterület bekeretezése:
    gr.drawRect(imX(),imY(),imWidth(),imHeight());
  }

  // Az egy lapra ráférõ sorok száma (alul kihagyunk egy sort):
  private int linePerPage() {
    return imHeight()/lineHeight-1;
  }

  /* str kiírása az n. sorba, ha ráfér a lapra. Egy sor lineHeight pont magas.
     Ha nem fér rá, akkor a visszaadott érték false:
   */
  private boolean drawLine(String str, int n) {
    if (n*lineHeight > imHeight()-lineHeight)
      return false;
    /* A sor kirajzolása. Azért n+1, mert a sor alsó része a viszonyítási pont:
     */
    gr.drawString(str,imX()+4,imY()+(n+1)*lineHeight);
    return true;
  }

  public int print(Graphics gr, PageFormat pf,
    int pageIndex) throws PrinterException {
    /* Eltároljuk a grafikus objektumot és az oldalformát, mert egyes
       metódusoknak (pl. drawborder, drawline stb.) szüksége lesz rá:
     */
    this.gr = gr;
    this.pf = pf;

    /* Kiszámoljuk, hogy ez az oldal létezik-e. A lines vektor numberOfPages
     oldalra fér rá. Az ennél nagyobb indexû oldalakat visszautasítjuk.
     */
    int n = linePerPage();
    int numberOfPages = (lines.size()+n-1)/n;
    if (pageIndex >= numberOfPages)
      return NO_SUCH_PAGE;

    drawBorder(); // keretezés

    // Font beállítás:
    gr.setFont(new Font("Monospaced",Font.PLAIN,20));

    // Oldalszám kiírása a margón kívülre:
    gr.setClip(imX(),0,imWidth(),imY());
    gr.drawString(pageIndex+". lap",imX(),50);

    // Annyi sor írunk a pageIndex. lapra, amennyi kifér, illetve amennyi van a vektorban:
    gr.setClip(imX(),imY(),imWidth(),imHeight()); // Kivágási terület visszaállítása
    int firstLine = pageIndex*linePerPage();
    try {
      for (int i = 0; i < linePerPage(); i++) {
        drawLine( (String) lines.get(firstLine + i), i);
      }
    }
    catch (IndexOutOfBoundsException ex) {
    }

    return PAGE_EXISTS;
  }
}

public class PrintSorokFolyt {
  private PrinterJob pj = PrinterJob.getPrinterJob();

  public PrintSorokFolyt() {
    pj.setPrintable(new Page());
    if (!pj.printDialog())
      return;

    try {
      pj.print();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new PrintSorokFolyt();
  }
}
