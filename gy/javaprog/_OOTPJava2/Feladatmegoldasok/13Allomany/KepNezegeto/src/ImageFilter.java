/*
 * Feladatmegold�sok/13. fejezet
 * Projekt: KepNezegeto
 * FiletypeFilter.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Sz�r� a FileChooser haszn�lat�hoz.
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