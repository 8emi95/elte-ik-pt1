/*
 * Feladatmegold�sok/13. fejezet
 * FajlVizsgalat.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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

  // Men�hierarchia:
  private JMenuBar mb = new JMenuBar();
  private JMenu mFile;
  private JMenuItem miLoad, miClear;

  // F�jldial�gus:
  private JFileChooser fc = new JFileChooser("");

  public BejegyzesVizsgalat() {
    setBounds(50,50,600,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // K�nyvt�rakat is ki lehet v�lasztani:
    fc.setFileSelectionMode(fc.FILES_AND_DIRECTORIES);

    // A men� fel�p�t�se:
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

  //  A kiv�lasztott bejegyz�s adatainak megjelen�t�se a sz�vegter�leten:
  void loadInfo(File f) {
    taFileInfo.append("Abszol�t �tvonal: "+f.getAbsolutePath()+"\n");
    taFileInfo.append("Sz�l� k�nyvt�r: "+f.getParent()+"\n");
    taFileInfo.append("Bejegyz�s neve: "+f.getName()+"\n");
    taFileInfo.append(f.isDirectory()? "K�nyvt�r\n":"F�jl\n");
    taFileInfo.append("Hossza: "+f.length()+" b�jt\n");
    DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
    String datum = df.format(new Date(f.lastModified()));
    taFileInfo.append("Utols� m�dos�t�s d�tuma: "+datum+"\n");
    taFileInfo.append(f.canWrite()? "�rhat�\n":"Nem �rhat�\n");
    taFileInfo.append(f.isHidden()? "Rejtett\n":"Nem rejtett\n");
    taFileInfo.append("\n");
  }

  // �j bejegyz�st v�lasztanak:
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
