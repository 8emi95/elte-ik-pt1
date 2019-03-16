/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: db
 * Szemelyek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Személyeket tároló konténer. A Személy objektumokat egy
 * véletlen elérésû állományban tárolja.
 * Karbantart egy kulcs vektort is.
 */

package db;
import java.io.*;
import java.util.*;

public class Szemelyek {
  private String fileName;
  private RandomAccessFile rafSzemelyek;
  public Vector keyEntries = new Vector();

  /* Az adott nevû, Szemely adatokat tartalmazó file megnyitása; ha még nem létezik,
   * létrehozása. Kulcsvektor felépítése:
  */
  public Szemelyek(String fileName) throws IOException {
    this.fileName = fileName;
    File f = new File(fileName);
    File dir = f.getParentFile();
    if (!dir.exists())
      dir.mkdir();

    rafSzemelyek = new RandomAccessFile(fileName,"rw");
    constructKeyEntries();
  }

  // Egy új szemely objektum írása az állományba, a file végére:
  public void addSzemely(Szemely szemely) throws IOException  {
    long filePointer = rafSzemelyek.length();
    writeSzemely(rafSzemelyek,szemely,filePointer);
    keyEntries.add(new KeyEntry(szemely.nev,filePointer));
    Collections.sort(keyEntries);
  }

  // Egy létezõ, névsor szerint az index. szemely objektum adatainak lekérdezése:
  public Szemely getSzemely(int index) throws IndexOutOfBoundsException, IOException  {
    KeyEntry keyEntry = (KeyEntry)keyEntries.get(index);
    return readSzemely(rafSzemelyek,keyEntry.position);
  }

  // Egy létezõ, névsor szerint az index. szemely objektum törlése az állományból:
  public void removeSzemely(int index) throws IOException  {
    KeyEntry keyEntry = (KeyEntry)keyEntries.get(index);
    deleteSzemely(rafSzemelyek,keyEntry.position);
    keyEntries.remove(index);
  }

  // Egy létezõ, névsor szerint az index. szemely objektum módosítása:
  public void replaceSzemely(Szemely szemely, int index)
                                       throws IOException  {
    KeyEntry keyEntry = (KeyEntry)keyEntries.get(index);
    writeSzemely(rafSzemelyek,szemely,keyEntry.position);
    keyEntry.key = szemely.nev;
    Collections.sort(keyEntries);
  }

  // Kulcsvektor létrehozása:
  private void constructKeyEntries() throws IOException {
    try {
      rafSzemelyek.seek(0);
      Szemely szemely;
      long filePointer;
      while (true) {
        filePointer = rafSzemelyek.getFilePointer();
        szemely = readSzemely(rafSzemelyek);
        if (szemely != null)
          keyEntries.add(new KeyEntry(szemely.nev,filePointer));
      }
    }
    catch (EOFException e) {
      Collections.sort(keyEntries);
    }
  }

  // A fájl bezárása. Elõtte a fájl sûrítése, vagyis a
  // logikailag törölt objektumok elhagyása:
  public void close() throws IOException {
    RandomAccessFile temp = null;
    Szemely szemely;
    long filePointer;
    temp = new RandomAccessFile("adatok/temp.dat","rw");
    temp.setLength(0);
    rafSzemelyek.seek(0);
    for (int i=0; i<keyEntries.size(); i++) {
      KeyEntry keyEntry = (KeyEntry)keyEntries.get(i);
      szemely = readSzemely(rafSzemelyek,keyEntry.position);
      writeSzemely(temp,szemely);
    }
    rafSzemelyek.close();
    temp.close();

    // Régi fájl törlése, új fájl átnevezése a régire:
    File regi = new File(fileName);
    regi.delete();
    File uj = new File("adatok/temp.dat");
    uj.renameTo(regi);
  }

  // A megadott file-pozíción levõ objektum érvényes kódját false-ra állítja:
  private void deleteSzemely(RandomAccessFile raf,
                        long filePointer) throws IOException {
    raf.seek(filePointer);
    raf.writeBoolean(false);
  }

  // Beolvassa az objekumot raf-ból a megadott file-pozíciótól kezdve.
  // Ha az objektum nem érvényes, null-t ad vissza:
  private Szemely readSzemely(RandomAccessFile raf,
                        long filePointer) throws IOException {
    raf.seek(filePointer);
    return readSzemely(raf);
  }

  // Beolvassa az objekumot raf-ból az aktuális file-pozíciótól kezdve.
  // Ha az objektum nem érvényes, null-t ad vissza:
  private Szemely readSzemely(RandomAccessFile raf)
                                          throws IOException {
    boolean valid = raf.readBoolean();
    String nev = FixedLengthIO.readString(raf,
                       Szemely.NEV_MERET).trim();
    String irszam = FixedLengthIO.readString(raf,
                       Szemely.IRSZAM_MERET).trim();
    String varos = FixedLengthIO.readString(raf,
                       Szemely.VAROS_MERET).trim();
    String cim = FixedLengthIO.readString(raf,
                       Szemely.CIM_MERET).trim();
    String telefon = FixedLengthIO.readString(raf,
                       Szemely.TELEFON_MERET).trim();
    if (valid)
      return new Szemely(nev,irszam,varos,cim,telefon);
    else
      return null;
  }

  // szemely kiírása raf-ba az aktuális pozíciótól kezdve:
  private void writeSzemely(RandomAccessFile raf,
                       Szemely szemely) throws IOException {
    raf.writeBoolean(true);
    FixedLengthIO.writeString(raf,
                       szemely.nev,Szemely.NEV_MERET);
    FixedLengthIO.writeString(raf,
                       szemely.irszam,Szemely.IRSZAM_MERET);
    FixedLengthIO.writeString(raf,
                       szemely.varos,Szemely.VAROS_MERET);
    FixedLengthIO.writeString(raf,
                       szemely.cim,Szemely.CIM_MERET);
    FixedLengthIO.writeString(raf,
                       szemely.telefon,Szemely.TELEFON_MERET);
  }

  // szemely kiírása raf-ba a megadott pozíciótól kezdve:
  private void writeSzemely(RandomAccessFile raf,
       Szemely szemely, long filePointer) throws IOException {
    raf.seek(filePointer);
    writeSzemely(raf,szemely);
  }
}
