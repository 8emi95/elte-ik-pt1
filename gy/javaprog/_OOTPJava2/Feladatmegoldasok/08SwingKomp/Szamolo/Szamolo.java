/*
 * Feladatmegoldások/8. fejezet
 * Szamolo.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SzamoloPanel extends JPanel implements ActionListener {
  private JTextField tfSzam1, tfSzam2, tfOsszeg, tfKulonbseg, tfSzorzat, tfHanyados;
  private JButton btSzamol, btKilep;
  private JLabel hibaInfo;

  public SzamoloPanel() {
    setLayout(new BorderLayout());
    JPanel pnSzamok = new JPanel();
    pnSzamok.setLayout(new GridLayout(0,2,3,3));

    pnSzamok.add(new JLabel("1. szám:",JLabel.RIGHT));
    pnSzamok.add(tfSzam1 = new JTextField(12));

    pnSzamok.add(new JLabel("2. szám:",JLabel.RIGHT));
    pnSzamok.add(tfSzam2 = new JTextField(12));

    pnSzamok.add(new JLabel("Összeg:",JLabel.RIGHT));
    pnSzamok.add(tfOsszeg = new JTextField(12));
    tfOsszeg.setEditable(false);

    pnSzamok.add(new JLabel("Különbség:",JLabel.RIGHT));
    pnSzamok.add(tfKulonbseg = new JTextField(12));
    tfKulonbseg.setEditable(false);

    pnSzamok.add(new JLabel("Szorzat:",JLabel.RIGHT));
    pnSzamok.add(tfSzorzat = new JTextField(12));
    tfSzorzat.setEditable(false);

    pnSzamok.add(new JLabel("Hányados:",JLabel.RIGHT));
    pnSzamok.add(tfHanyados= new JTextField(12));
    tfHanyados.setEditable(false);

    add(pnSzamok,"North");

    add(hibaInfo = new JLabel(" "),"Center");
    hibaInfo.setHorizontalAlignment(JLabel.CENTER);
    JPanel pnGombok = new JPanel();
    pnGombok.add(btSzamol = new JButton("Számol"));
    pnGombok.add(btKilep = new JButton("Kilép"));
    add(pnGombok,"South");

    tfSzam1.addActionListener(this);
    tfSzam2.addActionListener(this);
    btSzamol.addActionListener(this);
    btKilep.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    // Az eredménymezõk és az elõzõ üzenet törlése:
    tfOsszeg.setText("");
    tfKulonbseg.setText("");
    tfSzorzat.setText("");
    tfHanyados.setText("");
    hibaInfo.setText("");

    if (e.getSource() == btKilep)
      System.exit(0);
    try {
      int szam1 = Integer.parseInt(tfSzam1.getText());
      int szam2 = Integer.parseInt(tfSzam2.getText());
      tfOsszeg.setText(String.valueOf((long)szam1+szam2));
      tfKulonbseg.setText(String.valueOf((long)szam1-szam2));
      tfSzorzat.setText(String.valueOf((long)szam1*szam2));
      if (szam2==0)
        throw new ArithmeticException("Nullával való osztás!");
      tfHanyados.setText(String.valueOf(szam1*1.0/szam2));
    }
    catch (NumberFormatException ex) {
      hibaInfo.setText("Valamelyik szám nem jó (int típusú kell)!");
    }
    catch (ArithmeticException ex) {
      hibaInfo.setText(ex.getMessage());
      tfHanyados.setText("???");
    }
  }
}

public class Szamolo extends JFrame {

  public Szamolo() {
    setTitle("Számolás");
    setLocation(400,200);
    getContentPane().add(new SzamoloPanel());
    pack();
    show();
  }

  public static void main (String args[]) {
    new Szamolo();
  } // main
}
