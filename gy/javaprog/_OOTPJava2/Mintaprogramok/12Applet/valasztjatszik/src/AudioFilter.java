/*
 * Mintaprogramok/12. fejezet
 * Projekt: ValasztJatszik
 * AudioFilter.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.filechooser.FileFilter;
import java.io.*;

public class AudioFilter extends FileFilter {              //1

  public boolean accept(File f) {
    String fName = f.getName().toLowerCase();
    return f.isDirectory() ||
      fName.endsWith(".aiff") ||
      fName.endsWith(".au") ||
      fName.endsWith(".wav") ||
      fName.endsWith(".mid") ||
      fName.endsWith(".midi");
  }
  public String getDescription() {
    return "Hangfájlok (*.aiff; *.au; *.wav; *.mid; *.midi)";
  }
}
