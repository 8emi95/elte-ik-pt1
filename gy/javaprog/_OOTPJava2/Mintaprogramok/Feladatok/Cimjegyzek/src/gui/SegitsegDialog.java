/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: gui
 * SegitsegDialog.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class SegitsegDialog extends JDialog implements ActionListener {
  private Container cp = getContentPane();
  private JButton btOk;

  public SegitsegDialog(JFrame parent) {
    super(parent,"Segítség",false);
    setLocation(parent.getX()+50,parent.getY()+50);
    JPanel pnSegitseg = new JPanel();
    pnSegitseg.setLayout(new BorderLayout());
    pnSegitseg.setBorder(BorderFactory.createRaisedBevelBorder());
    JTextArea taSegitseg = new JTextArea(getSegitsegString(),15,30);
    taSegitseg.setFont(new Font("Monospace",Font.PLAIN,14));
    taSegitseg.setBackground(SystemColor.info);
    taSegitseg.setCaretPosition(0);
    taSegitseg.setEditable(false);
    taSegitseg.setLineWrap(true);
    pnSegitseg.add(new JScrollPane(taSegitseg));
    cp.add(pnSegitseg);

    JPanel pnOk = new JPanel();
    btOk = new JButton("Ok");
    btOk.addActionListener(this);
    pnOk.add(btOk);
    cp.add(pnOk,"South");
    pack();
  }

  private String getSegitsegString() {
    FileReader reader = null;
    File f = new File("adatok/segitseg.txt");
    char[] puffer = new char[(int)f.length()];
    try {
      reader = new FileReader(f);
      reader.read(puffer);
      reader.close();
    }
    catch (IOException ex) {
    }
    return String.valueOf(puffer);
  }

  public void actionPerformed(ActionEvent e) {
    setVisible(false);
  }
}

