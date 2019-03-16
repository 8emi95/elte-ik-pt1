/*
 * Projekt: Tilitoli
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

public class HelpDialog extends JDialog implements ActionListener {
  private Container cp = getContentPane();
  private JButton btOk;
  private String txtHelp =
    "A Tili-toli játék használata \n\n" +
    "A Tili-toli egy logikai játék. \n" +
    "Az n*n-es rács pontjaiban számok találhatók 1-tõl számozva.\n" +
    "Kezdetben a számok össze vannak keverve, és az egyik helyen \n" +
    "lyuk van. A játék célja a számok növekvõ sorba rendezése úgy, \n" +
    "hogy a lyuk az utolsó helyre kerüljön.\n" +
    "Ha egy számra rákattintunk, akkor a szám beugrik a lyuk \n" +
    "helyére, feltéve, hogy a lyuk a szám szomszédja.\n";
  private JTextArea taInfo = new JTextArea(txtHelp);

  public HelpDialog(JFrame parent) {
    super(parent,"Tili-toli használata");
    cp.add(new JScrollPane(taInfo));
    taInfo.setBackground(SystemColor.info);
    taInfo.setFont(new Font("Dialog",Font.PLAIN,13));
    taInfo.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    taInfo.setEditable(false);

    JPanel pnControl = new JPanel();
    cp.add(pnControl,"South");
    pnControl.setBorder(BorderFactory.createRaisedBevelBorder());
    pnControl.add(btOk = new JButton("OK"));

    btOk.addActionListener(this);
    btOk.setMnemonic('K');

    pack();
  }

  public void show() {
    // Az elsõ megjelenéskor a szülõ ablakhoz igazítjuk:
    if (!isValid())
      setLocationRelativeTo(getParent());
    super.show();
  }

  public void actionPerformed(ActionEvent ev) {
    hide();
  }
}  // HelpDialog
