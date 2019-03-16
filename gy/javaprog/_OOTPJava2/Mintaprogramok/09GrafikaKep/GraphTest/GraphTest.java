/*
 * Mintaprogramok/9. fejezet
 * GraphTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;

class RajzPanel extends JPanel {

  protected void paintComponent(Graphics gr) {        //1
    super.paintComponent(gr);                         //2
    setBackground(new Color(130,180,160));            //3
    gr.drawOval(40,80,320,100);                       //4
    gr.drawRect(40,80,320,100);                       //5
    gr.setColor(Color.WHITE);                         //6
    gr.setFont(new Font("Arial",Font.BOLD,40));       //7
    gr.drawString("Végre grafika!",60,140);           //8
    gr.drawLine(60,140,340,140);                      //9
    gr.setColor(Color.ORANGE);                        //10
    gr.fillRect(0,200,500,10);                        //11
  }
}

public class GraphTest extends JFrame {
  public GraphTest() {
    setBounds(500,200,400,280);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(new RajzPanel());
    show();
  }

  public static void main (String args[]) {
    new GraphTest();
  } // main
} // GraphTest
