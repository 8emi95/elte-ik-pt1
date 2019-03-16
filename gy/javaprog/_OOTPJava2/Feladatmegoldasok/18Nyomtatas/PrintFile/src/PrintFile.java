/*
 * Feladatmegold�sok/18. fejezet
 * Projekt: PrintFile
 * PrintFile.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    // A sz�vegter�let ki�r�t�se:
    setText("");
    // Sz�vegter�let felt�lt�se a f�jl soraival:
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

  // �sszes sorv�gjel elt�vol�t�sa:
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
    // Sz�vegek hossz�nak �s magass�g�nak m�r�s�hez:
    gr.setFont(getFont());
    FontMetrics fm = gr.getFontMetrics();
    int sorkoz = fm.getHeight(); // a font magass�ga

    int imX = (int)(pf.getImageableX()+1);
    int imY = (int)(pf.getImageableY()+1);
    int imWidth = (int)(pf.getImageableWidth()-1);
    int imHeight = (int)(pf.getImageableHeight()-1);

    int maxLapSorszam = imHeight/sorkoz;
    int kezdSorszam = maxLapSorszam*pageIndex;  //pageIndex=0-t�l
    int lapokSzama = (getLineCount()+maxLapSorszam-1)/maxLapSorszam;

    // Ha nincs m�r ilyen sor, befejezz�k a myomtat�st:
    try {
      int poz = getLineStartOffset(kezdSorszam);
    }
    catch (BadLocationException ex) {
      return NO_SUCH_PAGE;
    }

    // Fejl�c:
    if (file != null) {
      // Tulajdons�gok be�ll�t�sa a fejl�chez:
      gr.setClip(imX,imY-20,imWidth,20);
      gr.setFont(new Font("Dialog",Font.BOLD,7));

      // Fejl�c elk�sz�t�se:
      gr.setColor(new Color(200,200,200));
      gr.fillRect(imX,imY-20,imWidth,20);
      gr.setColor(Color.black);
      gr.drawRect(imX,imY-20,imWidth,20);
      // Sz�vegek hossz�nak m�r�s�hez:
      fm = gr.getFontMetrics();
      // �tvonal ki�r�sa, rem�nykedve, hogy kif�r:
      String strUtvonal = "AE:Java2 - "+file.getAbsolutePath();
      gr.drawString(strUtvonal,imX+5,imY-7);
      // Oldalsz�m ki�r�sa:
      String strOldal = (pageIndex+1)+"/"+lapokSzama+". oldal";
      int jobbX = imX+imWidth-fm.stringWidth(strOldal)-5;
      gr.drawString(strOldal,jobbX,imY-7);
    }

    // Tulajdons�gok vissza�ll�t�sa a k�pter�lethez:
    gr.setClip(imX,imY,imWidth,imHeight);
    gr.setFont(new Font("Monospaced",Font.PLAIN,9));
    gr.setColor(Color.black);
    fm = gr.getFontMetrics();

    // K�pter�let bekeretez�se:
    gr.translate(imX,imY);
    gr.drawRect(0,0,imWidth,imHeight);

    // Lap elk�sz�t�se:
    String sor = "";
    int n = kezdSorszam;
    int i = 1; // a sor y koordin�t�j�hoz a lapon
    while (n<kezdSorszam+maxLapSorszam && n<getLineCount()) {
      try {
        // n. sor kihal�sz�sa a JTextArea-b�l (\n lej�n bel�le).
        // Ott 0-r�l indul a sz�moz�s:
        sor = getText(getLineStartOffset(n),
            getLineEndOffset(n)-getLineStartOffset(n));
        sor = vegNelkul(sor);
      }
      catch (BadLocationException ex) {
        System.out.println(ex);
        return NO_SUCH_PAGE;
      }
      // Ha nem f�r ki a sor, lev�gja:
      gr.drawString(Format.right(n+1,3)+" "+sor,0,i*sorkoz);
      n++;
      i++;
    }
    return PAGE_EXISTS;
  }

  // Kinyomtatja saj�t mag�t a nyomtat�ra:
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

    //Men�:
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
