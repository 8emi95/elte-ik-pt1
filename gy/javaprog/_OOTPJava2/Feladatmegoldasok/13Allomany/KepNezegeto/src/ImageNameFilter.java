/*
 * Feladatmegold�sok/13. fejezet
 * Projekt: KepNezegeto
 * FiletypeFilter.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Sz�r� a File.list haszn�lat�hoz.
 */

import java.io.*;

public class ImageNameFilter implements FilenameFilter {
  public boolean accept(File dir, String name) {
    return name.toUpperCase().endsWith(".GIF") ||
           name.toUpperCase().endsWith(".JPG") ;
  }
}