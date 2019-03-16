/*
 * Mintaprogramok/18. fejezet
 * PrintShow.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.print.*;
import java.awt.*;
import java.awt.event.*;

class Vaszon extends JPanel implements Printable {
  private Image image;

  public Vaszon() {
    image = Toolkit.getDefaultToolkit().createImage(       //1
              "images/auto.jpg");
    MediaTracker tr = new MediaTracker(this);
    tr.addImage(image,0);
    try {
      tr.waitForID(0);
    }
    catch(InterruptedException e) {
    }
  }

  void drawVaszon(Graphics gr) {                           //2
    int imWidth = image.getWidth(this);    // a k�p sz�less�ge
    int imHeight = image.getHeight(this);  // a k�p magass�ga
    int w = gr.getClipBounds().width;
    int h = gr.getClipBounds().height;
    gr.drawImage(image,(w-imWidth)/2,(h-imHeight)/2,this);
  }

  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    drawVaszon(gr);                                        //3
  }

  public int print(Graphics gr, PageFormat pf, int pageIndex)
    throws PrinterException {
    if (pageIndex >= 1)
      return NO_SUCH_PAGE;
    gr.translate((int)pf.getImageableX(),
                 (int)pf.getImageableY());
    drawVaszon(gr);                                        //4
    return PAGE_EXISTS;
  }
}

class PrintShowFrame extends JFrame implements ActionListener {
  private Container cp;
  private Vaszon vaszon = new Vaszon();
  private JButton btNyomtat = new JButton("Nyomtat",
                  new ImageIcon("icons/print.gif"));
  private JButton btKilep = new JButton("Kil�p",
                  new ImageIcon("icons/exit.gif"));
  private PrinterJob pj = PrinterJob.getPrinterJob();

  public PrintShowFrame() {
    setTitle("K�p nyomtat�sa");
    setBounds(50,50,800,600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp = getContentPane();
    cp.setLayout(new BorderLayout());
    cp.add(vaszon,"Center");
    JPanel pnControl = new JPanel();
    pnControl.setBorder(new BevelBorder(BevelBorder.RAISED));
    cp.add(pnControl,"South");

    pnControl.add(btNyomtat);
    btNyomtat.addActionListener(this);

    pnControl.add(btKilep);
    btKilep.addActionListener(this);
  }

  public void actionPerformed(ActionEvent evt) {
    if (evt.getSource()==btNyomtat) {
      pj.setPrintable(vaszon);
      try {
        pj.print();
      }
      catch (Exception ex) {
        System.out.println(ex);
      }
    }
    else if (evt.getSource()==btKilep)
      System.exit(0);
  }
}

public class PrintShow {
  public static void main(String[] args) {
    new PrintShowFrame().show();
  }
}
