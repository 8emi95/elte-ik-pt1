/*
 * Feladatmegoldások/13. fejezet
 * Projekt: KepNezegeto
 * FiletypeFilter.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Szûrõ a File.list használatához.
 */

import java.io.*;

public class ImageNameFilter implements FilenameFilter {
  public boolean accept(File dir, String name) {
    return name.toUpperCase().endsWith(".GIF") ||
           name.toUpperCase().endsWith(".JPG") ;
  }
}