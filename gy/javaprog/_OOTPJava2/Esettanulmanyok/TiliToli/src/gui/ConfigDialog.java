/*
 * Projekt: Tilitoli
 *
 * Csomag: gui
 * ConfigDialog.java

 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 *
 * Dialógus ablak a konfigurációs (Config osztályú) objektum szerkesztésére:
 * a playMode és a maxNumberOfResults tömb értékeinek állítása.
 *
 * Metódusa:
 * - getConfig(Config config): Ha az Ok-t nyomták le, akkor a
 *   visszatérési értéke az új config, egyébként null.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import play.Config;
import extra.hu.HuOptionPane;

public class ConfigDialog extends JDialog implements ActionListener {
  private Container cp = getContentPane();
  private Config config;
  private boolean ok;

  private ButtonGroup bg;
  private JRadioButton cbSize1;
  private JRadioButton cbSize2;
  private JRadioButton cbSize3;
  private JTextField tfMax1;
  private JTextField tfMax2;
  private JTextField tfMax3;
  private JButton btOk;
  private JButton btCancel;

  public ConfigDialog(JFrame parent) {
    super(parent,"Konfiguráció beállítás",true);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    // A keret felsõ része az adatokkal:
    JPanel pnData = new JPanel();
    pnData.setLayout(new GridLayout(0,1));
    pnData.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    cp.add(pnData,"Center");

    // Játékmód panel:
    JPanel pnPlayMode = new JPanel();
    pnPlayMode.setLayout(new GridLayout(1,0));
    pnData.add(pnPlayMode);
    pnPlayMode.setBorder(BorderFactory.createTitledBorder("Játékmód:"));
    pnPlayMode.add(cbSize1 = new JRadioButton("3*3",false));
    pnPlayMode.add(cbSize2 = new JRadioButton("4*4",false));
    pnPlayMode.add(cbSize3 = new JRadioButton("5*5",false));
    bg = new ButtonGroup();
    bg.add(cbSize1);
    bg.add(cbSize2);
    bg.add(cbSize3);

    // Játékosok száma panel:
    JPanel pnNumberOfPlayers = new JPanel();
    pnNumberOfPlayers.setLayout(new GridLayout(1,0));
    pnData.add(pnNumberOfPlayers);
    pnNumberOfPlayers.setBorder(BorderFactory.createTitledBorder("Toplista hossza:"));

    JPanel pnHarmad = new JPanel();
    pnHarmad.add(new JLabel("3*3:"));
    pnHarmad.add(tfMax1 = new JTextField(3));
    pnNumberOfPlayers.add(pnHarmad);

    pnHarmad = new JPanel();
    pnHarmad.add(new JLabel("4*4:"));
    pnHarmad.add(tfMax2 = new JTextField(3));
    pnNumberOfPlayers.add(pnHarmad);

    pnHarmad = new JPanel();
    pnHarmad.add(new JLabel("5*5:"));
    pnHarmad.add(tfMax3 = new JTextField(3));
    pnNumberOfPlayers.add(pnHarmad);

    // Vezérlõ gombok:
    JPanel pnButtons = new JPanel();
    pnButtons.setBorder(BorderFactory.createRaisedBevelBorder());
    pnButtons.add(btOk = new JButton("OK"));
    btOk.setMnemonic('K');
    pnButtons.add(btCancel = new JButton("Mégse"));
    btCancel.setMnemonic('M');

    cp.add(pnButtons,"South");
    pack();

    btOk.addActionListener(this);
    btCancel.addActionListener(this);
  }

  /* Beállítja az ablak adatait a config objektum alapján,
   * majd a felhasználó beállításai alapján összeállít egy új
   * config objektumot.
   */
  public Config getConfig(Config oldConfig) {
    setLocationRelativeTo(getParent());
    ok = false;
    config = oldConfig;
    putData();
    show();
    if (ok)
      return config;
    else
      return null;
  }

  // A config objektum adatait szétosztja a dialógus mezõibe:
  private void putData() {
    if (config.playMode == 0)
      cbSize1.setSelected(true);
    else if (config.playMode == 1)
      cbSize2.setSelected(true);
    else
      cbSize3.setSelected(true);

    tfMax1.setText(""+config.maxNumberOfResults[0]);
    tfMax2.setText(""+config.maxNumberOfResults[1]);
    tfMax3.setText(""+config.maxNumberOfResults[2]);
  }

  // A dialógus mezõi alapján összeállítja a config objektumot:
  private void getData() {
    Config config = new Config();
    ok = false;
    try {
      if (cbSize1.isSelected()) {
        config.playMode = 0;
      }
      else if (cbSize2.isSelected()) {
        config.playMode = 1;
      }
      else if (cbSize3.isSelected()) {
        config.playMode = 2;
      }
      config.maxNumberOfResults[0] = Integer.parseInt(tfMax1.getText());
      config.maxNumberOfResults[1] = Integer.parseInt(tfMax2.getText());
      config.maxNumberOfResults[2] = Integer.parseInt(tfMax3.getText());
      // Jók az adatok, sikerült az összeállítás:
      ok = true;
      this.config = config;
    }
    catch (NumberFormatException e) {
      HuOptionPane.showMessageDialog(this, "Számot kell megadni!");
    }
  }

  /* Ha az Ok-t vagy a Mégse gombot lenyomják, eltûnik az ablak.
   * Ok esetén összállítja a config objektumot.
   */
  public void actionPerformed(ActionEvent ev) {
    if (ev.getSource()==btOk) {
      getData();
      if (ok)
        hide();
    }
    else if (ev.getSource()==btCancel)
      hide();
  }

} // ConfigDialog
