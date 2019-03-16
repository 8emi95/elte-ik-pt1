/*
 * Feladatmegoldások/13. fejezet
 * Projekt: KepNezegeto
 * FiletypeFilter.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Szûrõ a FileChooser használatához.
 */

import javax.swing.filechooser.FileFilter;
import java.io.*;

class ImageFilter extends FileFilter {

  public boolean accept(File f) {
    return f.isDirectory() ||
           f.getName().toUpperCase().endsWith(".GIF") ||
           f.getName().toUpperCase().endsWith(".JPG") ;
  }

  public String getDescription() {
    return "GIF & JPG";
  }
}