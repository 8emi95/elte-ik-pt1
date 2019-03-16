/*
 * Projekt: Tilitoli
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

public class AboutDialog extends JDialog implements ActionListener {
  private Container cp = getContentPane();
  private JPanel pnFelso = new JPanel();
  private JPanel pnSzovegek = new JPanel();
  private JLabel lbVastagSzoveg = new JLabel("Tili-toli játék",JLabel.CENTER);
  private JPanel pnKisSzovegek = new JPanel();
  private JPanel pnKep = new JPanel();
  private JPanel pnGomb = new JPanel();
  private JButton btOk = new JButton("OK");

  public AboutDialog(JFrame parent) {
    super(parent,"Névjegy Tili-toli",true);
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
    pnKisSzovegek.add(new JLabel("OOTP Java 2. kötet, esettanulmány",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("Készítette: Angster Erzsébet",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("Baga Edit ötlete nyomán",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("SZÁMALK, Gábor Dénes Fõiskola",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("Budapest, 2002",JLabel.CENTER));
    pnKisSzovegek.add(new JLabel("A kód szabadon használható",JLabel.CENTER));

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
