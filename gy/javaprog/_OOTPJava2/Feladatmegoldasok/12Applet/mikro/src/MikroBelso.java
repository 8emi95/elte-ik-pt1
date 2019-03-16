/*
 * Feladatmegold�sok/12. fejezet
 * Projekt: mikro
 * MikroBelso.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * <p>A  mikrohull�m� s�t� belseje.</p>
 * Ez az oszt�ly kiz�r�lag implement�ci�s oszt�ly, nincs a terven.
 * Csak d�sz�t� jellege van. Van rajta egy felirat �s egy �tel.
 * @author Angster Erzs�bet
 * @version 1.0
 */

public class MikroBelso extends JPanel {
  private JLabel lbFelirat = new JLabel();
  private ImageIcon imgEtel;
  private JLabel lbEtel = new JLabel();
  private BorderLayout borderLayout1 = new BorderLayout();
  private Border border1;
  private Border border2;

  public MikroBelso() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    border1 = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(
        Color.white,Color.gray),BorderFactory.createEmptyBorder(20,20,20,20));
    border2 = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(
        BevelBorder.RAISED,Color.orange,Color.darkGray,new Color(115, 114, 105),
        new Color(165, 163, 151)),BorderFactory.createEmptyBorder(4,4,4,4));
    lbFelirat.setFont(new java.awt.Font("Dialog", 0, 20));
    lbFelirat.setBackground(Color.orange);
    lbFelirat.setOpaque(true);
    lbFelirat.setForeground(Color.gray);
    lbFelirat.setHorizontalAlignment(SwingConstants.CENTER);
    lbFelirat.setText("Cs�ky rost�lyos");
    this.setLayout(borderLayout1);
    imgEtel = new ImageIcon(getClass().getResource("image/csaky.jpg"));
    lbEtel.setIcon(imgEtel);
    this.setBackground(SystemColor.control);
    this.setBorder(border2);
    this.add(lbFelirat, BorderLayout.NORTH);
    this.add(lbEtel, BorderLayout.CENTER);
  }

}
