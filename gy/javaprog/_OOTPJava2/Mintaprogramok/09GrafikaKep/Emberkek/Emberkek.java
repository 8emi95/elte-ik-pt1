/*
 * Mintaprogramok/9. fejezet
 * Emberkek.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.awt.*;
import javax.swing.*;

class Emberke extends JPanel {
  private Color color;

  public Emberke(Color color) {                            //1
    this.color = color;
  }

  protected void paintComponent(Graphics gr) {             //2
    super.paintComponent(gr);
    // A (0,0) pont az emberke sz�ve helye:
    gr.translate(getWidth()/2,getHeight()/2);
    gr.setColor(color);
    gr.drawOval(-5,-15,10,10); // emberke feje
    gr.drawLine(0,-5,0,7);     // t�rzse, f�gg�leges egyenes
    gr.drawLine(-7,0,+7,0);    // k�t keze
    gr.drawLine(0,7,-5,20);    // bal l�ba
    gr.drawLine(0,7,5,20);     // jobb l�ba
  }
}

class EmberkekPanel extends JPanel {
  public EmberkekPanel() {
    setLayout(new GridLayout(5,0));
    setBackground(Color.LIGHT_GRAY);
    for (int i=0; i<10; i++) {                             //3
      add(new Emberke(Color.BLUE));
      add(new Emberke(Color.RED));
      add(new Emberke(Color.BLACK));
    }
  }
}

public class Emberkek extends JFrame {
  public Emberkek() {
    setBounds(100,100,300,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(new EmberkekPanel());
    show();
  }

  public static void main (String args[]) {
    new Emberkek();
  } // main
} // Emberkek
