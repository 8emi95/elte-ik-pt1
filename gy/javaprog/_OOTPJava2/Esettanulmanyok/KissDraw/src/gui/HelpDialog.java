/*
 * Projekt: KissDraw
 *
 * Csomag: gui
 * HelpDialog.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 *
 * A segítséget megjelenítõ dialógus ablak.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class HelpDialog extends JDialog {
  private Container cp = getContentPane();
  private JTextArea taInfo = new JTextArea();

  public HelpDialog(JFrame parent) {
    super(parent,"KissDraw használata");
    setSize(600,400);
    // Az elsõ megjelenéskor a szülõ ablakhoz igazítjuk:
    setLocationRelativeTo(getParent());

    cp.add(new JScrollPane(taInfo));
    taInfo.setBackground(SystemColor.info);
    taInfo.setFont(new Font("Dialog",Font.PLAIN,13));
    taInfo.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    taInfo.setEditable(false);
    taInfo.setLineWrap(true);

    /* A kisszövegeket a resources/help.properties fájl tartalmazza.
     * (Azért nem txt fájl, mert a JBuilder Personal a txt-t
     * nem ismeri fel, mint resource fájlt.)
     * A fájlból tetszõleges számú sort olvashatunk be.
     */
    try {
      InputStream in = HelpDialog.class.getResourceAsStream("help.properties");
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String szoveg;
      while((szoveg = br.readLine()) != null)
        taInfo.append(szoveg+"\n");
    }
    catch (IOException ex) {
      // Ez nem következhet be, ha a fájl bent van a jar-ban
      extra.hu.HuOptionPane.showMessageDialog(null,"Hiba! "+ex);
    }

    // Ha becsukják az ablakot, akkor csak elrejtjük:
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        hide();
      }
    });

  }

}  // HelpDialog
