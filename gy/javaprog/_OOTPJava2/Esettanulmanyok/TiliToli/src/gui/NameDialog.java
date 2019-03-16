/*
 * Projekt: Tilitoli
 *
 * Csomag: gui
 * NameDialog.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 *
 * Dialógus ablak a felhasználó nevének bekérésére.
 * Metódusa:
 * - String getName():
 *   Visszaadja a beütött nevet. A Mégse lenyomása esetén null-t ad vissza.
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
    super(parent," A gyõztes nevének bekérése",true);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    // Név panel (címke és szövegmezõ):
    JPanel pnNev = new JPanel();
    pnNev.add(new JLabel("Írja be a nevét:"));
    pnNev.add(tfString = new JTextField(20));

    // Felsõ panel (szöveg, kép és névpanel):
    JPanel pnFelso = new JPanel();
    pnFelso.setLayout(new BorderLayout());
    pnFelso.add(lbSzoveg = new JLabel("Bent van a legjobbak között!",JLabel.CENTER),BorderLayout.NORTH);
    lbSzoveg.setForeground(new Color(0,0,160));
    lbSzoveg.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    lbSzoveg.setFont(new Font("Dialog",Font.PLAIN,24));
    pnFelso.add(new JLabel(new ImageIcon(getClass().getResource("images/fox.gif")),JLabel.CENTER));
    pnFelso.add(pnNev,BorderLayout.SOUTH);
    cp.add(pnFelso);

    // Alsó panel a gombokkal:
    JPanel pnButtons = new JPanel();
    pnButtons.add(btOk = new JButton("OK"));
    btOk.setMnemonic('K');
    pnButtons.add(btCancel = new JButton("Mégse"));
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
