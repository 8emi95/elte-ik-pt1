/*
 * Mintaprogramok/8. fejezet
 * CheckBoxTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    setTitle("Sz�p, cs�nya");
    cp.add(lbMondat =
          new JLabel(" ",JLabel.CENTER),"North");          //1

    JPanel pnValaszt = new JPanel();                       //2
    pnValaszt.add(cbSzep = new JCheckBox("sz�p",true));
    pnValaszt.add(cbFiatal = new JCheckBox("fiatal",true));
    pnValaszt.add(cbNo = new JCheckBox("n�"));
    cbSzep.addActionListener(this);
    cbFiatal.addActionListener(this);
    cbNo.addActionListener(this);
    cp.add(pnValaszt,"South");
    pack();
    show();
    kiertekel();
  }

  void kiertekel() {                                       //3
    String szepe = cbSzep.isSelected()? "sz�p":"cs�nya";
    String fiatale = cbFiatal.isSelected()? "fiatal":"�reg";
    String noe = cbNo.isSelected()? "n�":"f�rfi";
    lbMondat.setText("� egy "+szepe+", "+fiatale+" "+noe);
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
