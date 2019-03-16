/*
 * Feladatmegold�sok/13. fejezet
 * Projekt: KepNezegeto
 * KepNezegeto.java (f�oszt�ly)
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
  private ImagePanel pnImage;                              // k�peket tart� panel
  private DefaultListModel md = new DefaultListModel();
  private JList lstImageFiles = new JList(md);             // f�jlok list�ja
  private JLabel lbStatus;                                 // St�tusz sor (f�jln�v + hossz)
  private File imageDir = new File("c:/javaprog/images");  // k�pek k�nyvt�ra
  private File imageFile;                                  // aktu�lisan kiv�lasztott k�pf�jl

  // Men�hierarchia:
  private JMenuBar mb = new JMenuBar();
  private JMenu mFile;
  private JMenuItem miLoad;

  // F�jldial�gus:
  private JFileChooser fc = new JFileChooser(imageDir);

  public KepNezegeto() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(50,50,screenSize.width-100,screenSize.height-100);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Csak a filterben megadott bejegyz�sek jelennek meg a dial�gusban:
    fc.setFileFilter(new ImageFilter());

    /* K�nyvt�rat is ki lehet v�lasztani.
     * DIRECTORIES_ONLY eset�n a f�jlok nem is jelenn�nek meg, ez�rt
     * kiv�laszthat�k a f�jlok is, de nem t�rt�nik semmi.
     */
    fc.setFileSelectionMode(fc.FILES_AND_DIRECTORIES);

    // A men� fel�p�t�se:
    setJMenuBar(mb);
    mb.add(mFile = new JMenu("File"));
    mFile.add(miLoad = new JMenuItem("Load"));

    // Bal oldalon a f�jl lista, k�z�pen a kiv�lasztott k�p van:
    cp.add(new JScrollPane(lstImageFiles),"West");
    cp.add(pnImage = new ImagePanel(),"Center");
    cp.add(lbStatus = new JLabel(" "),"South");

    miLoad.addActionListener(this);
    lstImageFiles.addListSelectionListener(this);
    loadList();
    show();
  }

  //  A kiv�lasztott mappa bejegyz�sneveinek bet�lt�se a list�ba:
  void loadList() {
    md.clear();    // modell t�rl�se
    // Az imageDir k�nyvt�r f�jlneveinek hozz�ad�sa a modellhez,
    // felt�ve, hogy a f�jln�v nem k�nyvt�r:
    File[] imageFiles = imageDir.listFiles(new ImageNameFilter());
    for (int i=0; i<imageFiles.length; i++)
      if (imageFiles[i].isFile())
        md.addElement(imageFiles[i].getName());
    // Ha nem �res a lista, akkor kiv�lasztjuk az els� elemet:
    if (imageFiles.length>0)
      lstImageFiles.setSelectedIndex(0);
  }

  // Kiv�lasztottak egy k�pet:
  public void valueChanged(ListSelectionEvent e) {
    imageFile = new File(imageDir,(String)lstImageFiles.getSelectedValue());
    pnImage.load(imageFile);
    lbStatus.setText(imageFile.getAbsolutePath()+"     "+imageFile.length()+" byte");
  }

  // �j k�nyvt�rat v�lasztanak:
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
