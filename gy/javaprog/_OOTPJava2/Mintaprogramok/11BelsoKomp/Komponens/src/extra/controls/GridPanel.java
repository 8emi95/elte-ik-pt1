/*
 * Mintaprogramok/11. fejezet
 * Projekt: Komponens
 * GridPanel.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Rácsos panel.
 */

package extra.controls;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
  private int gridX, gridY;

  public GridPanel(int gridX, int gridY) {
    super();
    this.gridX = gridX;
    this.gridY = gridY;
  }
  public void paintComponent(Graphics g) {
    g.setColor(new Color(220,220,220));
    for (int x=0; x<getWidth(); x+=gridX)
      g.drawLine(x,0,x,getHeight());
    for (int y=0; y<getHeight(); y+=gridY) {
      g.drawLine(0,y,getWidth(),y);
    }
  }
} // GridPanel
