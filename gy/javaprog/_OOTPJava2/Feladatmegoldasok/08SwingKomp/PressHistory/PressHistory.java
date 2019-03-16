/*
 * Feladatmegoldások/8. fejezet
 * PressHistory.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PressHistory extends JFrame implements ActionListener {
  private int numButtons;
  JButton[] btPress = new JButton[numButtons];
  JLabel lbPressHistory;
  Container cp = getContentPane();

  public PressHistory(int numButtons) {
    setLocation(200,200);
    setResizable(false);
    this.numButtons = numButtons;
    cp.setLayout(new GridLayout(0,1));
    JButton bt;
    for (int i=1; i<=numButtons; i++) {
      cp.add(bt = new JButton(""+i));
      bt.addActionListener(this);
    }
    cp.add(lbPressHistory = new JLabel());
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    pack();
    show();
  }

  public void actionPerformed(ActionEvent e) {
    lbPressHistory.setText(lbPressHistory.getText() + e.getActionCommand());
    pack();
  }

  public static void main (String args[]) {
    int n = 5;
    if (args.length>0) {
      try {
        n = Integer.parseInt(args[0]);
      }
      catch(NumberFormatException ex) {
        System.out.println(ex.getMessage());
      }
    }
    new PressHistory(n);
  } // main
} // PressHistory
