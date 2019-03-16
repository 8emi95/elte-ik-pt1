/*
 * Feladatmegoldások/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: buttons
 * PaintedButton.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Ki-be kapcsolható nyomógomb az eszköztárhoz. A gomb típusától függõen különbözõ
 * alakzatok szerepelhetnek: pont, egyenes, téglalap, kerekített téglalap, ellipszis....
 */

package buttons;

import javax.swing.*;
import java.awt.*;

public class PaintedButton extends JToggleButton {
  public static final int POINT=100;
  public static final int LINE=101;
  public static final int RECT=102;
  public static final int ROUNDEDRECT=103;
  public static final int OVAL=104;

  private int type;
  private static int margin=5;

  public PaintedButton(int type) {
    this.type = type;
    this.setPreferredSize(new Dimension(40,30));
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    switch (type) {
      case POINT:g.fillOval(getWidth()/2-3,getHeight()/2-3,3,3); break;
      case LINE: g.drawLine(margin,margin,getWidth()-margin,getHeight()-margin-1); break;
      case RECT: g.drawRect(margin,margin,getWidth()-2*margin-1,getHeight()-2*margin-1); break;
      case ROUNDEDRECT: g.drawRoundRect(margin,margin,getWidth()-2*margin-1,getHeight()-2*margin-1,8,12); break;
      case OVAL: g.drawOval(margin,margin,getWidth()-2*margin-1,getHeight()-2*margin-1); break;
    }
  }
}

