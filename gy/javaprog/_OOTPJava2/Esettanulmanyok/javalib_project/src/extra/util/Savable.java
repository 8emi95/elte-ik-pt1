/*
 * Projekt: KissDraw
 *
 * Csomag: util
 * Savable.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 *
 * A FileManager haszn�lja. A FileManager csak Savable (elmenthet�)
 * objektumokat tud kezelni.
 */

package extra.util;

import java.io.*;

public interface Savable {
  // true, ha az objektumot m�dos�tott�k a legut�bbi ment�s �ta:
  public boolean isModified();

  // Ezut�n az isModified �rt�ke modified lesz.
  public void setModified(boolean modified);

  // Az objektum ki�r�sa f�jlba, illetve beolvas�sa f�jlb�l:
  public void writeToFile(File file) throws Exception;
  public void readFromFile(File file) throws Exception;

  // Az objektum alap�llapotba hoz�sa, "ki�r�t�se";
  // mintha egy �j objektumot hoztunk volna l�tre.
  public void clear();
}
