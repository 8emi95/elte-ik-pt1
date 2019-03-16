/*
 * Projekt: KissDraw
 *
 * Csomag: util
 * FileManager.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 *
 * Objektumok bet�lt�s�t, elment�s�t menedzsel� oszt�ly.
 * Az elmentend� objektumnak implement�lnia kell a Savable interf�szt.
 */

package extra.util;

import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.Component;

public class FileManager {
  // Az elmentend� objektum:
  private Savable savable;

  // Lemezkapcsolat.
  private File file = null;

  // A dial�gusok sz�l�ablaka
  protected Component parent;

  // A noname f�jl kiterjeszt�s n�lk�li neve (l�sd setMessages):
  protected String textNoname;
  // A f�jldial�gusban megjelen� sz�veg (l�sd setMessages):
  protected String description;

  /* Dial�gus a f�jl kiv�laszt�s�hoz. Kezdetben az aktu�lis
   * k�nyvt�r j�n fel, azt�n mindig az el�z�leg otthagyott: */
  protected JFileChooser fc;

  // A lehets�ges kiterjeszt�sek. Ezeket k�n�lja fel majd a f�jldial�gus.
  private String[] extensions = {""};

  // Bels� oszt�ly a f�jldial�gus sz�r�s�hez:
  class Filter extends FileFilter {
    /* true, ha f neve az extensions t�mb valamelyik elem�vel
     * v�gz�dik, vagy k�nyvt�r:
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

  // Konstruktor. Param�terei a sz�l�ablak �s az elmentend� objektum:
  public FileManager(Component parent, Savable savable) {
    this.parent = parent;
    setSavable(savable);
    setMessages();
    // Alap�rtelmez�sban angol nyelv� f�jlv�laszt�:
    setFileChooser();
    fc.setFileFilter(new Filter());
  }

  // Fel�l�r�s�val meg lehet adni m�s nyelv� f�jlkiv�laszt�t:
  protected void setFileChooser() {
    fc = new JFileChooser(".");
  }

  public void setSavable(Savable savable) {
    this.savable = savable;
  }

  /*********************************************************
   * Angol �zenetek. M�s nyelv eset�n ezeket a met�dusokat
   * fel�l kell �rni:
   *********************************************************/
  protected void setMessages() {
    textNoname = "Noname";
    description = "All files";
  }

  /* Megk�rdezi, hogy fel�l�rja-e a m�r l�tez� �llom�nyt.
   * A lehets�ges visszat�r�si �rt�kek: YES_OPTION �s NO_OPTION.
   */
  protected int showExistsMessage() {
    return JOptionPane.showConfirmDialog(parent,getFileName() +
      " file exists. Overwrite?","Warning!",JOptionPane.YES_NO_OPTION,
      JOptionPane.WARNING_MESSAGE);
  }

