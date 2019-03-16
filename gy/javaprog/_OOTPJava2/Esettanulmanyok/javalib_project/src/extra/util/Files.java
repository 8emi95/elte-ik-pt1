/*
 * javalib k�nyvt�r
 *
 * Csomag: extra.util
 * Files.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 *
 * Egy objektum f�jlba val� ki�r�sa �s f�jlb�l val� beolvas�sa �gy,
 * hogy az utas�t�s a f�jl megnyit�s�t �s lez�r�s�t is elv�gzi.
 */

package extra.util;
import java.io.*;

public class Files {

  /* ---------------------------------------------------------------------
   * A param�terben megadott szerializ�lhat� objektum ki�r�sa lemezre a path �tvonallal
   * azonos�tott f�jlba.
   */
  public static void writeObject(String path, Serializable object) throws IOException {
    ObjectOutputStream os = null;
    os = new ObjectOutputStream (new FileOutputStream(path));
    os.writeObject(object);
    os.close();
  }

  /* ---------------------------------------------------------------------
   * Objektum beolvas�sa lemezr�l a path �tvonallal azonos�tott f�jlb�l.
   * A visszat�r�si �rt�k a beolvasott objektum, olvas�si hiba eset�n null.
   */
  public static Object readObject(String path) throws IOException, ClassNotFoundException {
    ObjectInputStream os = null;
    os = new ObjectInputStream (new FileInputStream(path));
    Object obj = os.readObject();
    os.close();
    return obj;
  }
}
