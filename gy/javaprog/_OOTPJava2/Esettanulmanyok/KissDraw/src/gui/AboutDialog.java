/*
 * Projekt: KissDraw
 *
 * Csomag: gui
 * AboutDialog.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 *
 * A névjegyet megjelenítõ dialógus ablak.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AboutDialog extends JDialog implements ActionListener {
  private Container cp = getContentPane();
  private JPanel pnSzovegek = new JPanel();
  private JLabel lbProgramnev = new JLabel("Kiss Draw",JLabel.CENTER);
  private JPanel pnKisSzovegek = new JPanel();
  private JPanel pnKep = new JPanel();
  private JPanel pnControl = new JPanel();
  private JButton btOk = new JButton("Ok");

  public AboutDialog(JFrame parent) {
    super(parent,"Névjegy",true);
    cp.add(pnSzovegek,"North");
    cp.add(pnKep,"Center");
    cp.add(pnControl,"South");

    // Az ablak felsõ részén van a program neve és a "kisszövegek":
    pnSzovegek.setLayout(new BorderLayout());
    pnSzovegek.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    // A program neve:
    lbProgramnev.setFont(new Font("SansSerif",Font.PLAIN,30));
    lbProgramnev.setForeground(new Color(120,70,70));
    pnSzovegek.add(lbProgramnev,"North");

    /* A kisszövegeket a resources/about.properties fájl tartalmazza.
     * (Azért nem txt fájl, mert a JBuilder Personal a txt-t
     * nem ismeri fel, mint resource fájlt.)
     * A fájlból tetszõleges számú sort olvashatunk be.
     */
    pnSzovegek.add(pnKisSzovegek);
    pnKisSzovegek.setLayout(new GridLayout(0,1));
    try {
      InputStream in = AboutDialog.class.getResourceAsStream("about.properties");
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String szoveg;
      while((szoveg = br.readLine()) != null)
        pnKisSzovegek.add(new JLabel(szoveg,JLabel.CENTER));
    }
    catch (IOException ex) {
      // Ez nem következhet be, ha a fájl bent van a jar-ban
      extra.hu.HuOptionPane.showMessageDialog(null,"Hiba! "+ex);
    }

    pnKep.setBorder(BorderFactory.createEtchedBorder());

    pnKep.add(new JLabel(new ImageIcon(getClass().getResource("napoleonpenz.jpg"))));
    pnKep.setToolTipText("Forrás: http://www.napoleonicmedals.org");

    pnControl.setBorder(BorderFactory.createRaisedBevelBorder());
    pnControl.add(btOk);

    btOk.addActionListener(this);
    pack();
    setResizable(false);
  }

  public void show() {
    setLocationRelativeTo(getParent());
    super.show();
  }

  public void actionPerformed(ActionEvent ev) {
    hide();
  }
} // AboutDialog
