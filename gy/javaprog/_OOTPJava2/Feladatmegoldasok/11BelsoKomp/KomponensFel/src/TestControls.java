/*
 * Feladatmegold�sok/11. fejezet
 * Projekt: KomponensFel
 * TestControls.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.controls.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

class TestPanel extends JPanel implements ActionListener {
  /* Hozz�adja a panelhez a comp komponenst.
   * El�bb r�teszi egy bels�, bekeretezett panelre.
   * A keret c�me a komponens oszt�lya.
   * A panel elrendez�smenedzsere k�v�lr�l megadhat�.
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

  // Ha nem adunk meg elrendez�smenedzsert, akkor az a FlowLayout:
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

  // Mez�k:
  private ColorChoice colorChoice;
  private JButton btStringFactory = new JButton("StringFactory");

  // Konstruktor:
  public TestPanel() {
    // A komponenseket egy k�toszlopos r�cson helyezz�k el:
    setLayout(new GridLayout(0,2));

    // A tesztelend� komponensek:
    create(new ControlledTextField(20));
    create(new BeepTextField(20));
    create(new ColoredButton("Sz�nes gomb",Color.red));
    create(new RedTextField(20));

    create(colorChoice = new ColorChoice());
    colorChoice.addActionListener(this);

    create(new MaskTextField("A12B","A99A"));

    add(btStringFactory); // lenyom�s�ra megjelenik a StringFactory
    btStringFactory.addActionListener(this);

    // A lufinak nincs elrendez�smenedzsere (null):
    create(new Lufi(100,40,Color.red),null);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==colorChoice) {
      Color color = colorChoice.getSelectedColor();
      colorChoice.getParent().setBackground(color);
    }
    else if (e.getSource()==btStringFactory) {
      Vector strings = StringFactory.showDialog(this,"Sz�vegek");
      System.out.println("A sz�veg: "+strings);
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
