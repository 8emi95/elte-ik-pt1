/*
 * Feladatmegoldások/17. fejezet
 * Projekt: LassitottIras
 * Writer.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;

public class Writer extends JTextArea implements Runnable {
  String szoveg;
  int tempo;
  Thread szal;

  public Writer(String szoveg, int tempo) {
    this.szoveg = szoveg;
    this.tempo = tempo;
    setLineWrap(true);
    setBorder(BorderFactory.createEtchedBorder());
    szal = new Thread(this);
    szal.start();
  }

  public void run() {
    while (true) {
      for (int i = 0; i < szoveg.length(); i++) {
        this.append(szoveg.substring(i,i+1));
        try {
          szal.sleep(tempo);
        }
        catch (InterruptedException ie) {
        }
      }
      this.append(" *** ");
    }
  }
}
