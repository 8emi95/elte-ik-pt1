/*
 * Feladatmegold�sok/8. fejezet
 * MeggyNarancs.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MeggyNarancs extends JFrame implements ActionListener {
  private JTextField tf;
  private JButton bt1, bt2;
  private Container cp = getContentPane();

  public MeggyNarancs() {
    setLocation(300,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    cp.setLayout(new FlowLayout());
    cp.add(tf=new JTextField(7));
    tf.setEnabled(false);
    cp.add(bt1 = new JButton("Meggy"));
    cp.add(bt2 = new JButton("Narancs"));
    bt1.setBackground(Color.red);
    bt2.setBackground(Color.orange);
    bt1.addActionListener(this);
    bt2.addActionListener(this);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    pack();
    show();
    bt2.requestFocus(); // csak a show ut�n van hat�sa!
  }

  public void actionPerformed(ActionEvent e) {
    tf.setText(e.getActionCommand());
    tf.setForeground(((Component)e.getSource()).getBackground());
  }

  public static void main (String args[]) {
    new MeggyNarancs();
  } // main
} // MeggyNarancs