  /* Megk�rdezi, hogy elmentse-e a m�dos�tott �llom�nyt.
   * A lehets�ges visszat�r�si �rt�kek: YES_OPTION, NO_OPTION �s CANCEL_OPTION.
   */
  protected int showModifiedMessage() {
    return JOptionPane.showConfirmDialog(parent,
      getFileName() + " file has been modified. Save?", "Warning!",
      JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
  }

  /* Ki�rja a "Hiba az �llom�ny �r�sa k�zben!" �zenetet.
   * Nincs visszat�r�si �rt�k, csak nyugt�zni kell.
   */
  protected void showWriteErrorMessage() {
    JOptionPane.showMessageDialog(parent, "Error writing file!", "Error",
      JOptionPane.ERROR_MESSAGE);
  }

  /* Ki�rja a "Hiba az �llom�ny olvas�sa k�zben!" �zenetet.
   * Nincs visszat�r�si �rt�k, csak nyugt�zni kell.
   */
  protected void showReadErrorMessage() {
    JOptionPane.showMessageDialog(parent, "Error reading file!", "Error",
      JOptionPane.ERROR_MESSAGE);
  }
  /*********************************************************/

  // Be�ll�tja a f�jldial�gus indul� mapp�j�t:
  public void setCurrentDirectory(String path) {
    fc.setCurrentDirectory(new File(path));
  }

  // Be�ll�tja a f�jldial�gus lehets�ges f�jlkiterjeszt�seit:
  public void setExtension(String[] ext) {
    extensions = ext;
    for (int i = 0; i < ext.length; i++) {
      extensions[i] = ext[i].toLowerCase();
    }
  }

  // Be�ll�tja a f�jldial�gus egyetlen lehets�ges f�jlkiterjeszt�s�t:
  public void setExtension(String ext) {
    extensions = new String[1];
    extensions[0] = ext.toLowerCase();
  }

  // Be�ll�tja a f�jldial�gusban megjelen� le�r�st:
  public void setDescription(String description) {
    this.description = description;
  }

  // Visszaadja a f�jl aktu�lis, teljes �tvonal�t:
  public String getFileName() {
    if (file == null)
      return textNoname;
    else
      return file.getAbsolutePath();
  }

  /* A filemanager befejezi m�k�d�s�t, alap�llapotba ker�l.
   * Az objektumot m�g elmenti, ha m�dos�tott�k �s ezt a felhaszn�l� ig�nyli:
   */
  public boolean exit() {
    boolean ok = attemptToSavePrevious();
    if (ok)
      savable.clear();
    return ok;
  }

  // �j f�jl l�trehoz�sa:
  public void newFile() {
    if (attemptToSavePrevious()) {
      savable.clear();
      savable.setModified(false);
      file = null;
    }
  }

  /* F�jl ment�se. Ha m�g nincs hozz�rendelve fizikai f�jl,
   * akkor megh�vjuk a "Ment�s m�sk�nt" funkci�t.
   */
  public boolean saveFile() {
    if (file == null) {
      // M�g nincs hozz�rendelve fizikai f�jl:
      return saveFileAs();
    }
    else {
      // Ment�s a fizikai f�jlba:
      writeToFile();
      return true;
    }
  }

  /* Ment�s m�sk�nt. Bek�r�nk egy f�jlnevet. Ha megadj�k,
   * akkor abba a f�jlba ment�nk. A visszaadott �rt�k true,
   * ha volt ment�s, false, ha nem.
   */
  public boolean saveFileAs() {
    // Bek�rj�k a f�jl nev�t, ahova menteni kell:
    int saveAsOption;
    boolean saveYes;
    do {
      saveYes = false;
      saveAsOption = fc.showSaveDialog(parent);
      if (saveAsOption == fc.APPROVE_OPTION) {
        // Megadtak egy f�jlt, ment�si k�s�rlet:
        file = fc.getSelectedFile();
        if (file.exists()) {
          /* Ha l�tezik m�r, megk�rdezz�k, fel�l�rja-e:
           * YES eset�n mentesVan true lesz, NO eset�n false:
           */
          saveYes = showExistsMessage() == JOptionPane.YES_OPTION;
        }
        else
          saveYes = true;
      }
      else
        // Elvetett�k (CANCEL_OPTION) vagy hiba (ERROR_OPTION):
        return false;
    }
    while (!saveYes);
    // Ha siker�lt ki�rni a lemezre, akkor true, egy�bk�nt false:
    return writeToFile();
  }

  /* F�jl bet�lt�se. El�tte felk�n�ljuk ment�sre az el�z� f�jlt,
   * ha azt m�dos�tott�k.
   * A visszat�r�si �rt�k true, ha siker�lt a bet�lt�s; minden m�s esetben false.
   */
  public boolean openFile() {
    if (attemptToSavePrevious()) {
      if (fc.showOpenDialog(parent) == fc.APPROVE_OPTION) {
        file = fc.getSelectedFile();  // megadtak egy f�jlt, bet�ltj�k
        return readFromFile(); // bet�lt�si hiba eset�n false
      }
    }
    return false;  // m�gsem akarj�k
  }

  /* Az el�z� f�jl ment�si k�s�rlete. Csak akkor t�rt�nik t�nyleges ment�s,
   * ha a f�jlt m�dos�tott�k �s a felhaszn�l� el akarja menteni.
   * A visszat�r�si �rt�k
   *  - true, ha a ment�s el van int�zve (ak�r van ment�s, ak�r nem);
   *  - false, ha a felhaszn�l� visszavonja eredeti akarat�t.
   */
  protected boolean attemptToSavePrevious() {
    if (!savable.isModified())
      return true; // a f�jl nem m�dosult az el�z� ment�s �ta

    /* Megk�rdezi, hogy elmentse-e a m�dos�tott �llom�nyt.
     * Lehets�ges visszat�r�si �rt�kek: YES_OPTION, NO_OPTION, CANCEL_OPTION
     */
    int option = showModifiedMessage();
    if (option == JOptionPane.CANCEL_OPTION)
      return false;        // visszavon�s, meggondolta mag�t

    if (option == JOptionPane.YES_OPTION) {
      if (file == null) {
        // Akar menteni, de a f�jl m�g n�vtelen:
        if (!saveFileAs()) {
          // M�gse akar menteni. Elvetett a ment�si dial�gust:
          return false;
        }
      }
      else
        // Akar menteni, �s van is neve a f�jlnak:
        writeToFile();
    }
    return true;
  }

  /* A savable objektum ki�r�si k�s�rlete.
   * Ha nem siker�l, megjelen�t egy hiba�zenetet.
   * A konkr�t ki�r�st a savable.writeToFile defini�lja.
   * A visszat�r�si �rt�k sikeres ki�r�s eset�n true, egy�bk�nt false.
   */
  protected boolean writeToFile() {
    // Ha nincs a f�jlnak kiterjeszt�se, akkor az alap�rtelmezett lesz:
    String name = file.getName().toLowerCase();
    if (name.indexOf(".") == -1)
      file = new File(file.getAbsolutePath() + "." + extensions[0]);
    try {
      savable.writeToFile(file);
    }
    catch (Exception ex) {
      // Nem siker�lt a ki�r�s:
      showWriteErrorMessage();
      return false;
    }
    // Siker�lt a ki�r�s:
    return true;
  }

  /* A savable objektum beolvas�si k�s�rlete.
   * Ha nem siker�l, megjelen�t egy hiba�zenetet.
   * A konkr�t beolvas�st a savable.readFromFile defini�lja.
   * A visszat�r�si �rt�k sikeres beolvas�s eset�n true, egy�bk�nt false.
   */
  protected boolean readFromFile() {
    try {
      savable.readFromFile(file);
    }
    catch (Exception ex) {
      // Nem siker�lt a beolvas�s:
      showReadErrorMessage();
      return false;
    }
    // Siker�lt a beolvas�s:
    savable.setModified(false);
    return true;
  }
}
