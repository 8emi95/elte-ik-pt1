/*
 * Projekt: KissDraw
 *
 * Csomag: util
 * FileManager.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 *
 * Objektumok betöltését, elmentését menedzselõ osztály.
 * Az elmentendõ objektumnak implementálnia kell a Savable interfészt.
 */

package extra.util;

import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.Component;

public class FileManager {
  // Az elmentendõ objektum:
  private Savable savable;

  // Lemezkapcsolat.
  private File file = null;

  // A dialógusok szülõablaka
  protected Component parent;

  // A noname fájl kiterjesztés nélküli neve (lásd setMessages):
  protected String textNoname;
  // A fájldialógusban megjelenõ szöveg (lásd setMessages):
  protected String description;

  /* Dialógus a fájl kiválasztásához. Kezdetben az aktuális
   * könyvtár jön fel, aztán mindig az elõzõleg otthagyott: */
  protected JFileChooser fc;

  // A lehetséges kiterjesztések. Ezeket kínálja fel majd a fájldialógus.
  private String[] extensions = {""};

  // Belsõ osztály a fájldialógus szûréséhez:
  class Filter extends FileFilter {
    /* true, ha f neve az extensions tömb valamelyik elemével
     * végzõdik, vagy könyvtár:
     */
    public boolean accept(File f) {
      String name = f.getName().toLowerCase();
      for (int i = 0; i < extensions.length; i++) {
        if (name.endsWith(extensions[i]))
          return true;
      }
      return f.isDirectory();
    }
    public String getDescription() {
      return description;
    }
  }

  // Konstruktor. Paraméterei a szülõablak és az elmentendõ objektum:
  public FileManager(Component parent, Savable savable) {
    this.parent = parent;
    setSavable(savable);
    setMessages();
    // Alapértelmezésban angol nyelvû fájlválasztó:
    setFileChooser();
    fc.setFileFilter(new Filter());
  }

  // Felülírásával meg lehet adni más nyelvû fájlkiválasztót:
  protected void setFileChooser() {
    fc = new JFileChooser(".");
  }

  public void setSavable(Savable savable) {
    this.savable = savable;
  }

  /*********************************************************
   * Angol üzenetek. Más nyelv esetén ezeket a metódusokat
   * felül kell írni:
   *********************************************************/
  protected void setMessages() {
    textNoname = "Noname";
    description = "All files";
  }

  /* Megkérdezi, hogy felülírja-e a már létezõ állományt.
   * A lehetséges visszatérési értékek: YES_OPTION és NO_OPTION.
   */
  protected int showExistsMessage() {
    return JOptionPane.showConfirmDialog(parent,getFileName() +
      " file exists. Overwrite?","Warning!",JOptionPane.YES_NO_OPTION,
      JOptionPane.WARNING_MESSAGE);
  }

