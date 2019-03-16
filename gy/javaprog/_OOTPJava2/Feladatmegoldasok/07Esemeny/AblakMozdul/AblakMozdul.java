/*
 * Feladatmegoldások/7. fejezet
 * AblakMozdul.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AblakMozdul extends JFrame implements ActionListener {
  private Container cp=getContentPane();

  public AblakMozdul() {
    setLocation(200,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JButton bt;
    cp.add(bt=new JButton("fel"),"North");
    bt.addActionListener(this);
    cp.add(bt=new JButton("le"),"South");
    bt.addActionListener(this);
    cp.add(bt=new JButton("jobbra"),"East");
    bt.addActionListener(this);
    cp.add(bt=new JButton("balra"),"West");
    bt.addActionListener(this);

    pack();
    show();
  }

  public void actionPerformed(ActionEvent ev) {
    String ac=ev.getActionCommand();
    if (ac.equals("fel"))
      setLocation(getX(),getY()-10);
    else if (ac.equals("le"))
      setLocation(getX(),getY()+10);
    else if (ac.equals("jobbra"))
      setLocation(getX()+10,getY());
    else if (ac.equals("balra"))
      setLocation(getX()-10,getY());
  }

  public static void main (String[] args) {
    new AblakMozdul();
  }
}
