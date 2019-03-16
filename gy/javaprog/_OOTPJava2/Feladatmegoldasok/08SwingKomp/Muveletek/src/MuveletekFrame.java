/*
 * Feladatmegoldások/8. fejezet
 * Projekt: Muveletek.jpx
 * MuveletekFrame.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MuveletekFrame extends JFrame implements ActionListener {
  private Container cp;
  private JPanel pnMuvelet = new JPanel();
  private JPanel pnVezer = new JPanel();
  private JTextField tfSzam1 = new JTextField(6);
  private JTextField tfSzam2 = new JTextField(6);
  private JTextField tfEredmeny = new JTextField(12);
  private JButton btSzamitas = new JButton("Számítás");
  private JComboBox cbMuveletek = new JComboBox();

  public MuveletekFrame() {
    cp = getContentPane();
    cp.setLayout(new GridLayout(2,1));
    setTitle("Mûveletek");
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    tfSzam1.setHorizontalAlignment(SwingConstants.RIGHT);
    tfSzam1.addActionListener(this);
    pnMuvelet.add(tfSzam1);

    cbMuveletek.addItem("+");
    cbMuveletek.addItem("-");
    cbMuveletek.addItem("*");
    cbMuveletek.addItem("/");
    pnMuvelet.add(cbMuveletek);

    tfSzam2.setHorizontalAlignment(SwingConstants.RIGHT);
    tfSzam2.addActionListener(this);
    pnMuvelet.add(tfSzam2);

    pnMuvelet.add(new JLabel("="));
    pnMuvelet.add(tfEredmeny);

    tfEredmeny.setHorizontalAlignment(SwingConstants.RIGHT);
    btSzamitas.addActionListener(this);
    pnVezer.add(btSzamitas);

    cp.add(pnMuvelet);
    cp.add(pnVezer);
  }

  public void actionPerformed(ActionEvent e) {
    try {
      int szam1 = Integer.parseInt(tfSzam1.getText());
      int szam2 = Integer.parseInt(tfSzam2.getText());
      String muv = cbMuveletek.getSelectedItem().toString();
      if (muv.equals("+"))
        tfEredmeny.setText((szam1+szam2)+"");
      else if (muv.equals("-"))
        tfEredmeny.setText((szam1-szam2)+"");
      else if (muv.equals("*"))
        tfEredmeny.setText((szam1*szam2)+"");
      else if (muv.equals("/")) {
        if (szam2==0)
          throw new ArithmeticException("Nullával való osztás!");
        tfEredmeny.setText((szam1*1.0/szam2)+"");
      }
    }
    catch (ArithmeticException ex) {
      Toolkit.getDefaultToolkit().beep();
      tfEredmeny.setText(ex.getMessage());
    }
    catch (Exception ex) {
      Toolkit.getDefaultToolkit().beep();
      tfEredmeny.setText("Hiba!");
    }
  }
}
