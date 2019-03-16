/*
 * Mintaprogramok/8. fejezet
 * CheckBoxTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SzepCsunyaFrame extends JFrame implements ActionListener {
  Container cp = getContentPane();
  JLabel lbMondat;
  JCheckBox cbSzep, cbFiatal, cbNo;

  public SzepCsunyaFrame() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocation(100,100);
    setTitle("Szép, csúnya");
    cp.add(lbMondat =
          new JLabel(" ",JLabel.CENTER),"North");          //1

    JPanel pnValaszt = new JPanel();                       //2
    pnValaszt.add(cbSzep = new JCheckBox("szép",true));
    pnValaszt.add(cbFiatal = new JCheckBox("fiatal",true));
    pnValaszt.add(cbNo = new JCheckBox("nõ"));
    cbSzep.addActionListener(this);
    cbFiatal.addActionListener(this);
    cbNo.addActionListener(this);
    cp.add(pnValaszt,"South");
    pack();
    show();
    kiertekel();
  }

  void kiertekel() {                                       //3
    String szepe = cbSzep.isSelected()? "szép":"csúnya";
    String fiatale = cbFiatal.isSelected()? "fiatal":"öreg";
    String noe = cbNo.isSelected()? "nõ":"férfi";
    lbMondat.setText("Õ egy "+szepe+", "+fiatale+" "+noe);
  }

  public void actionPerformed(ActionEvent ev) {            //4
    kiertekel();
  }
}

public class CheckBoxTest {
  public static void main (String args[]) {
    new SzepCsunyaFrame();
  }
}
