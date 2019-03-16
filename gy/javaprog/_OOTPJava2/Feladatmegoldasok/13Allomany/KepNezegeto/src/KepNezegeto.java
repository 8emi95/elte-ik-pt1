/*
 * Feladatmegoldások/13. fejezet
 * Projekt: KepNezegeto
 * KepNezegeto.java (fõosztály)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class KepNezegeto extends JFrame implements ListSelectionListener, ActionListener {
  private Container cp = getContentPane();
  private ImagePanel pnImage;                              // képeket tartó panel
  private DefaultListModel md = new DefaultListModel();
  private JList lstImageFiles = new JList(md);             // fájlok listája
  private JLabel lbStatus;                                 // Státusz sor (fájlnév + hossz)
  private File imageDir = new File("c:/javaprog/images");  // képek könyvtára
  private File imageFile;                                  // aktuálisan kiválasztott képfájl

  // Menühierarchia:
  private JMenuBar mb = new JMenuBar();
  private JMenu mFile;
  private JMenuItem miLoad;

  // Fájldialógus:
  private JFileChooser fc = new JFileChooser(imageDir);

  public KepNezegeto() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(50,50,screenSize.width-100,screenSize.height-100);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Csak a filterben megadott bejegyzések jelennek meg a dialógusban:
    fc.setFileFilter(new ImageFilter());

    /* Könyvtárat is ki lehet választani.
     * DIRECTORIES_ONLY esetén a fájlok nem is jelennének meg, ezért
     * kiválaszthatók a fájlok is, de nem történik semmi.
     */
    fc.setFileSelectionMode(fc.FILES_AND_DIRECTORIES);

    // A menü felépítése:
    setJMenuBar(mb);
    mb.add(mFile = new JMenu("File"));
    mFile.add(miLoad = new JMenuItem("Load"));

    // Bal oldalon a fájl lista, középen a kiválasztott kép van:
    cp.add(new JScrollPane(lstImageFiles),"West");
    cp.add(pnImage = new ImagePanel(),"Center");
    cp.add(lbStatus = new JLabel(" "),"South");

    miLoad.addActionListener(this);
    lstImageFiles.addListSelectionListener(this);
    loadList();
    show();
  }

  //  A kiválasztott mappa bejegyzésneveinek betöltése a listába:
  void loadList() {
    md.clear();    // modell törlése
    // Az imageDir könyvtár fájlneveinek hozzáadása a modellhez,
    // feltéve, hogy a fájlnév nem könyvtár:
    File[] imageFiles = imageDir.listFiles(new ImageNameFilter());
    for (int i=0; i<imageFiles.length; i++)
      if (imageFiles[i].isFile())
        md.addElement(imageFiles[i].getName());
    // Ha nem üres a lista, akkor kiválasztjuk az elsõ elemet:
    if (imageFiles.length>0)
      lstImageFiles.setSelectedIndex(0);
  }

  // Kiválasztottak egy képet:
  public void valueChanged(ListSelectionEvent e) {
    imageFile = new File(imageDir,(String)lstImageFiles.getSelectedValue());
    pnImage.load(imageFile);
    lbStatus.setText(imageFile.getAbsolutePath()+"     "+imageFile.length()+" byte");
  }

  // Új könyvtárat választanak:
  public void actionPerformed(ActionEvent e) {
    if (fc.showOpenDialog(this)==fc.APPROVE_OPTION) {
      imageDir = fc.getSelectedFile();
      if (imageDir.isDirectory()) {
        pnImage.clear();
        lbStatus.setText(" ");
        loadList();
      }
    }
  }

  public static void main (String args[]) {
    new KepNezegeto();
  } // main

} // KepNezegeto
