/*
 * Projekt: Tilitoli
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

public class HelpDialog extends JDialog implements ActionListener {
  private Container cp = getContentPane();
  private JButton btOk;
  private String txtHelp =
    "A Tili-toli j�t�k haszn�lata \n\n" +
    "A Tili-toli egy logikai j�t�k. \n" +
    "Az n*n-es r�cs pontjaiban sz�mok tal�lhat�k 1-t�l sz�mozva.\n" +
    "Kezdetben a sz�mok �ssze vannak keverve, �s az egyik helyen \n" +
    "lyuk van. A j�t�k c�lja a sz�mok n�vekv� sorba rendez�se �gy, \n" +
    "hogy a lyuk az utols� helyre ker�lj�n.\n" +
    "Ha egy sz�mra r�kattintunk, akkor a sz�m beugrik a lyuk \n" +
    "hely�re, felt�ve, hogy a lyuk a sz�m szomsz�dja.\n";
  private JTextArea taInfo = new JTextArea(txtHelp);

  public HelpDialog(JFrame parent) {
    super(parent,"Tili-toli haszn�lata");
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
    // Az els� megjelen�skor a sz�l� ablakhoz igaz�tjuk:
    if (!isValid())
      setLocationRelativeTo(getParent());
    super.show();
  }

  public void actionPerformed(ActionEvent ev) {
    hide();
  }
}  // HelpDialog
