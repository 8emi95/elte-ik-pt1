/*
 * Projekt: KissEditor
 *
 * Csomag: kisseditor
 * EditArea.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2003.04.01.
 */

package kisseditor;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.print.*;
import java.util.Vector;

import extra.util.Savable;
import extra.Format;

public class EditArea extends JTextArea implements Savable, Printable {
  // true, ha a szöveget módosították:
  private boolean modified = false;
  // Innen töltötték be a szöveget:
  private File file = null;


  // Konstruktor:
  public EditArea() {
    setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
    setFont(new Font("Monospaced",Font.PLAIN,11));
    setLineWrap(true);

    // Figyeljük, hogy megváltozott-e a szöveg:
    getDocument().addDocumentListener(new DocumentListener() {
      public void insertUpdate(DocumentEvent e) {
        modified = true;
      }
      public void removeUpdate(DocumentEvent e) {
        modified = true;
      }
      public void changedUpdate(DocumentEvent e) {
      }
    });
  }

  public boolean isModified() {
    return modified;
  }

  public void setModified(boolean modified) {
    this.modified = modified;
  }

  // Visszaadja a kuzror pozícióját sor:oszlop (szöveges) formátumban:
  public String getCaretLineCol() {
    try {
      // Java hiba?? A getCaretPosition() nem jó, egyet késik!
      int pos = getCaretPosition();
      int line = getLineOfOffset(pos);
      int col = pos - getLineStartOffset(line);
      return (line+1)+":"+(col+1);
    }
    catch (Exception ex) { // BadLocationException
      ex.printStackTrace();
      return "";
    }
  }

  // Kiírás a fájlba:
  public void writeToFile(File file) throws IOException {
    this.file = file;

    BufferedOutputStream out = new BufferedOutputStream(
        new FileOutputStream(file));
    byte[] buffer = (getText()).getBytes();
    out.write(buffer);
    out.close();

    modified = false;
  }

  // Beolvasás a fájlból:
  public void readFromFile(File file) throws IOException {
    this.file = file;

    BufferedInputStream in = new BufferedInputStream(
        new FileInputStream(file));
    byte[] buffer = new byte[in.available()];
    in.read(buffer,0,buffer.length);
    setText(new String(buffer,0,buffer.length));
    in.close();

    setCaretPosition(0);
    modified = false;
  }

  // Az objektum alapállapotba hozása, "kiürítése":
  public void clear() {
    setText("");
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

  // Visszaad a String elejébõl annyit, amennyi elfér size szélességen:
  private String fitToSize(FontMetrics fm,String line,int size) {
    int i;
    for (i = 0; i < line.length(); i++) {
      if (fm.stringWidth(line.substring(0,i+1))>size)
        break;
    }
    return line.substring(0,i);
  }

  // Visszaad a String elejébõl annyit, amennyi elfér size szélességen:
  private String fitEndToSize(FontMetrics fm,String line,int size) {
    int i;
    for (i = line.length()-1; i >= 0; i--) {
      if (fm.stringWidth(line.substring(i))>size)
        break;
    }
    if (i>0)
      return line.substring(i);
    else
      return line;
  }

  public int print(Graphics gr, PageFormat pf, int pageIndex) throws PrinterException {
    final String TORESJEL = " ¢"; // ha a sor folytatása az elõzõnek

    // Szövegek hosszának és magasságának méréséhez:
    gr.setFont(getFont());
    FontMetrics fm = gr.getFontMetrics();
    int sorkoz = fm.getHeight();

    int imX = (int)(pf.getImageableX()+1);
    int imY = (int)(pf.getImageableY()+1);
    int imWidth = (int)(pf.getImageableWidth()-1);
    int imHeight = (int)(pf.getImageableHeight()-1);

    // A szövegterület sorainak átmásolása egy vektorba a sortörések miatt:
    Vector printSorok = new Vector();
    String sor = "";
    String printSor = "";
    int szamWidth = fm.stringWidth("99999");
    int sorWidth = imWidth - szamWidth - fm.stringWidth(TORESJEL);
    for (int n = 0; n < getLineCount(); n++) {
      try {
        // n. sor kihalászása a JTextArea-ból (\n lejön belõle).
        // Ott 0-ról indul a számozás:
        sor = getText(getLineStartOffset(n),
                      getLineEndOffset(n) - getLineStartOffset(n));
        sor = vegNelkul(sor);
        boolean elso = true;
        if (fm.stringWidth(sor) > sorWidth) {
          while (!sor.equals("")) {
            // A sor elejérõl leszedünk egy kinyomtatható részt:
            printSor = fitToSize(fm,sor,sorWidth);
            sor = sor.substring(printSor.length()); // ez maradt

            if (elso) {
              printSorok.add(printSor); // elsõ sor
              elso = false;
            }
            else
              printSorok.add(printSor+TORESJEL); // folytatás sor
          }
        }
        else
          printSorok.add(sor);
      }
      catch (BadLocationException ex) {
        ex.printStackTrace();
      }
    }

    // A kért lap nyomtatása:
    int maxLapSorszam = imHeight/sorkoz;
    int lapokSzama = (printSorok.size()+maxLapSorszam-1)/maxLapSorszam;
    int kezdSorszam = maxLapSorszam*pageIndex;  // pageIndex=0-tól

    // Nincs ilyen lap:
    if (pageIndex >= lapokSzama)
      return NO_SUCH_PAGE;

    // Fejléc. Tulajdonságok beállítása:
    gr.setClip(imX, imY - 20, imWidth, 20);
    gr.setFont(new Font("Dialog", Font.BOLD, 9));

    // Fejléc elkészítése:
    gr.setColor(new Color(200, 200, 200));
    gr.fillRect(imX, imY - 20, imWidth, 20);
    gr.setColor(Color.black);
    gr.drawRect(imX, imY - 20, imWidth, 20);

    // Oldalszám kiírása:
    fm = gr.getFontMetrics(); // a fejléc betûtípusa más
    String strOldal = (pageIndex + 1) + "/" + lapokSzama + ". oldal";
    int jobbX = imX + imWidth - fm.stringWidth(strOldal) - 5;
    gr.drawString(strOldal, jobbX, imY - 7);

    // Útvonal meghatározása. Ha nem fér ki, levágjuk az elejét:
    String strUtvonal;
    if (file != null)
      strUtvonal = file.getAbsolutePath();
    else
      strUtvonal = "Noname";

    String strFitUtvonal = fitEndToSize(fm, strUtvonal,
      jobbX - imX - fm.stringWidth("...") - 20);
    if (!strFitUtvonal.equals(strUtvonal))
      strFitUtvonal = "..."+strFitUtvonal;
    gr.drawString(strFitUtvonal, imX + 5, imY - 7);

    // Tulajdonságok visszaállítása a képterülethez:
    gr.setClip(imX,imY,imWidth,imHeight);
    gr.setFont(getFont());
    gr.setColor(Color.black);
    fm = gr.getFontMetrics();

    // Képterület bekeretezése:
    gr.translate(imX,imY);
    gr.drawRect(0,0,imWidth,imHeight);

    // Lap elkészítése:
    sor = "";
    int n = kezdSorszam; // a lap ezzel a sorszámmal kezdõdik
    int i = 1; // a lap relatív sorszáma (y koordinátájához kell)
    while (n<kezdSorszam+maxLapSorszam && n<printSorok.size()) {
      gr.drawString(Format.right(n+1,3)+"|",3,i*sorkoz);
      gr.drawString(""+printSorok.get(n),szamWidth,i*sorkoz);
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

}
