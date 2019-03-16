/*
 * Feladatmegoldások/13. fejezet
 * DirSize.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Kiszámolja egy bejegyzés méretét, könyvtár esetén a teljes méretet,
 * beleértve az alkönyvtárakat is.
 * A bejegyzés nevét a program paramétereként kell megadni.
 */

import java.io.*;

public class EntrySize {

  public static long entrySize(String dir) throws IOException {
    File fTop = new File(dir);
    if (!fTop.exists())
      throw new IOException("Nem létezõ bejegyzés!");
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
      System.out.println("Adja meg egy bejegyzés útvonalát!");
    else {
      try {
        System.out.println(args[0]+" mérete: "+entrySize(args[0])+" bájt");
      }
      catch (IOException e) {
        System.out.println(e);
      }
    }
  }
} // EntrySize
