/*
 * javalib könyvtár
 *
 * Csomag: extra.util
 * Files.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 *
 * Egy objektum fájlba való kiírása és fájlból való beolvasása úgy,
 * hogy az utasítás a fájl megnyitását és lezárását is elvégzi.
 */

package extra.util;
import java.io.*;

public class Files {

  /* ---------------------------------------------------------------------
   * A paraméterben megadott szerializálható objektum kiírása lemezre a path útvonallal
   * azonosított fájlba.
   */
  public static void writeObject(String path, Serializable object) throws IOException {
    ObjectOutputStream os = null;
    os = new ObjectOutputStream (new FileOutputStream(path));
    os.writeObject(object);
    os.close();
  }

  /* ---------------------------------------------------------------------
   * Objektum beolvasása lemezrõl a path útvonallal azonosított fájlból.
   * A visszatérési érték a beolvasott objektum, olvasási hiba esetén null.
   */
  public static Object readObject(String path) throws IOException, ClassNotFoundException {
    ObjectInputStream os = null;
    os = new ObjectInputStream (new FileInputStream(path));
    Object obj = os.readObject();
    os.close();
    return obj;
  }
}
