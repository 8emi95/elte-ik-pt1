/*
 * Mintaprogramok/17. fejezet
 * Projekt: balls
 * BallPanel.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;
import java.util.*;
import java.awt.*;

class BallPanel extends JPanel {
  Vector balls = new Vector();                           //1

  public BallPanel() {                                   //2
    balls.add(new Ball(10,150,Color.RED,this));
    balls.add(new Ball(200,150,Color.BLUE,this));
    balls.add(new Ball(280,10,Color.YELLOW,this));
  }

  public void paintComponent(Graphics gr) {              //3
    super.paintComponent(gr);
    for (int i = 0; i < balls.size(); i++) {
      ((Ball)balls.get(i)).draw(gr);
    }
  }

  public void start() {                                  //4
    for (int i = 0; i < balls.size(); i++)
      ((Ball)balls.get(i)).start();
  }

  public synchronized void setActive(boolean active) {   //5
    for (int i = 0; i < balls.size(); i++) {
      Ball ball = (Ball)balls.get(i);
      ball.setActive(active);
    }
  }
}
