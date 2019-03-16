/*
 * Feladatmegoldások/12. fejezet
 * Projekt: mikro
 * MikroBelso.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * <p>A  mikrohullámú sütõ belseje.</p>
 * Ez az osztály kizárólag implementációs osztály, nincs a terven.
 * Csak díszítõ jellege van. Van rajta egy felirat és egy étel.
 * @author Angster Erzsébet
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
    lbFelirat.setText("Csáky rostélyos");
    this.setLayout(borderLayout1);
    imgEtel = new ImageIcon(getClass().getResource("image/csaky.jpg"));
    lbEtel.setIcon(imgEtel);
    this.setBackground(SystemColor.control);
    this.setBorder(border2);
    this.add(lbFelirat, BorderLayout.NORTH);
    this.add(lbEtel, BorderLayout.CENTER);
  }

}
