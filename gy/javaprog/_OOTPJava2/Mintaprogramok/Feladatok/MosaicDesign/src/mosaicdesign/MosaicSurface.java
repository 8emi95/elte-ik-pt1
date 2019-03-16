/*
 * Mintaprogramok/Feladatok
 * Projekt: MosaicDesign
 * MosaicSurface.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

package mosaicdesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MosaicSurface extends JPanel {
  int width = 20, height = 20; // alap�rtelmez�s
  Color paintColor = Color.GRAY;
  Color baseColor = Color.WHITE;

  class MosaicAdapter extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
      JLabel lb = (JLabel) e.getSource();
      lb.setBackground(paintColor);
    }
  }

  public MosaicSurface(int width, int height) {
    this.width = width;
    this.height = height;
    setLayout(new GridLayout(width, height, 2, 2));
    JLabel lb;
    for (int i = 0; i < width * height; i++) {
      lb = new JLabel(" ");
      lb.setBorder(BorderFactory.createEmptyBorder());
      lb.setBackground(Color.white);
      lb.setOpaque(true);
      lb.addMouseListener(new MosaicAdapter());
      add(lb);
    }
  }

  // Minden csempe sz�ne baseColor lesz:
  public void clear() {
    Component[] labels = this.getComponents();
    for (int i = 0; i < labels.length; i++) {
      labels[i].setBackground(baseColor);
    }
  }

  // Aktu�lis csempesz�n be�ll�t�sa.
  void setPaintColor(Color paintColor) {
    this.paintColor = paintColor;
  }

  // Saj�t szerializ�ci� (ki�r�s):
  public void writeToFile(File file) {

    try {
      ObjectOutputStream out =
          new ObjectOutputStream(new FileOutputStream(file));
      for (int i = 0; i < this.getComponentCount(); i++) {
        out.writeObject(this.getComponent(i).getBackground());
      }
      out.close();
    }
    catch (Exception ex) {
      System.out.println(ex);
    }
  }

  // Saj�t szerializ�ci� (beolvas�s):
  public void readFromFile(File file) {
    try {
      ObjectInputStream in =
          new ObjectInputStream(new FileInputStream(file));
      for (int i = 0; i < width * height; i++) {
        this.getComponent(i).setBackground( (Color) in.readObject());
      }
    }
    catch (Exception ex) {
      System.out.println(ex);
      // Valamennyit berakott, az j� nek�nk.
    }
  }
}