  /* Megkérdezi, hogy elmentse-e a módosított állományt.
   * A lehetséges visszatérési értékek: YES_OPTION, NO_OPTION és CANCEL_OPTION.
   */
  protected int showModifiedMessage() {
    return JOptionPane.showConfirmDialog(parent,
      getFileName() + " file has been modified. Save?", "Warning!",
      JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
  }

  /* Kiírja a "Hiba az állomány írása közben!" üzenetet.
   * Nincs visszatérési érték, csak nyugtázni kell.
   */
  protected void showWriteErrorMessage() {
    JOptionPane.showMessageDialog(parent, "Error writing file!", "Error",
      JOptionPane.ERROR_MESSAGE);
  }

  /* Kiírja a "Hiba az állomány olvasása közben!" üzenetet.
   * Nincs visszatérési érték, csak nyugtázni kell.
   */
  protected void showReadErrorMessage() {
    JOptionPane.showMessageDialog(parent, "Error reading file!", "Error",
      JOptionPane.ERROR_MESSAGE);
  }
  /*********************************************************/

  // Beállítja a fájldialógus induló mappáját:
  public void setCurrentDirectory(String path) {
    fc.setCurrentDirectory(new File(path));
  }

  // Beállítja a fájldialógus lehetséges fájlkiterjesztéseit:
  public void setExtension(String[] ext) {
    extensions = ext;
    for (int i = 0; i < ext.length; i++) {
      extensions[i] = ext[i].toLowerCase();
    }
  }

  // Beállítja a fájldialógus egyetlen lehetséges fájlkiterjesztését:
  public void setExtension(String ext) {
    extensions = new String[1];
    extensions[0] = ext.toLowerCase();
  }

  // Beállítja a fájldialógusban megjelenõ leírást:
  public void setDescription(String description) {
    this.description = description;
  }

  // Visszaadja a fájl aktuális, teljes útvonalát:
  public String getFileName() {
    if (file == null)
      return textNoname;
    else
      return file.getAbsolutePath();
  }

  /* A filemanager befejezi mûködését, alapállapotba kerül.
   * Az objektumot még elmenti, ha módosították és ezt a felhasználó igényli:
   */
  public boolean exit() {
    boolean ok = attemptToSavePrevious();
    if (ok)
      savable.clear();
    return ok;
  }

  // Új fájl létrehozása:
  public void newFile() {
    if (attemptToSavePrevious()) {
      savable.clear();
      savable.setModified(false);
      file = null;
    }
  }

  /* Fájl mentése. Ha még nincs hozzárendelve fizikai fájl,
   * akkor meghívjuk a "Mentés másként" funkciót.
   */
  public boolean saveFile() {
    if (file == null) {
      // Még nincs hozzárendelve fizikai fájl:
      return saveFileAs();
    }
    else {
      // Mentés a fizikai fájlba:
      writeToFile();
      return true;
    }
  }

  /* Mentés másként. Bekérünk egy fájlnevet. Ha megadják,
   * akkor abba a fájlba mentünk. A visszaadott érték true,
   * ha volt mentés, false, ha nem.
   */
  public boolean saveFileAs() {
    // Bekérjük a fájl nevét, ahova menteni kell:
    int saveAsOption;
    boolean saveYes;
    do {
      saveYes = false;
      saveAsOption = fc.showSaveDialog(parent);
      if (saveAsOption == fc.APPROVE_OPTION) {
        // Megadtak egy fájlt, mentési kísérlet:
        file = fc.getSelectedFile();
        if (file.exists()) {
          /* Ha létezik már, megkérdezzük, felülírja-e:
           * YES esetén mentesVan true lesz, NO esetén false:
           */
          saveYes = showExistsMessage() == JOptionPane.YES_OPTION;
        }
        else
          saveYes = true;
      }
      else
        // Elvetették (CANCEL_OPTION) vagy hiba (ERROR_OPTION):
        return false;
    }
    while (!saveYes);
    // Ha sikerült kiírni a lemezre, akkor true, egyébként false:
    return writeToFile();
  }

  /* Fájl betöltése. Elõtte felkínáljuk mentésre az elõzõ fájlt,
   * ha azt módosították.
   * A visszatérési érték true, ha sikerült a betöltés; minden más esetben false.
   */
  public boolean openFile() {
    if (attemptToSavePrevious()) {
      if (fc.showOpenDialog(parent) == fc.APPROVE_OPTION) {
        file = fc.getSelectedFile();  // megadtak egy fájlt, betöltjük
        return readFromFile(); // betöltési hiba esetén false
      }
    }
    return false;  // mégsem akarják
  }

  /* Az elõzõ fájl mentési kísérlete. Csak akkor történik tényleges mentés,
   * ha a fájlt módosították és a felhasználó el akarja menteni.
   * A visszatérési érték
   *  - true, ha a mentés el van intézve (akár van mentés, akár nem);
   *  - false, ha a felhasználó visszavonja eredeti akaratát.
   */
  protected boolean attemptToSavePrevious() {
    if (!savable.isModified())
      return true; // a fájl nem módosult az elõzõ mentés óta

    /* Megkérdezi, hogy elmentse-e a módosított állományt.
     * Lehetséges visszatérési értékek: YES_OPTION, NO_OPTION, CANCEL_OPTION
     */
    int option = showModifiedMessage();
    if (option == JOptionPane.CANCEL_OPTION)
      return false;        // visszavonás, meggondolta magát

    if (option == JOptionPane.YES_OPTION) {
      if (file == null) {
        // Akar menteni, de a fájl még névtelen:
        if (!saveFileAs()) {
          // Mégse akar menteni. Elvetett a mentési dialógust:
          return false;
        }
      }
      else
        // Akar menteni, és van is neve a fájlnak:
        writeToFile();
    }
    return true;
  }

  /* A savable objektum kiírási kísérlete.
   * Ha nem sikerül, megjelenít egy hibaüzenetet.
   * A konkrét kiírást a savable.writeToFile definiálja.
   * A visszatérési érték sikeres kiírás esetén true, egyébként false.
   */
  protected boolean writeToFile() {
    // Ha nincs a fájlnak kiterjesztése, akkor az alapértelmezett lesz:
    String name = file.getName().toLowerCase();
    if (name.indexOf(".") == -1)
      file = new File(file.getAbsolutePath() + "." + extensions[0]);
    try {
      savable.writeToFile(file);
    }
    catch (Exception ex) {
      // Nem sikerült a kiírás:
      showWriteErrorMessage();
      return false;
    }
    // Sikerült a kiírás:
    return true;
  }

  /* A savable objektum beolvasási kísérlete.
   * Ha nem sikerül, megjelenít egy hibaüzenetet.
   * A konkrét beolvasást a savable.readFromFile definiálja.
   * A visszatérési érték sikeres beolvasás esetén true, egyébként false.
   */
  protected boolean readFromFile() {
    try {
      savable.readFromFile(file);
    }
    catch (Exception ex) {
      // Nem sikerült a beolvasás:
      showReadErrorMessage();
      return false;
    }
    // Sikerült a beolvasás:
    savable.setModified(false);
    return true;
  }
}
