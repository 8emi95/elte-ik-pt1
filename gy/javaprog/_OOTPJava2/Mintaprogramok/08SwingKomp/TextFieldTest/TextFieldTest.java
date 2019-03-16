/*
 * Mintaprogramok/8. fejezet
 * TextFieldTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class NevPanel extends JPanel implements ActionListener { //1
  private JTextField tfVezetekNev, tfKeresztNev, tfTeljesNev;
  private JLabel lbMonogram;

  public NevPanel() {
    setLayout(new GridLayout(3,1));

    JPanel pn = new JPanel();                              //2
    pn.add(new JLabel("Vezetéknév:"));
    pn.add(tfVezetekNev = new JTextField(10));
    pn.add(new JLabel("Keresztnév:"));
    pn.add(tfKeresztNev = new JTextField(10));
    add(pn);

    pn = new JPanel();
    pn.add(new JLabel("Teljes név:"));
    pn.add(tfTeljesNev = new JTextField(20));
    tfTeljesNev.setEditable(false);
    add(pn);

    pn = new JPanel();
    pn.add(new JLabel("Monogram:"));
    pn.add(lbMonogram = new JLabel(""));
    add(pn);

    tfVezetekNev.addActionListener(this);                  //3
    tfKeresztNev.addActionListener(this);
  }

  public void actionPerformed(ActionEvent ev) {            //4
    String vez = tfVezetekNev.getText();
    String ker = tfKeresztNev.getText();
    tfTeljesNev.setText(vez+" "+ker);
    try {
      lbMonogram.setText(vez.charAt(0)+". "+ker.charAt(0)+".");
    }
    catch (StringIndexOutOfBoundsException ex) {
      lbMonogram.setText("");
    }
  }
}

public class TextFieldTest extends JFrame {
  public TextFieldTest() {
    setTitle("Név összerakása");
    setLocation(300,200);
    getContentPane().add(new NevPanel());
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent ev) {
        System.exit(0);
      }
    });
    pack();
    show();
  }
  public static void main (String[] args) {
    new TextFieldTest();
  } // main
} // TextFieldTest
