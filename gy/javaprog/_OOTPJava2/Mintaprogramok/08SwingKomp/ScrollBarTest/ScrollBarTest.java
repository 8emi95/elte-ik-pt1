/*
 * Mintaprogramok/8. fejezet
 * ScrollBarTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EvszamBeallit extends JFrame implements
                    AdjustmentListener, ActionListener {
  private Container cp = getContentPane();
  private int minEv=1900, maxEv=2100, aktEv=2001;
  private JTextField tfSzam;
  private JScrollBar sbSzam;

  public EvszamBeallit() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setBounds(100,100,400,80);
    setTitle("Scroll test");

    // Param: orientation, value, visibleAmount, minimum, maximum:
    cp.add(sbSzam = new JScrollBar(JScrollBar.HORIZONTAL,
        aktEv,5,minEv,maxEv+5),"North");                   //1
    sbSzam.setBlockIncrement(10);
    sbSzam.addAdjustmentListener(this);

    JPanel pn;
    cp.add(pn = new JPanel());
    pn.add(new JLabel(minEv+"-"+maxEv+": "));
    pn.add(tfSzam = new JTextField(""+aktEv));
    tfSzam.addActionListener(this);
    show();
  }

  public void adjustmentValueChanged(AdjustmentEvent e) {  //2
    tfSzam.setText(Integer.toString(sbSzam.getValue()));
  }

  public void actionPerformed(ActionEvent e) {             //3
    try {
      int szam = Integer.parseInt(tfSzam.getText());
      if (szam<sbSzam.getMinimum() ||
        szam>sbSzam.getMaximum()-sbSzam.getVisibleAmount())
        throw new Exception();
      sbSzam.setValue(szam);
    }
    catch (Exception ex) {
      tfSzam.setText(Integer.toString(sbSzam.getValue()));
    }
  }
}

public class ScrollBarTest {
  public static void main (String args[]) {
    new EvszamBeallit();
  } // main
} // ScrollBarTest
