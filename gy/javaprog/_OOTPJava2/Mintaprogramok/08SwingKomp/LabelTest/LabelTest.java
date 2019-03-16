/*
 * Mintaprogramok/8. fejezet
 * LabelTest.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LabelPanel extends JPanel implements ActionListener {
  private JLabel lbSzoveg;
  private JButton btKovetkezo;

  public LabelPanel() {
    setLayout(new BorderLayout());                         //1
    add(lbSzoveg = new JLabel("Szeretem",JLabel.LEFT),"North");
    lbSzoveg.setFont(new Font("Dialog",Font.BOLD,18));

    add(new JLabel(new ImageIcon("icons/bivaly.gif")));    //2
    add(btKovetkezo = new JButton("K�vetkez�"),"South");
    btKovetkezo.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {             //3
    if (lbSzoveg.getHorizontalAlignment()==JLabel.LEFT) {
      lbSzoveg.setHorizontalAlignment(JLabel.RIGHT);
      lbSzoveg.setText("Nem szeretem");
    }
    else {
      lbSzoveg.setHorizontalAlignment(JLabel.LEFT);
      lbSzoveg.setText("Szeretem");
    }
  }
}

class LabelTestFrame extends JFrame {
  public LabelTestFrame() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setBounds(100,100,200,250);
    setTitle("Bivalyos");
    getContentPane().add(new LabelPanel());                //4
    setVisible(true);
  }
}

public class LabelTest {
  public static void main(String[] args) {
    new LabelTestFrame();
  }
}
