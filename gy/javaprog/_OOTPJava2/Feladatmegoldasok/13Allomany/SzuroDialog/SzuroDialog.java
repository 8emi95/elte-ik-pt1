/*
 * Feladatmegoldások/13. fejezet
 * SzuroDialog.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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
      System.out.println("Könyvtár: "+fc.getCurrentDirectory());
      System.out.println("Fájl: "+fc.getSelectedFile().getName());
    }
    System.exit(0); // másképp az fc még él...
  }
}
