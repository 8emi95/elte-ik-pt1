/*
 * Mintaprogramok/10. fejezet
 * CheckDialogs.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CheckDialog extends JDialog implements
                        FocusListener, ActionListener {    //1
  private JTextField tfSzulhely;
  private JTextField tfSzulev;
  private JButton btOk, btMegse;
  private JLabel lbInfo;

  public CheckDialog(JFrame owner) {
    super(owner);
    Container cp = getContentPane();
    setTitle("Bevitel");
    setLocation(owner.getX()+50,owner.getY()+50);
    cp.setLayout(new GridLayout(0,1));

    JPanel pn;
    cp.add(pn = new JPanel());
    pn.add(new JLabel("Születési hely: "));
    pn.add(tfSzulhely = new JTextField("Pécs",10));

    cp.add(pn = new JPanel());
    pn.add(new JLabel("Szül. év: "));
    pn.add(tfSzulev = new JTextField("2000",4));

    cp.add(pn = new JPanel());
    pn.add(btOk=new JButton("Ok"));
    pn.add(btMegse=new JButton("Mégse"));

    cp.add(lbInfo = new JLabel("",JLabel.CENTER));

    tfSzulev.addFocusListener(this);                       //2
    btOk.addActionListener(this);
    btMegse.addActionListener(this);
    pack();
    show();

    tfSzulev.requestFocus();                               //3
  }

  boolean isNumber(String str, int also, int felso) {      //4
    try {
      int szulev = Integer.parseInt(str);
      if (szulev<also || szulev>felso)
        throw new NumberFormatException();
      return true;
    }
    catch(NumberFormatException ex) {
      return false;
    }
  }

  // Ha fókuszba került:
  public void focusGained(FocusEvent ev) {                 //5
  }

  // Ha elveszítette a fókuszt:
  public void focusLost(FocusEvent ev) {                   //6
    if (ev.getComponent()==tfSzulev && !ev.isTemporary())
      if (!isNumber(tfSzulev.getText(),1900,2000))
        lbInfo.setText("Évszám 1900-2000!");
      else
        lbInfo.setText("");
  }

  public void actionPerformed(ActionEvent ev) {            //7
    if (ev.getSource()==btOk) {
      if (lbInfo.getText().equals(""))
        dispose();
      else
        tfSzulev.requestFocus();
    }
    else if (ev.getSource()==btMegse)
      dispose();
  }
}

public class CheckDialogs extends JFrame implements ActionListener {
  private JButton btNew;

  public CheckDialogs() {
    setLocation(300,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().add(btNew=new JButton("Új dialógus"));
    btNew.addActionListener(this);
    pack();
    show();
  }

  public void actionPerformed(ActionEvent e) {
    new CheckDialog(this);
  }

  public static void main (String args[]) {
    new CheckDialogs();
  } // main
}
