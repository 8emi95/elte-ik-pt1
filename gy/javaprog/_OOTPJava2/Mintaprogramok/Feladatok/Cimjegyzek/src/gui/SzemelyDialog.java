/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: gui
 * SzemelyDialog.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

package gui;
import db.Szemely;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Dialógus a Szemely objektum összeállítására:
public class SzemelyDialog extends JDialog implements ActionListener, KeyListener {
  private Container cp = getContentPane();
  private JTextField tfId, tfNev, tfIrszam, tfVaros, tfCim, tfTelefon;
  private JButton btOk, btMegse;
  private boolean ok;

  public SzemelyDialog(JFrame parent) {
    super(parent,"Személy tulajdonságai",true);
    setLocation(getParent().getX()+50,getParent().getY()+50);
    setResizable(false);
    cp.setLayout(new GridLayout(0,1));

    // Név:
    JPanel pn = new JPanel();
    pn.add(new Label("Név: "));
    pn.add(tfNev = new JTextField(Szemely.NEV_MERET+1));
    cp.add(pn);

    // Irányítószám:
    pn = new JPanel();
    pn.add(new Label("Irányítószám: "));
    pn.add(tfIrszam = new JTextField(Szemely.IRSZAM_MERET+1));
    cp.add(pn);

    // Város:
    pn = new JPanel();
    pn.add(new Label("Város: "));
    pn.add(tfVaros = new JTextField(Szemely.VAROS_MERET+1));
    cp.add(pn);

    // Cím:
    pn = new JPanel();
    pn.add(new Label("Cím: "));
    pn.add(tfCim = new JTextField(Szemely.CIM_MERET+1));
    cp.add(pn);

    // Telefon:
    pn = new JPanel();
    pn.add(new Label("Telefon: "));
    pn.add(tfTelefon = new JTextField(Szemely.TELEFON_MERET+1));
    cp.add(pn);

    // Ok: adatok elmentése; Mégse: adatok elvetése
    JPanel pnButtons = new JPanel();
    pnButtons.add(btOk = new JButton("Ok"));
    pnButtons.add(btMegse = new JButton("Mégse"));
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

  /* Megjelenik a dialógus. Ha az OK lenyomásával csukják be, akkor
     a paraméterben megadott szemely objektum a beírt adatokat fogja tartalmazni.
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

  // Az objektum adatainak szétosztása az ablak mezõibe:
  private void setSzemely(Szemely szemely) {
    tfNev.setText(szemely.nev);
    tfIrszam.setText(szemely.irszam);
    tfVaros.setText(szemely.varos);
    tfCim.setText(szemely.cim);
    tfTelefon.setText(szemely.telefon);
  }

  // Az objektum adatainak összeállítása az ablak mezõibõl:
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

  // ENTER-re és ESC-re kilép a dialógusból:
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
