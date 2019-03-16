/*
 * Feladatmegoldások/18. fejezet
 * PrintTilosGUI.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.print.*;
import java.awt.*;
import java.awt.event.*;

// A "Megállni tilos!" jelzés egy piros vastag kör, benne két vastag ferde piros egyenes.
class Vaszon extends JPanel implements Printable {
  private int x, y;    // a lap középpontjának x és y koordinátái
  private int s=150;   // sugár
  private int v=10;    // vastagság
  private int fv=v/2;  // fele vastagság
  // A ferde egyenes végének x, y távolsága a középponttól:
  private int px=(int)(s*Math.cos(0.7));
  private int py=(int)(s*Math.sin(0.7));

  void drawCanvas(Graphics gr) {
    /* Mivel nem lehet megadni az egyenes vastagságát, ferde téglalapokat
     * fogunk kitölteni. ferde1 és ferde2 egy-egy ferde téglalap:
     */
    int[] x1Points = {x-px-fv,x-px+fv,x+px+fv,x+px-fv};
    int[] y1Points = {y-py+fv,y-py-fv,y+py-fv,y+py+fv};
    Polygon ferde1 = new Polygon(x1Points,y1Points,4);

    int[] x2Points = {x-px-fv,x-px+fv,x+px+fv,x+px-fv};
    int[] y2Points = {y+py-fv,y+py+fv,y-py+fv,y-py-fv};
    Polygon ferde2 = new Polygon(x2Points,y2Points,4);

    // Pirossal kitöltjük a teljes körlapot:
    gr.setColor(Color.red);
    gr.fillOval(x-s-v,y-s-v,2*(s+v),2*(s+v));

    // Ráteszünk egy fehér körlapot:
    gr.setColor(Color.white);
    gr.fillOval(x-s+v,y-s+v,2*(s-v),2*(s-v));

    // Meghúzzuk a két ferde egyenest pirossal:
    gr.setColor(Color.red);
    gr.fillPolygon(ferde1);
    gr.fillPolygon(ferde2);
  }

  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    // A középpont számítása:
    x = getWidth()/2;
    y = getHeight()/2;
    drawCanvas(gr);
  }

  public int print(Graphics gr, PageFormat pf, int pageIndex)
    throws PrinterException {
    if (pageIndex >= 1)
      return NO_SUCH_PAGE;

    // A középpont számítása:
    x = (int)pf.getWidth()/2;
    y = (int)pf.getHeight()/2;
    drawCanvas(gr);
    return PAGE_EXISTS;
  }

  // Kinyomtatja a vásznat (nyomtatóra):
  public void print() {
    PrinterJob pj = PrinterJob.getPrinterJob();
    pj.setPrintable(this);
    if (pj.printDialog())
      try {
        pj.print();
      }
      catch (Exception ex) {
        System.out.println(ex);
      }
  }
}

class PrintTilosFrame extends JFrame implements ActionListener {
  private Container contentPane;
  private Vaszon vaszon = new Vaszon();
  private JPanel pnControl = new JPanel();
  private JButton btNyomtat = new JButton("Nyomtat",
                new ImageIcon("icons/print.gif"));
  private JButton btKilep = new JButton("Kilép",
                new ImageIcon("icons/exit.gif"));

  public PrintTilosFrame() {
    setTitle("Megállni tilos");
    setBounds(50,50,600,600);
    contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());
    contentPane.add(vaszon,"Center");
    pnControl.setBorder(new BevelBorder(BevelBorder.RAISED));
    contentPane.add(pnControl,"South");

    pnControl.add(btNyomtat);
    btNyomtat.addActionListener(this);

    pnControl.add(btKilep);
    btKilep.addActionListener(this);
  }

  public void actionPerformed(ActionEvent evt) {
    if (evt.getSource()==btNyomtat)
      vaszon.print();
    else if (evt.getSource()==btKilep)
      System.exit(0);
  }
}

public class PrintTilosGUI {
  public static void main(String[] args) {
    new PrintTilosFrame().show();
  }
}
