/*
 * Feladatmegold�sok/8. fejezet
 * NevKivalasztas.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Feladat (A): A keretben l�that� egy italokat tartalmaz� lista,
 * melynek felt�lt�s�r�l a programb�l gondoskodunk. Egy ital
 * kikeves�s�hez a list�b�l ki lehet v�lasztani italokat, egyszerre
 * ak�rh�nyat. Jelenjenek meg a keret als� r�sz�n egy sz�vegmez�ben
 * a list�b�l kiv�lasztott italok! A sz�vegmez�t nem lehet szerkeszteni.
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class ItalKeveres extends JFrame
                            implements ListSelectionListener {
  private Container cp = getContentPane();
  private String[] italok = {"V�r�sbor","Feh�rbor","S�r","T�rk�lyp�linka",
          "Szilv�rium","Campari","Whisky","�sv�nyv�z","J�g","Narancsl�",
          "Barackl�","Paradicsomital","Tej"};
  private JList lstItalok = new JList(italok);
  private JTextField tfKivalasztottItalok = new JTextField(" ");

  public ItalKeveres() {
    setTitle("Italkeves�s");
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
