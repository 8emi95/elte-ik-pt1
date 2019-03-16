/*
 * Projekt: Tilitoli
 *
 * Csomag: gui
 * NameDialog.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 *
 * Dial�gus ablak a felhaszn�l� nev�nek bek�r�s�re.
 * Met�dusa:
 * - String getName():
 *   Visszaadja a be�t�tt nevet. A M�gse lenyom�sa eset�n null-t ad vissza.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NameDialog extends JDialog implements ActionListener, KeyListener {
  private Container cp = getContentPane();
  private JLabel lbSzoveg;
  private JTextField tfString;
  private JButton btOk, btCancel;
  private String str;

  public NameDialog(JFrame parent) {
    super(parent," A gy�ztes nev�nek bek�r�se",true);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    // N�v panel (c�mke �s sz�vegmez�):
    JPanel pnNev = new JPanel();
    pnNev.add(new JLabel("�rja be a nev�t:"));
    pnNev.add(tfString = new JTextField(20));

    // Fels� panel (sz�veg, k�p �s n�vpanel):
    JPanel pnFelso = new JPanel();
    pnFelso.setLayout(new BorderLayout());
    pnFelso.add(lbSzoveg = new JLabel("Bent van a legjobbak k�z�tt!",JLabel.CENTER),BorderLayout.NORTH);
    lbSzoveg.setForeground(new Color(0,0,160));
    lbSzoveg.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    lbSzoveg.setFont(new Font("Dialog",Font.PLAIN,24));
    pnFelso.add(new JLabel(new ImageIcon(getClass().getResource("images/fox.gif")),JLabel.CENTER));
    pnFelso.add(pnNev,BorderLayout.SOUTH);
    cp.add(pnFelso);

    // Als� panel a gombokkal:
    JPanel pnButtons = new JPanel();
    pnButtons.add(btOk = new JButton("OK"));
    btOk.setMnemonic('K');
    pnButtons.add(btCancel = new JButton("M�gse"));
    btOk.setMnemonic('M');

    pnButtons.setBorder(BorderFactory.createEtchedBorder());
    cp.add(pnButtons,BorderLayout.SOUTH);
    pack();

    btOk.addActionListener(this);
    btCancel.addActionListener(this);
    tfString.addActionListener(this);
  }

  public String getName() {
    setLocationRelativeTo(getParent());
    tfString.setText("");
    show();
    tfString.requestFocus();
    return str;
  }

  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource()==btOk || ev.getSource()==tfString) {
      str = tfString.getText();
      hide();
    }
    if (ev.getSource()==btCancel) {
      str = null;
      hide();
    }
  }

  public void keyTyped(KeyEvent ev) {
    if (ev.getKeyChar()==ev.VK_ESCAPE) {
      str = null;
      hide();
    }
  }

  public void keyPressed(KeyEvent ev) {
  }

  public void keyReleased(KeyEvent ev) {
  }

} // NameDialog
