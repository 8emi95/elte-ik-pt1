/*
 * Projekt: KissDraw
 *
 * Csomag: util
 * Savable.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 *
 * A FileManager használja. A FileManager csak Savable (elmenthetõ)
 * objektumokat tud kezelni.
 */

package extra.util;

import java.io.*;

public interface Savable {
  // true, ha az objektumot módosították a legutóbbi mentés óta:
  public boolean isModified();

  // Ezután az isModified értéke modified lesz.
  public void setModified(boolean modified);

  // Az objektum kiírása fájlba, illetve beolvasása fájlból:
  public void writeToFile(File file) throws Exception;
  public void readFromFile(File file) throws Exception;

  // Az objektum alapállapotba hozása, "kiürítése";
  // mintha egy új objektumot hoztunk volna létre.
  public void clear();
}
