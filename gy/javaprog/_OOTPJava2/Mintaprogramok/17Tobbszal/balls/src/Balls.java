/*
 * Mintaprogramok/17. fejezet
 * Projekt: balls
 * Balls.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Balls extends JApplet {
  Container cp = getContentPane();
  BallPanel ballPanel;

  public void init() {
    cp.add(new JLabel("Labdák",JLabel.CENTER),"North");
    cp.add(ballPanel = new BallPanel());
    ballPanel.start();
  }

  public void start() {
    ballPanel.setActive(true);
  }

  public void stop() {
    ballPanel.setActive(false);
  }
}
