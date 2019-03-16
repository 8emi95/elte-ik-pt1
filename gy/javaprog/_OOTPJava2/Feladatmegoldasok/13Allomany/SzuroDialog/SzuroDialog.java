/*
 * Feladatmegold�sok/13. fejezet
 * SzuroDialog.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;

class FiletypeFilter extends FileFilter {

  public boolean accept(File f) {
    return f.isDirectory() ||
      f.getName().toUpperCase().endsWith(".TXT") ||
      f.getName().toUpperCase().endsWith(".HTML");
  }

  public String getDescription() {
    return "txt & html";
  }
}

public class SzuroDialog {
  public static void main(String[] args) {
    JFileChooser fc = new JFileChooser(System.getProperty("java.home"));
    fc.setFileFilter(new FiletypeFilter());
    if (fc.showOpenDialog(null)==fc.APPROVE_OPTION) {
      System.out.println("K�nyvt�r: "+fc.getCurrentDirectory());
      System.out.println("F�jl: "+fc.getSelectedFile().getName());
    }
    System.exit(0); // m�sk�pp az fc m�g �l...
  }
}
