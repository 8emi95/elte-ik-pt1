/*
 * Feladatmegoldások/8. fejezet
 * NevKivalasztas.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Feladat (A): A keretben látható egy italokat tartalmazó lista,
 * melynek feltöltésérõl a programból gondoskodunk. Egy ital
 * kikeveséséhez a listából ki lehet választani italokat, egyszerre
 * akárhányat. Jelenjenek meg a keret alsó részén egy szövegmezõben
 * a listából kiválasztott italok! A szövegmezõt nem lehet szerkeszteni.
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class ItalKeveres extends JFrame
                            implements ListSelectionListener {
  private Container cp = getContentPane();
  private String[] italok = {"Vörösbor","Fehérbor","Sör","Törkölypálinka",
          "Szilvórium","Campari","Whisky","Ásványvíz","Jég","Narancslé",
          "Baracklé","Paradicsomital","Tej"};
  private JList lstItalok = new JList(italok);
  private JTextField tfKivalasztottItalok = new JTextField(" ");

  public ItalKeveres() {
    setTitle("Italkevesés");
    setBounds(300,200,400,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    cp.add(new JScrollPane(lstItalok));
    lstItalok.setBorder(BorderFactory.createLoweredBevelBorder());
    cp.add(tfKivalasztottItalok,BorderLayout.SOUTH);
    tfKivalasztottItalok.setEditable(false);
    lstItalok.addListSelectionListener(this);
    show();
  }

  public void valueChanged(ListSelectionEvent ev) {
    Object[] kivalasztottItalok = lstItalok.getSelectedValues();
    if (kivalasztottItalok.length==0) {
      tfKivalasztottItalok.setText("");
      return;
    }
    String str = "" + kivalasztottItalok[0];
    for (int i = 1; i < kivalasztottItalok.length; i++)
      str = str + ", " + kivalasztottItalok[i];
    tfKivalasztottItalok.setText(str);
  }

  public static void main(String[] args) {
    new ItalKeveres();
  }
}
