/*
 * Mintaprogramok/12. fejezet
 * Projekt: ValasztJatszik
 * AudioFilter.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    return "Hangf�jlok (*.aiff; *.au; *.wav; *.mid; *.midi)";
  }
}
