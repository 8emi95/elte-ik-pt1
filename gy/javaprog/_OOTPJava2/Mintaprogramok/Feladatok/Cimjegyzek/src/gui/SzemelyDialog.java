/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: gui
 * SzemelyDialog.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

package gui;
import db.Szemely;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Dial�gus a Szemely objektum �ssze�ll�t�s�ra:
public class SzemelyDialog extends JDialog implements ActionListener, KeyListener {
  private Container cp = getContentPane();
  private JTextField tfId, tfNev, tfIrszam, tfVaros, tfCim, tfTelefon;
  private JButton btOk, btMegse;
  private boolean ok;

  public SzemelyDialog(JFrame parent) {
    super(parent,"Szem�ly tulajdons�gai",true);
    setLocation(getParent().getX()+50,getParent().getY()+50);
    setResizable(false);
    cp.setLayout(new GridLayout(0,1));

    // N�v:
    JPanel pn = new JPanel();
    pn.add(new Label("N�v: "));
    pn.add(tfNev = new JTextField(Szemely.NEV_MERET+1));
    cp.add(pn);

    // Ir�ny�t�sz�m:
    pn = new JPanel();
    pn.add(new Label("Ir�ny�t�sz�m: "));
    pn.add(tfIrszam = new JTextField(Szemely.IRSZAM_MERET+1));
    cp.add(pn);

    // V�ros:
    pn = new JPanel();
    pn.add(new Label("V�ros: "));
    pn.add(tfVaros = new JTextField(Szemely.VAROS_MERET+1));
    cp.add(pn);

    // C�m:
    pn = new JPanel();
    pn.add(new Label("C�m: "));
    pn.add(tfCim = new JTextField(Szemely.CIM_MERET+1));
    cp.add(pn);

    // Telefon:
    pn = new JPanel();
    pn.add(new Label("Telefon: "));
    pn.add(tfTelefon = new JTextField(Szemely.TELEFON_MERET+1));
    cp.add(pn);

    // Ok: adatok elment�se; M�gse: adatok elvet�se
    JPanel pnButtons = new JPanel();
    pnButtons.add(btOk = new JButton("Ok"));
    pnButtons.add(btMegse = new JButton("M�gse"));
    cp.add(pnButtons);

    btOk.addActionListener(this);
    btMegse.addActionListener(this);
    tfNev.addKeyListener(this);
    tfIrszam.addKeyListener(this);
    tfVaros.addKeyListener(this);
    tfCim.addKeyListener(this);
    tfTelefon.addKeyListener(this);
    pack();
  }

  /* Megjelenik a dial�gus. Ha az OK lenyom�s�val csukj�k be, akkor
     a param�terben megadott szemely objektum a be�rt adatokat fogja tartalmazni.
   */
  public boolean showDialog(Szemely szemely) {
    setSzemely(szemely);
    ok = false;
    tfNev.requestFocus();
    show();
    if (ok)
      getSzemely(szemely);
    return ok;
  }

  // Az objektum adatainak sz�toszt�sa az ablak mez�ibe:
  private void setSzemely(Szemely szemely) {
    tfNev.setText(szemely.nev);
    tfIrszam.setText(szemely.irszam);
    tfVaros.setText(szemely.varos);
    tfCim.setText(szemely.cim);
    tfTelefon.setText(szemely.telefon);
  }

  // Az objektum adatainak �ssze�ll�t�sa az ablak mez�ib�l:
  private void getSzemely(Szemely szemely) {
    szemely.nev = tfNev.getText().trim();
    szemely.irszam = tfIrszam.getText().trim();
    szemely.varos = tfVaros.getText().trim();
    szemely.cim = tfCim.getText().trim();
    szemely.telefon = tfTelefon.getText().trim();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btOk) {
      ok = true;
      setVisible(false);
    }
    else if (e.getSource() == btMegse) {
      ok = false;
      setVisible(false);
    }
  }

  public void keyTyped(KeyEvent e) {
  }

  // ENTER-re �s ESC-re kil�p a dial�gusb�l:
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_ENTER) {
      ok = true;
      setVisible(false);
    }
    else if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
      ok = false;
      setVisible(false);
    }
  }

  public void keyReleased(KeyEvent e) {
  }
}
