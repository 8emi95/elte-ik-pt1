/*
 * Mintaprogramok/11. fejezet
 * Projekt: Komponens
 * TestControls.java (fõosztály)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.controls.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TestPanel extends JPanel {
  /* Hozzáadja a panelhez a comp komponenst. Elõbb ráteszi egy belsõ panelre.
   * Bekeretezi, a keret címe a komponens osztálya lesz:
   */
  void create(JComponent comp) {
    JPanel pnBelso = new JPanel();
    String className = comp.getClass().getName();
    className = className.substring(className.lastIndexOf(".")+1);
    comp.setBorder(BorderFactory.createTitledBorder(className));
    pnBelso.add(comp);
    add(pnBelso);
  }

  // Konstruktor:
  public TestPanel() {
    setLayout(new GridLayout(0,2));
    // A tesztelendõ komponensek
    create(new UpTextField(20));
    create(new NumberTextField(20));
    create(new FocusedTextField(15));
    create(new BlueTextField(20));
    create(new HighlightLabel("Szuper címke",Color.black,Color.white));
    add(new GridPanel(15,10));
  }
}

public class TestControls extends JFrame {
  public TestControls() {
    setLocation(200,0);
    getContentPane().add(new TestPanel());
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    pack();
    show();
  }
  public static void main (String args[]) {
    new TestControls();
  } // main
} // TestControls
