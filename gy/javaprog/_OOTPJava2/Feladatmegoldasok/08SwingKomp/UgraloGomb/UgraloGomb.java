/*
 * Feladatmegoldások/8. fejezet
 * UgraloGomb.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UgraloGomb extends JFrame implements ActionListener {
  private Container cp = getContentPane();
  private int n = 0;
  private JButton btGomb;  // ugráló gomb
  private Timer timer;     // a gombot ugráltató idõzítõ

  public UgraloGomb() {
    // A keret kezdetben elfoglalja a teljes képernyõt:
    setSize(Toolkit.getDefaultToolkit().getScreenSize());
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    cp.setLayout(null);  // én adom meg a gomb méretét és helyzetét
    cp.add(btGomb = new JButton("Kapj el!  "));
    btGomb.setSize(90,40);
    ugrikaGomb();
    btGomb.addActionListener(this);

    show();
    timer = new Timer(800,this);
    timer.start();
  }

  // Ugrik a gomb egy véletlen helyre:
  void ugrikaGomb() {
      int x = (int)(Math.random()*(getWidth()-30)+10);
      int y = (int)(Math.random()*(getHeight()-30)+20);
      btGomb.setLocation(x,y);
  }

  public void actionPerformed(ActionEvent e) {
    // Ha letelt az idõ, ugrik a gomb:
    if (e.getSource()==timer) {
      n++;
      ugrikaGomb();
    }
    // Ha lenyomták (elkapták) a gombot, vége a játéknak:
    else if (e.getSource()==btGomb) {
      timer.stop();
      btGomb.setText("Jaj! "+n);
      setTitle("Elkaptalak!");
    }
  }

  public static void main (String args[]) {
    new UgraloGomb();
  }
}
