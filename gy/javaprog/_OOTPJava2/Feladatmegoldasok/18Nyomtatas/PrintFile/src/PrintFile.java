/*
 * Feladatmegoldások/18. fejezet
 * Projekt: PrintFile
 * PrintFile.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.swing.*;
import javax.swing.text.*;
import java.io.*;
import extra.Format;

class FileArea extends JTextArea implements Printable {
  private File file = null;

  public FileArea() {
    setFont(new Font("Monospaced",Font.PLAIN,13));
    setLineWrap(true);
  }

  public void setFile(File file) {
    this.file = file;
    // A szövegterület kiürítése:
    setText("");
    // Szövegterület feltöltése a fájl soraival:
    BufferedReader br;
    int n=0;
    try {
      br = new BufferedReader(new FileReader(file));
      String sor;
      while ((sor = br.readLine()) != null) {
        n++;
        append(sor+"\n");
      }
      br.close();
      this.setCaretPosition(0);
    }
    catch (IOException e) {
      System.out.println("IO hiba! "+e);
    }
  }

  // Összes sorvégjel eltávolítása:
  private String vegNelkul(String sor) {
    StringBuffer sb = new StringBuffer(sor);
    int poz;
    while ((poz = sb.toString().indexOf('\r')) >= 0)
      sb.deleteCharAt(poz);
    while ((poz = sb.toString().indexOf('\n')) >= 0)
      sb.deleteCharAt(poz);

    return sb.toString();
  }

  public int print(Graphics gr, PageFormat pf, int pageIndex) throws PrinterException {
    // Szövegek hosszának és magasságának méréséhez:
    gr.setFont(getFont());
    FontMetrics fm = gr.getFontMetrics();
    int sorkoz = fm.getHeight(); // a font magassága

    int imX = (int)(pf.getImageableX()+1);
    int imY = (int)(pf.getImageableY()+1);
    int imWidth = (int)(pf.getImageableWidth()-1);
    int imHeight = (int)(pf.getImageableHeight()-1);

    int maxLapSorszam = imHeight/sorkoz;
    int kezdSorszam = maxLapSorszam*pageIndex;  //pageIndex=0-tól
    int lapokSzama = (getLineCount()+maxLapSorszam-1)/maxLapSorszam;

    // Ha nincs már ilyen sor, befejezzük a myomtatást:
    try {
      int poz = getLineStartOffset(kezdSorszam);
    }
    catch (BadLocationException ex) {
      return NO_SUCH_PAGE;
    }

    // Fejléc:
    if (file != null) {
      // Tulajdonságok beállítása a fejléchez:
      gr.setClip(imX,imY-20,imWidth,20);
      gr.setFont(new Font("Dialog",Font.BOLD,7));

      // Fejléc elkészítése:
      gr.setColor(new Color(200,200,200));
      gr.fillRect(imX,imY-20,imWidth,20);
      gr.setColor(Color.black);
      gr.drawRect(imX,imY-20,imWidth,20);
      // Szövegek hosszának méréséhez:
      fm = gr.getFontMetrics();
      // Útvonal kiírása, reménykedve, hogy kifér:
      String strUtvonal = "AE:Java2 - "+file.getAbsolutePath();
      gr.drawString(strUtvonal,imX+5,imY-7);
      // Oldalszám kiírása:
      String strOldal = (pageIndex+1)+"/"+lapokSzama+". oldal";
      int jobbX = imX+imWidth-fm.stringWidth(strOldal)-5;
      gr.drawString(strOldal,jobbX,imY-7);
    }

    // Tulajdonságok visszaállítása a képterülethez:
    gr.setClip(imX,imY,imWidth,imHeight);
    gr.setFont(new Font("Monospaced",Font.PLAIN,9));
    gr.setColor(Color.black);
    fm = gr.getFontMetrics();

    // Képterület bekeretezése:
    gr.translate(imX,imY);
    gr.drawRect(0,0,imWidth,imHeight);

    // Lap elkészítése:
    String sor = "";
    int n = kezdSorszam;
    int i = 1; // a sor y koordinátájához a lapon
    while (n<kezdSorszam+maxLapSorszam && n<getLineCount()) {
      try {
        // n. sor kihalászása a JTextArea-ból (\n lejön belõle).
        // Ott 0-ról indul a számozás:
        sor = getText(getLineStartOffset(n),
            getLineEndOffset(n)-getLineStartOffset(n));
        sor = vegNelkul(sor);
      }
      catch (BadLocationException ex) {
        System.out.println(ex);
        return NO_SUCH_PAGE;
      }
      // Ha nem fér ki a sor, levágja:
      gr.drawString(Format.right(n+1,3)+" "+sor,0,i*sorkoz);
      n++;
      i++;
    }
    return PAGE_EXISTS;
  }

  // Kinyomtatja saját magát a nyomtatóra:
  public void print() {
    PrinterJob pj = PrinterJob.getPrinterJob();
    pj.setPrintable(this);
    if (pj.printDialog()) {
      try {
        pj.print();
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    } // if
  } // print
} // FileArea

class PrintFileFrame extends JFrame implements ActionListener {
  private Container cp = getContentPane();
  private JMenuBar mb = new JMenuBar();
  private JMenu mFile = new JMenu();
  private JMenuItem miFileOpen = new JMenuItem();
  private JMenuItem miFilePrint = new JMenuItem();
  private JMenuItem miFileExit = new JMenuItem();

  private FileArea fileArea = new FileArea();
  private JFileChooser chooser = new JFileChooser(".");

  public PrintFileFrame() {
    setBounds(100,100,600,400);
    setTitle("Noname");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.setLayout(new BorderLayout());

    //Menü:
    setJMenuBar(mb);
    mFile.setText("File");
    mb.add(mFile);

    miFileOpen.setText("Open");
    miFileOpen.addActionListener(this);
    mFile.add(miFileOpen);

    miFilePrint.setText("Print");
    miFilePrint.setEnabled(false);
    miFilePrint.addActionListener(this);
    mFile.add(miFilePrint);

    mFile.addSeparator();

    miFileExit.setText("Exit");
    miFileExit.addActionListener(this);
    mFile.add(miFileExit);

    cp.add(new JScrollPane(fileArea),"Center");

    chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
      public boolean accept(File f) {
        String fName = f.getName().toLowerCase();
        return fName.endsWith(".txt") || fName.endsWith(".java") ||
          f.isDirectory();
      }
      public String getDescription() {
        return "txt; java";
      }
    });

    show();
  }

  public void actionPerformed(ActionEvent evt) {
    if (evt.getSource()==miFileOpen) {
      if (chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
        File file = chooser.getSelectedFile();
        fileArea.setFile(file);
        setTitle(file.getAbsolutePath());
        miFilePrint.setEnabled(true);
      }
    }
    else if (evt.getSource()==miFilePrint)
      fileArea.print();
    else if (evt.getSource()==miFileExit)
      System.exit(0);
  }
}

public class PrintFile {
  public static void main(String[] args) {
    new PrintFileFrame();
  }
}
