/*
 * Mintaprogramok/8. fejezet
 * Stopper.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Stopper extends JPanel implements ActionListener {   //1
  private Timer timer;
  private int ido = 0;
  private JLabel kijelzo;
  private JButton btStart, btStop;

  public Stopper(int delay) {
    setBorder(BorderFactory.createLoweredBevelBorder());
    setLayout(new GridLayout(0,1));
    add(kijelzo = new JLabel("0",JLabel.CENTER));
    add(btStart=new JButton("Start"));
    add(btStop=new JButton("Stop"));
    btStart.addActionListener(this);
    btStop.addActionListener(this);
    timer = new Timer(delay,this);                        //2
    timer.start();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource ()==timer) {                           //3
      ido++;
      kijelzo.setText(""+ido);
    }
    else if (e.getSource ()==btStart){                     //4
      timer.restart();
    }
    else if (e.getSource ()==btStop){                      //5
      timer.stop();
    }
  }
}

public class StopperApp extends JFrame {

  public StopperApp() {
    setLocation(200,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container cp = getContentPane();
    cp.setLayout(new GridLayout(1,0));
    cp.add(new Stopper(100));
    cp.add(new Stopper(2000));
    pack();
    show();
  }

  public static void main (String args[]) {
    new StopperApp();
  }
}
