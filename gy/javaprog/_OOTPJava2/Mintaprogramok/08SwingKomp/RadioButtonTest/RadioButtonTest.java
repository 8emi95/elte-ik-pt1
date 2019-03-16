/*
 * Mintaprogramok/8. fejezet
 * RadioButtonTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class KeretezesFrame extends JFrame implements ActionListener {
  Container cp = getContentPane();
  ButtonGroup bg = new ButtonGroup();                       //1
  JRadioButton rbVesett = new JRadioButton("Vésett");       //2
  JRadioButton rbKiemelt = new JRadioButton("Kiemelt");
  JRadioButton rbSullyesztett = new JRadioButton("Süllyesztett");
  JPanel pnValaszt;

  public KeretezesFrame() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Keretezés próba");

    cp.setLayout(new FlowLayout()); //Így jobban látszik a keret
    pnValaszt = new JPanel();

    bg.add(rbVesett);                                       //3
    pnValaszt.add(rbVesett);
    rbVesett.addActionListener(this);

    bg.add(rbKiemelt);
    pnValaszt.add(rbKiemelt);
    rbKiemelt.addActionListener(this);

    bg.add(rbSullyesztett);
    pnValaszt.add(rbSullyesztett);
    rbSullyesztett.addActionListener(this);

    cp.add(pnValaszt);
    pack();
    show();
  }

  public void actionPerformed(ActionEvent ev) {             //4
    JRadioButton rb = (JRadioButton)ev.getSource();
    javax.swing.border.Border border = null;
    if (rb.getText().equals("Vésett"))
      border = BorderFactory.createEtchedBorder();
    else if (rb.getText().equals("Kiemelt"))
      border = BorderFactory.createRaisedBevelBorder();
    else if (rb.getText().equals("Süllyesztett"))
      border = BorderFactory.createLoweredBevelBorder();
    pnValaszt.setBorder(border);
  }
}

public class RadioButtonTest {
  public static void main (String args[]) {
    new KeretezesFrame();
  }
}

/*
  Ha írunk egy addButton metódust, úgy egyszerûbb feltenni a gombokat:
    addButton(rbVesett, pnValaszt, bg);
    addButton(rbKiemelt, pnValaszt, bg);
    addButton(rbSullyesztett, pnValaszt, bg);


  void addButton(AbstractButton button, JPanel pn, ButtonGroup bg) {
    bg.add(button);
    pn.add(button);
    button.addActionListener(this);
  }
*/
