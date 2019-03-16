/*
 * Projekt: KissDraw
 *
 * Csomag: gui
 * HelpDialog.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 *
 * A seg�ts�get megjelen�t� dial�gus ablak.
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
    super(parent,"KissDraw haszn�lata");
    setSize(600,400);
    // Az els� megjelen�skor a sz�l� ablakhoz igaz�tjuk:
    setLocationRelativeTo(getParent());

    cp.add(new JScrollPane(taInfo));
    taInfo.setBackground(SystemColor.info);
    taInfo.setFont(new Font("Dialog",Font.PLAIN,13));
    taInfo.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    taInfo.setEditable(false);
    taInfo.setLineWrap(true);

    /* A kissz�vegeket a resources/help.properties f�jl tartalmazza.
     * (Az�rt nem txt f�jl, mert a JBuilder Personal a txt-t
     * nem ismeri fel, mint resource f�jlt.)
     * A f�jlb�l tetsz�leges sz�m� sort olvashatunk be.
     */
    try {
      InputStream in = HelpDialog.class.getResourceAsStream("help.properties");
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String szoveg;
      while((szoveg = br.readLine()) != null)
        taInfo.append(szoveg+"\n");
    }
    catch (IOException ex) {
      // Ez nem k�vetkezhet be, ha a f�jl bent van a jar-ban
      extra.hu.HuOptionPane.showMessageDialog(null,"Hiba! "+ex);
    }

    // Ha becsukj�k az ablakot, akkor csak elrejtj�k:
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        hide();
      }
    });

  }

}  // HelpDialog
