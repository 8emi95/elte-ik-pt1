/*
 * Mintaprogramok/7. fejezet
 * NyomasSzamlalo.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NyomasSzamlalo extends JFrame
                            implements ActionListener {
  private JButton btBal, btJobb;
  private int nBal=0, nJobb=0;

  public NyomasSzamlalo() {
    Container cp = getContentPane();
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    cp.setLayout(new GridLayout(1,2));                //1
    cp.add(btBal = new JButton(""+nBal));             //2
    cp.add(btJobb = new JButton(""+nJobb));           //3
    btBal.addActionListener(this);                    //4
    btJobb.addActionListener(this);                   //5
    pack();
    show();
  }

  public void actionPerformed (ActionEvent ev) {
    if (ev.getSource()==btBal)                        //6
      btBal.setText(""+ ++nBal);                      //7
    else
      btJobb.setText(""+ ++nJobb);                    //8
  }

  public static void main (String args[]) {
    new NyomasSzamlalo();
  }
}
