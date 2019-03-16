/*
 * Feladatmegoldások/8. fejezet
 * HirdetoTabla.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class HirdetoTabla extends JFrame implements ActionListener {
  private Container cp = getContentPane();
  private String[] szovegek = {"Sportolj rendszeresen!","Ne torkoskodj!",
    "Figyelj másokra!","Programozz lelkesen!"};
  private Color[] szinek = {Color.red,Color.blue,Color.orange,
    new Color(100,150,100),Color.magenta};
  private JLabel lbSzoveg;
  private int szovegSorszam = 0;
  private int szinSorszam = 0;
  private Timer szovegValto, szinValto;
  private JButton btBezar;

  public HirdetoTabla() {
    setBounds(200,200,400,200);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    setBackground(Color.lightGray);
    cp.add(lbSzoveg = new JLabel(szovegek[0],JLabel.CENTER));
    lbSzoveg.setForeground(szinek[szinSorszam]);
    lbSzoveg.setFont(new Font("Arial",Font.PLAIN,30));
    cp.add(btBezar = new JButton("Vége"),"South");
    szovegValto = new Timer(8000,this);
    szovegValto.start();
    szinValto = new Timer(1000,this);
    szinValto.start();
    btBezar.addActionListener(this);
    show();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==szovegValto) {
      szovegSorszam++;
      if (szovegSorszam == szovegek.length)
        szovegSorszam = 0;
      lbSzoveg.setText (szovegek[szovegSorszam]);
      szinSorszam = 0;
      lbSzoveg.setForeground(szinek[szinSorszam]);
      szinValto.restart();
    }
    else if (e.getSource()==szinValto){
      szinSorszam++;
      if (szinSorszam == szinek.length)
        szinSorszam = 0;
      lbSzoveg.setForeground(szinek[szinSorszam]);
    }
    else if (e.getSource()==btBezar)
      System.exit(0);
  }

  public static void main (String args[]) {
    new HirdetoTabla();
  }
}
