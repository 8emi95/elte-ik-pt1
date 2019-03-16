/*
 * Projekt: KissDraw
 *
 * Csomag: gui
 * AboutDialog.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 *
 * A n�vjegyet megjelen�t� dial�gus ablak.
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
    super(parent,"N�vjegy",true);
    cp.add(pnSzovegek,"North");
    cp.add(pnKep,"Center");
    cp.add(pnControl,"South");

    // Az ablak fels� r�sz�n van a program neve �s a "kissz�vegek":
    pnSzovegek.setLayout(new BorderLayout());
    pnSzovegek.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    // A program neve:
    lbProgramnev.setFont(new Font("SansSerif",Font.PLAIN,30));
    lbProgramnev.setForeground(new Color(120,70,70));
    pnSzovegek.add(lbProgramnev,"North");

    /* A kissz�vegeket a resources/about.properties f�jl tartalmazza.
     * (Az�rt nem txt f�jl, mert a JBuilder Personal a txt-t
     * nem ismeri fel, mint resource f�jlt.)
     * A f�jlb�l tetsz�leges sz�m� sort olvashatunk be.
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
      // Ez nem k�vetkezhet be, ha a f�jl bent van a jar-ban
      extra.hu.HuOptionPane.showMessageDialog(null,"Hiba! "+ex);
    }

    pnKep.setBorder(BorderFactory.createEtchedBorder());

    pnKep.add(new JLabel(new ImageIcon(getClass().getResource("napoleonpenz.jpg"))));
    pnKep.setToolTipText("Forr�s: http://www.napoleonicmedals.org");

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
