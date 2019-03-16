/*
 * Feladatmegoldások/9. fejezet
 * Fugveny.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Másodfokú függvény ábrázolása.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// a*x2 + b*x + c rajza:
class FuggvenyRajz extends JPanel {
  private double a, b, c;
  private boolean ok=false;

  public boolean setFuggveny(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
    ok = b*b-4*a*c>=0;
    repaint();
    return ok;
  }

  int y(int x) {
    return (int)(a*x*x+b*x+c);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int maxX = getWidth()/2;
    int maxY = getHeight()/2;
    g.translate(maxX,maxY);
    setBackground(SystemColor.control);
    g.setColor(Color.white);
    g.drawLine(-maxX,0,maxX,0);
    g.drawLine(0,-maxY,0,maxY);
    if (!ok)
      return;
    g.setColor(Color.black);

    int eX=-maxX, eY=y(eX);
    int y;
    for (int x=-maxX+1; x<=maxX; x++) {
      y = y(x);
      g.drawLine(eX,-eY,x,-y);
      eX=x; eY=y;
    }
  }
}

public class Fuggveny extends JFrame implements ActionListener {
  private JTextField tfA, tfB, tfC;
  private JButton btRajzol;
  private FuggvenyRajz fvRajz;
  private JLabel lbInfo;

  public Fuggveny() {
    setBounds(0,0,800,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Panel pn = new Panel();
    pn.add(tfA=new JTextField(6));
    pn.add(new JLabel("X2 + "));
    pn.add(tfB=new JTextField(6));
    pn.add(new JLabel("X + "));
    pn.add(tfC=new JTextField(6));
    pn.add(btRajzol=new JButton("Rajzol"));
    getContentPane().add(pn,"North");
    getContentPane().add(fvRajz=new FuggvenyRajz());
    getContentPane().add(lbInfo=new JLabel(),"South");
    lbInfo.setHorizontalAlignment(JLabel.CENTER);

    btRajzol.addActionListener(this);

    show();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==btRajzol) {
      lbInfo.setText("");
      try {
        double a,b,c;
        a = Double.parseDouble(tfA.getText());
        b = Double.parseDouble(tfB.getText());
        c = Double.parseDouble(tfC.getText());
        if (!fvRajz.setFuggveny(a,b,c)) {
          lbInfo.setText("Negatív diszkrimináns!");
        }
      }
      catch(Exception ex) {
        lbInfo.setText("Nem jó együtthatók!");
      }
    }
  }

  public static void main (String args[]) {
    new Fuggveny();
  }
}
