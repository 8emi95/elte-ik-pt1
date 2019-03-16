/*
 * Mintaprogramok/8. fejezet
 * RadioButtonTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class KeretezesFrame extends JFrame implements ActionListener {
  Container cp = getContentPane();
  ButtonGroup bg = new ButtonGroup();                       //1
  JRadioButton rbVesett = new JRadioButton("V�sett");       //2
  JRadioButton rbKiemelt = new JRadioButton("Kiemelt");
  JRadioButton rbSullyesztett = new JRadioButton("S�llyesztett");
  JPanel pnValaszt;

  public KeretezesFrame() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Keretez�s pr�ba");

    cp.setLayout(new FlowLayout()); //�gy jobban l�tszik a keret
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
    if (rb.getText().equals("V�sett"))
      border = BorderFactory.createEtchedBorder();
    else if (rb.getText().equals("Kiemelt"))
      border = BorderFactory.createRaisedBevelBorder();
    else if (rb.getText().equals("S�llyesztett"))
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
  Ha �runk egy addButton met�dust, �gy egyszer�bb feltenni a gombokat:
    addButton(rbVesett, pnValaszt, bg);
    addButton(rbKiemelt, pnValaszt, bg);
    addButton(rbSullyesztett, pnValaszt, bg);


  void addButton(AbstractButton button, JPanel pn, ButtonGroup bg) {
    bg.add(button);
    pn.add(button);
    button.addActionListener(this);
  }
*/
