/*
 * Feladatmegold�sok/8. fejezet
 * UgraloGomb.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UgraloGomb extends JFrame implements ActionListener {
  private Container cp = getContentPane();
  private int n = 0;
  private JButton btGomb;  // ugr�l� gomb
  private Timer timer;     // a gombot ugr�ltat� id�z�t�

  public UgraloGomb() {
    // A keret kezdetben elfoglalja a teljes k�perny�t:
    setSize(Toolkit.getDefaultToolkit().getScreenSize());
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    cp.setLayout(null);  // �n adom meg a gomb m�ret�t �s helyzet�t
    cp.add(btGomb = new JButton("Kapj el!  "));
    btGomb.setSize(90,40);
    ugrikaGomb();
    btGomb.addActionListener(this);

    show();
    timer = new Timer(800,this);
    timer.start();
  }

  // Ugrik a gomb egy v�letlen helyre:
  void ugrikaGomb() {
      int x = (int)(Math.random()*(getWidth()-30)+10);
      int y = (int)(Math.random()*(getHeight()-30)+20);
      btGomb.setLocation(x,y);
  }

  public void actionPerformed(ActionEvent e) {
    // Ha letelt az id�, ugrik a gomb:
    if (e.getSource()==timer) {
      n++;
      ugrikaGomb();
    }
    // Ha lenyomt�k (elkapt�k) a gombot, v�ge a j�t�knak:
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
