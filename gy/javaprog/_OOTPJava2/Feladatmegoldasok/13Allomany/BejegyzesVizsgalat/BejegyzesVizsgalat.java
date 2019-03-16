/*
 * Feladatmegoldások/13. fejezet
 * FajlVizsgalat.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.util.Date;
import java.text.DateFormat;

public class BejegyzesVizsgalat extends JFrame implements ActionListener {
  private Container cp = getContentPane();
  private JTextArea taFileInfo = new JTextArea();

  // Menühierarchia:
  private JMenuBar mb = new JMenuBar();
  private JMenu mFile;
  private JMenuItem miLoad, miClear;

  // Fájldialógus:
  private JFileChooser fc = new JFileChooser("");

  public BejegyzesVizsgalat() {
    setBounds(50,50,600,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // Könyvtárakat is ki lehet választani:
    fc.setFileSelectionMode(fc.FILES_AND_DIRECTORIES);

    // A menü felépítése:
    setJMenuBar(mb);
    mb.add(mFile = new JMenu("File"));
    mFile.add(miLoad = new JMenuItem("Load"));
    mFile.add(miClear = new JMenuItem("Clear"));

    cp.add(new JScrollPane(taFileInfo));
    taFileInfo.setEditable(false);

    miLoad.addActionListener(this);
    miClear.addActionListener(this);
    show();
  }

  //  A kiválasztott bejegyzés adatainak megjelenítése a szövegterületen:
  void loadInfo(File f) {
    taFileInfo.append("Abszolút útvonal: "+f.getAbsolutePath()+"\n");
    taFileInfo.append("Szülõ könyvtár: "+f.getParent()+"\n");
    taFileInfo.append("Bejegyzés neve: "+f.getName()+"\n");
    taFileInfo.append(f.isDirectory()? "Könyvtár\n":"Fájl\n");
    taFileInfo.append("Hossza: "+f.length()+" bájt\n");
    DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
    String datum = df.format(new Date(f.lastModified()));
    taFileInfo.append("Utolsó módosítás dátuma: "+datum+"\n");
    taFileInfo.append(f.canWrite()? "Írható\n":"Nem írható\n");
    taFileInfo.append(f.isHidden()? "Rejtett\n":"Nem rejtett\n");
    taFileInfo.append("\n");
  }

  // Új bejegyzést választanak:
  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==miLoad) {
      if (fc.showOpenDialog(this)==fc.APPROVE_OPTION)
        loadInfo(fc.getSelectedFile());
    }
    else if (e.getSource()==miClear)
      taFileInfo.setText("");
  }

  public static void main (String args[]) {
    new BejegyzesVizsgalat();
  } // main

} // BejegyzesVizsgalat
