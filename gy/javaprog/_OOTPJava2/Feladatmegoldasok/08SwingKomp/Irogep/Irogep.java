/*
 * Feladatmegoldások/8. fejezet
 * Irogep.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * A klaviatúrán vezérlõ billentyûk is vannak.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Irogep extends JFrame implements ActionListener {
  private Container cp = getContentPane();
  private JTextArea taPapir;
  private String[] sorok = {"1234567890-=","QWERTYUIOP[]","ASDFGHJKL;","ZXCVBNM,./"};
  boolean shift;

  // Egy sor gombjainak hozzáadása a keret figyelõláncához:
  private void felfuz(JPanel pnSor) {
    for (int i=0; i<pnSor.getComponentCount(); i++) {
      ((AbstractButton)pnSor.getComponent(i)).addActionListener(this);
    }
  }

  public Irogep() {
    setLocation(100,100);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    cp.setLayout(new GridLayout(2,1));

    taPapir = new JTextArea();
    taPapir.setLineWrap(true);
    cp.add(new JScrollPane(taPapir));

    JPanel pnBetuk = new JPanel();
    pnBetuk.setLayout(new GridLayout(0,1));

    // 0. sor (1234567890-= BS Del):
    JPanel pnSor = new JPanel();
    pnSor.setLayout(new FlowLayout(FlowLayout.CENTER,1,1));
    for (int n=0; n<sorok[0].length(); n++)
      pnSor.add(new JButton(""+sorok[0].charAt(n)));
    pnSor.add(new JButton("BS"));
    pnSor.add(new JButton("Del"));
    pnBetuk.add(pnSor);
    felfuz(pnSor);

    // 1. sor (Tab QWERTYUIOP[] Enter):
    pnSor = new JPanel();
    pnSor.setLayout(new FlowLayout(FlowLayout.CENTER,1,1));
    pnSor.add(new JButton("Tab"));
    for (int n=0; n<sorok[1].length(); n++)
      pnSor.add(new JButton(""+sorok[1].charAt(n)));
    pnBetuk.add(pnSor);
    felfuz(pnSor);

    // 2. sor ("ASDFGHJKL;"):
    pnSor = new JPanel();
    pnSor.setLayout(new FlowLayout(FlowLayout.CENTER,1,1));
    //pnSor.add(new JButton("Caps Lock"));
    for (int n=0; n<sorok[2].length(); n++)
      pnSor.add(new JButton(""+sorok[2].charAt(n)));
    pnSor.add(new JButton("Enter"));
    pnBetuk.add(pnSor);
    felfuz(pnSor);

    // 3. sor(ZXCVBNM,./ Shift):
    pnSor = new JPanel();
    pnSor.setLayout(new FlowLayout(FlowLayout.CENTER,1,1));
    for (int n=0; n<sorok[3].length(); n++)
      pnSor.add(new JButton(""+sorok[3].charAt(n)));
    pnSor.add(new JToggleButton("Shift"));
    pnBetuk.add(pnSor);
    felfuz(pnSor);

    // 4. sor (szóköz és kuzorvezérlõk):
    pnSor = new JPanel();
    JPanel pnSzokoz = new JPanel();
    JPanel pnVezerlok = new JPanel();
    JButton btSzokoz = new JButton("                                          ");
    btSzokoz.setActionCommand(" ");
    pnSor.add(pnSzokoz);
    pnSzokoz.add(btSzokoz);
    pnVezerlok.add(new JButton("<"));
    pnVezerlok.add(new JButton(">"));
    pnSor.add(pnVezerlok,BorderLayout.EAST);
    pnBetuk.add(pnSor);
    felfuz(pnSzokoz);
    felfuz(pnVezerlok);

    cp.add(pnBetuk,"South");

    pack();
    show();
    taPapir.requestFocus();
  }

  // A billentyûleütések lekezelése:
  public void actionPerformed(ActionEvent ev) {
    AbstractButton ab = (AbstractButton)ev.getSource();
    // Kurzor balra:
    if (ab.getActionCommand()=="<") {
      try {
        taPapir.setCaretPosition(taPapir.getCaretPosition()-1);
      }
      catch(Exception ex) {}
    }

    // Kurzor jobbra:
    else if (ab.getActionCommand()==">") {
      try {
        taPapir.setCaretPosition(taPapir.getCaretPosition()+1);
      }
      catch(Exception ex) {}
    }

    // Shift:
    else if (ab.getActionCommand()=="Shift") {
      shift = ((JToggleButton)ab).isSelected();
    }

    // Enter:
    else if (ab.getActionCommand()=="Enter")
      taPapir.insert("\r\n",taPapir.getCaretPosition());

    // Tab:
    else if (ab.getActionCommand()=="Tab")
      taPapir.insert("\t",taPapir.getCaretPosition());

    // Backspace:
    else if (ab.getActionCommand()=="BS") {
      try {
        int pos = taPapir.getCaretPosition();
        taPapir.replaceRange("",pos-1,pos);
      }
      catch(Exception ex) {}
    }

    // Delete:
    else if (ab.getActionCommand()=="Del") {
      try {
        int pos = taPapir.getCaretPosition();
        taPapir.replaceRange("",pos,pos+1);
      }
      catch(Exception ex) {}
    }

    // Szóköz:
    else if (ab.getActionCommand()==" ") {
      taPapir.insert(" ",taPapir.getCaretPosition());
    }

    // Begépelés:
    else {
      String betu = ab.getText();
      if (!shift)
        betu = betu.toLowerCase();
      taPapir.insert(betu,taPapir.getCaretPosition());
    }
    // A gomb elvette a fókuszt. Visszatesszük, hogy látható legyen a kurzor:
    taPapir.requestFocus();
  }

  // Main:
  public static void main(String[] args) {
    new Irogep();
  }
}
