/*
 * Feladatmegold�sok/13. fejezet
 * DirSize.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Kisz�molja egy bejegyz�s m�ret�t, k�nyvt�r eset�n a teljes m�retet,
 * bele�rtve az alk�nyvt�rakat is.
 * A bejegyz�s nev�t a program param�terek�nt kell megadni.
 */

import java.io.*;

public class EntrySize {

  public static long entrySize(String dir) throws IOException {
    File fTop = new File(dir);
    if (!fTop.exists())
      throw new IOException("Nem l�tez� bejegyz�s!");
    if (fTop.isFile())
      return fTop.length();

    long size = 0;
    String[] fList = fTop.list();
    for (int i=0; i<fList.length; i++) {
      size += entrySize(dir+File.separator+fList[i]);
    }
    return size;
  }

  public static void main(String[] args) {
    if (args.length==0)
      System.out.println("Adja meg egy bejegyz�s �tvonal�t!");
    else {
      try {
        System.out.println(args[0]+" m�rete: "+entrySize(args[0])+" b�jt");
      }
      catch (IOException e) {
        System.out.println(e);
      }
    }
  }
} // EntrySize
