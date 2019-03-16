/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: db
 * Szemelyek.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Szem�lyeket t�rol� kont�ner. A Szem�ly objektumokat egy
 * v�letlen el�r�s� �llom�nyban t�rolja.
 * Karbantart egy kulcs vektort is.
 */

package db;
import java.io.*;
import java.util.*;

public class Szemelyek {
  private String fileName;
  private RandomAccessFile rafSzemelyek;
  public Vector keyEntries = new Vector();

  /* Az adott nev�, Szemely adatokat tartalmaz� file megnyit�sa; ha m�g nem l�tezik,
   * l�trehoz�sa. Kulcsvektor fel�p�t�se:
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

  // Egy �j szemely objektum �r�sa az �llom�nyba, a file v�g�re:
  public void addSzemely(Szemely szemely) throws IOException  {
    long filePointer = rafSzemelyek.length();
    writeSzemely(rafSzemelyek,szemely,filePointer);
    keyEntries.add(new KeyEntry(szemely.nev,filePointer));
    Collections.sort(keyEntries);
  }

  // Egy l�tez�, n�vsor szerint az index. szemely objektum adatainak lek�rdez�se:
  public Szemely getSzemely(int index) throws IndexOutOfBoundsException, IOException  {
    KeyEntry keyEntry = (KeyEntry)keyEntries.get(index);
    return readSzemely(rafSzemelyek,keyEntry.position);
  }

  // Egy l�tez�, n�vsor szerint az index. szemely objektum t�rl�se az �llom�nyb�l:
  public void removeSzemely(int index) throws IOException  {
    KeyEntry keyEntry = (KeyEntry)keyEntries.get(index);
    deleteSzemely(rafSzemelyek,keyEntry.position);
    keyEntries.remove(index);
  }

  // Egy l�tez�, n�vsor szerint az index. szemely objektum m�dos�t�sa:
  public void replaceSzemely(Szemely szemely, int index)
                                       throws IOException  {
    KeyEntry keyEntry = (KeyEntry)keyEntries.get(index);
    writeSzemely(rafSzemelyek,szemely,keyEntry.position);
    keyEntry.key = szemely.nev;
    Collections.sort(keyEntries);
  }

  // Kulcsvektor l�trehoz�sa:
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

  // A f�jl bez�r�sa. El�tte a f�jl s�r�t�se, vagyis a
  // logikailag t�r�lt objektumok elhagy�sa:
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

    // R�gi f�jl t�rl�se, �j f�jl �tnevez�se a r�gire:
    File regi = new File(fileName);
    regi.delete();
    File uj = new File("adatok/temp.dat");
    uj.renameTo(regi);
  }

  // A megadott file-poz�ci�n lev� objektum �rv�nyes k�dj�t false-ra �ll�tja:
  private void deleteSzemely(RandomAccessFile raf,
                        long filePointer) throws IOException {
    raf.seek(filePointer);
    raf.writeBoolean(false);
  }

  // Beolvassa az objekumot raf-b�l a megadott file-poz�ci�t�l kezdve.
  // Ha az objektum nem �rv�nyes, null-t ad vissza:
  private Szemely readSzemely(RandomAccessFile raf,
                        long filePointer) throws IOException {
    raf.seek(filePointer);
    return readSzemely(raf);
  }

  // Beolvassa az objekumot raf-b�l az aktu�lis file-poz�ci�t�l kezdve.
  // Ha az objektum nem �rv�nyes, null-t ad vissza:
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

  // szemely ki�r�sa raf-ba az aktu�lis poz�ci�t�l kezdve:
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

  // szemely ki�r�sa raf-ba a megadott poz�ci�t�l kezdve:
  private void writeSzemely(RandomAccessFile raf,
       Szemely szemely, long filePointer) throws IOException {
    raf.seek(filePointer);
    writeSzemely(raf,szemely);
  }
}
