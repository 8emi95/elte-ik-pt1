/*
 * Feladatmegoldások/19. fejezet
 * MennyitNyomod.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.event.*;

public class MennyitNyomod extends JFrame {
  private JButton btNyomas, btVege;
  private JLabel lbInfo;
  private long pressingTime = 0;

  class NyomasFigyelo extends MouseAdapter {
    private long time;

    public void mousePressed(MouseEvent e) {
      time = System.currentTimeMillis();
    }

    public void mouseReleased(MouseEvent e) {
      pressingTime += System.currentTimeMillis()-time;
      lbInfo.setText("Eddig "+pressingTime/1000+" mp-ig nyomtad");
    }
  }

  public MennyitNyomod() {
    setBounds(100,100,500,200);
    getContentPane().add(btVege=new JButton("Számolom, mennyi ideig nyomod ezt a gombot",
      new ImageIcon("icons/snooze.gif")),"South");
    btVege.addMouseListener(new NyomasFigyelo());
    getContentPane().add(lbInfo = new JLabel(" ",SwingConstants.CENTER),"North");

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    show();
  }

  public static void main(String[] args) {
    new MennyitNyomod();
  }
}
