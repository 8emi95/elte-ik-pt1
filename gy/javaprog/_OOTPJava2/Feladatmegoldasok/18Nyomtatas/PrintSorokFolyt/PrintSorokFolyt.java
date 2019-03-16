/*
 * Feladatmegold�sok/18. fejezet
 * PrintSorokFolyt.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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

  // Vektor felt�lt�se:
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


  // K�pter�let bekeretez�se:
  private void drawBorder() {
    // K�pter�let bekeretez�se:
    gr.drawRect(imX(),imY(),imWidth(),imHeight());
  }

  // Az egy lapra r�f�r� sorok sz�ma (alul kihagyunk egy sort):
  private int linePerPage() {
    return imHeight()/lineHeight-1;
  }

  /* str ki�r�sa az n. sorba, ha r�f�r a lapra. Egy sor lineHeight pont magas.
     Ha nem f�r r�, akkor a visszaadott �rt�k false:
   */
  private boolean drawLine(String str, int n) {
    if (n*lineHeight > imHeight()-lineHeight)
      return false;
    /* A sor kirajzol�sa. Az�rt n+1, mert a sor als� r�sze a viszony�t�si pont:
     */
    gr.drawString(str,imX()+4,imY()+(n+1)*lineHeight);
    return true;
  }

  public int print(Graphics gr, PageFormat pf,
    int pageIndex) throws PrinterException {
    /* Elt�roljuk a grafikus objektumot �s az oldalform�t, mert egyes
       met�dusoknak (pl. drawborder, drawline stb.) sz�ks�ge lesz r�:
     */
    this.gr = gr;
    this.pf = pf;

    /* Kisz�moljuk, hogy ez az oldal l�tezik-e. A lines vektor numberOfPages
     oldalra f�r r�. Az enn�l nagyobb index� oldalakat visszautas�tjuk.
     */
    int n = linePerPage();
    int numberOfPages = (lines.size()+n-1)/n;
    if (pageIndex >= numberOfPages)
      return NO_SUCH_PAGE;

    drawBorder(); // keretez�s

    // Font be�ll�t�s:
    gr.setFont(new Font("Monospaced",Font.PLAIN,20));

    // Oldalsz�m ki�r�sa a marg�n k�v�lre:
    gr.setClip(imX(),0,imWidth(),imY());
    gr.drawString(pageIndex+". lap",imX(),50);

    // Annyi sor �runk a pageIndex. lapra, amennyi kif�r, illetve amennyi van a vektorban:
    gr.setClip(imX(),imY(),imWidth(),imHeight()); // Kiv�g�si ter�let vissza�ll�t�sa
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
