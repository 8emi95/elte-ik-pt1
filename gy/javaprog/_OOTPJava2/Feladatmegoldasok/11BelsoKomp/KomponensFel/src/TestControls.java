/*
 * Feladatmegoldások/11. fejezet
 * Projekt: KomponensFel
 * TestControls.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.controls.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

class TestPanel extends JPanel implements ActionListener {
  /* Hozzáadja a panelhez a comp komponenst.
   * Elõbb ráteszi egy belsõ, bekeretezett panelre.
   * A keret címe a komponens osztálya.
   * A panel elrendezésmenedzsere kívülrõl megadható.
   */
  void create(JComponent comp, LayoutManager lm) {
    JPanel pnBelso = new JPanel();
    pnBelso.setLayout(lm);
    String className = comp.getClass().getName();
    className = className.substring(className.lastIndexOf(".")+1);
    pnBelso.setBorder(BorderFactory.createTitledBorder(className));
    pnBelso.add(comp);
    add(pnBelso);
  }

  // Ha nem adunk meg elrendezésmenedzsert, akkor az a FlowLayout:
  void create(JComponent comp) {
    create(comp,new FlowLayout());
  }

  void createWithNoLayout(JComponent comp) {
    JPanel pnBelso = new JPanel();
    pnBelso.setLayout(null);
    String className = comp.getClass().getName();
    className = className.substring(className.lastIndexOf(".")+1);
    pnBelso.setBorder(BorderFactory.createTitledBorder(className));
    pnBelso.add(comp);
    add(pnBelso);
  }

  // Mezõk:
  private ColorChoice colorChoice;
  private JButton btStringFactory = new JButton("StringFactory");

  // Konstruktor:
  public TestPanel() {
    // A komponenseket egy kétoszlopos rácson helyezzük el:
    setLayout(new GridLayout(0,2));

    // A tesztelendõ komponensek:
    create(new ControlledTextField(20));
    create(new BeepTextField(20));
    create(new ColoredButton("Színes gomb",Color.red));
    create(new RedTextField(20));

    create(colorChoice = new ColorChoice());
    colorChoice.addActionListener(this);

    create(new MaskTextField("A12B","A99A"));

    add(btStringFactory); // lenyomására megjelenik a StringFactory
    btStringFactory.addActionListener(this);

    // A lufinak nincs elrendezésmenedzsere (null):
    create(new Lufi(100,40,Color.red),null);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==colorChoice) {
      Color color = colorChoice.getSelectedColor();
      colorChoice.getParent().setBackground(color);
    }
    else if (e.getSource()==btStringFactory) {
      Vector strings = StringFactory.showDialog(this,"Szövegek");
      System.out.println("A szöveg: "+strings);
    }
  }
}

public class TestControls extends JFrame {
  public TestControls() {
    setLocation(200,50);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(new TestPanel());
    pack();
    show();
  }

  public static void main (String args[]) {
    new TestControls();
  } // main

} // TestControls
