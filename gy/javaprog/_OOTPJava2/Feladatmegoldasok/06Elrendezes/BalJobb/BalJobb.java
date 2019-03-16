/*
 * Feladatmegoldások/6. fejezet
 * BalJobb.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Feladat (B): Tegyen a keretbe egymás mellé két egyforma komponenst:
 * felül egy felirat (Bal, illetve Jobb), a többi rész egy szövegterület.
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

/* Szövegpanel, felül egy címkével. A címke szövegét a panel
 * paraméterben kapja meg.
 */
class SzovegPanel extends JPanel {
  private JTextArea taSzoveg = new JTextArea();

  public SzovegPanel(String cimke) {
    // A panel határmenti elrednezésû:
    setLayout(new BorderLayout());
    add(new JLabel(cimke,SwingConstants.CENTER),"North");
    add(taSzoveg);
    taSzoveg.setBorder(BorderFactory.createLoweredBevelBorder());
  }
}

// A fõ keretbe kér szövegpanelt teszünk, egymás mellé:
public class BalJobb extends JFrame {
  private Container cp = getContentPane();

  public BalJobb() {
    setBounds(100,100,400,400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    cp.setLayout(new GridLayout(1,2));
    cp.add(new SzovegPanel("Bal"));
    cp.add(new SzovegPanel("Jobb"));

    show();
  }

  public static void main(String[] args) {
    new BalJobb();
  }
}
