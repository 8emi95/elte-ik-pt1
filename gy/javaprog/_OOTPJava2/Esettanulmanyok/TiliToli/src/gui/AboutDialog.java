/*
 * Projekt: Tilitoli
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

public class AboutDialog extends JDialog implements ActionListener {
  private Container cp = getContentPane();
  private JPanel pnFelso = new JPanel();
  private JPanel pnSzovegek = new JPanel();
  private JLabel lbVastagSzoveg = new JLabel("Tili-toli j�t�k",JLabel.CENTER);
  private JPanel pnKisSzovegek = new JPanel();
  private JPanel pnKep = new JPanel();
  private JPanel pnGomb = new JPanel();
  private JButton btOk = new JButton("OK");

  public AboutDialog(JFrame parent) {
    super(parent,"N�vjegy Tili-toli",true);
    cp.add(pnFelso);
    pnFelso.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
    pnFelso.add(pnSzovegek,"West");
    pnFelso.add(pnKep,"East");
    cp.add(pnGomb,"South");

    pnSzovegek.setLayout(new BorderLayout());
    lbVastagSzoveg.setFont(new Font("Dialog",Font.BOLD,30));
    lbVastagSzoveg.setForeground(new Color(0,0,160));
    pnSzovegek.add(lbVastagSzoveg,"North");
    pnSzovegek.add(pnKisSzovegek);
    pnKisSzovegek.setLayout(new GridLayout(0,1));
    pnKisSzovegek.add(new JLabel("OOTP Java 2. k�tet, esettanulm�ny",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("K�sz�tette: Angster Erzs�bet",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("Baga Edit �tlete nyom�n",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("SZ�MALK, G�bor D�nes F�iskola",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("Budapest, 2002",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("A k�d szabadon haszn�lhat�",JLabel.CENTER));

    pnKep.add(new JLabel(new ImageIcon(getClass().getResource("images/java2borito.jpg"))));

    pnGomb.setBorder(BorderFactory.createRaisedBevelBorder());
    pnGomb.add(btOk);
    btOk.setMnemonic('K');
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
