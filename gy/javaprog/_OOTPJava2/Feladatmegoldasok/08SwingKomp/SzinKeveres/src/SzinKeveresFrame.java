/*
 * Feladatmegoldások/8. fejezet
 * Projekt: SzinKeveres
 * SzinKeveresFrame.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SzinKeveresFrame extends JFrame implements AdjustmentListener {
  private Container cp;
  private JPanel pnSzin = new JPanel();
  private JPanel pnVezer = new JPanel();
  private JLabel lbSzinKijelzo = new JLabel(" ",JLabel.CENTER);
  private JScrollBar sbRed = new JScrollBar();
  private JScrollBar sbGreen = new JScrollBar();
  private JScrollBar sbBlue = new JScrollBar();

  public SzinKeveresFrame() {
    cp = getContentPane();
    setSize(new Dimension(400,400));
    setTitle("SzinKeveres");
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    cp.add(lbSzinKijelzo,BorderLayout.NORTH);

    sbRed.setMaximum(255+10);
    sbRed.setBorder(BorderFactory.createLoweredBevelBorder());
    sbRed.setMinimumSize(new Dimension(50,10));
    sbRed.setPreferredSize(new Dimension(25,100));
    sbRed.addAdjustmentListener(this);

    sbGreen.setMaximum(255+10);
    sbGreen.setBorder(BorderFactory.createLoweredBevelBorder());
    sbGreen.setPreferredSize(new Dimension(25,100));
    sbGreen.addAdjustmentListener(this);

    sbBlue.setMaximum(255+10);
    sbBlue.setBorder(BorderFactory.createLoweredBevelBorder());
    sbBlue.setMinimumSize(new Dimension(50,10));
    sbBlue.setPreferredSize(new Dimension(25,100));

    sbBlue.addAdjustmentListener(this);

    pnVezer.setBorder(BorderFactory.createLineBorder(Color.black));
    cp.add(pnSzin,BorderLayout.CENTER);

    pnVezer.add(new JLabel("Red:"));
    pnVezer.add(sbRed);
    pnVezer.add(new JLabel("Green:"));
    pnVezer.add(sbGreen);
    pnVezer.add(new JLabel("Blue:"));
    pnVezer.add(sbBlue);
    cp.add(pnVezer,BorderLayout.SOUTH);
    szinAllitas();
  }

  void szinAllitas() {
    int red = sbRed.getValue();
    int green = sbGreen.getValue();
    int blue = sbBlue.getValue();
    pnSzin.setBackground(new Color(red,green,blue));
    lbSzinKijelzo.setText("Color ("+red+","+green+","+blue+")");
  }

  public void adjustmentValueChanged(AdjustmentEvent e) {
    szinAllitas();
  }
}