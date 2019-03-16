/*
 * Projekt: KissDraw
 *
 * Csomag: drawing
 * ToolButton.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// JButton, melynek l�trehoz�skor kezd� param�tereket lehet adni.
public class ToolButton extends JButton {
  // Param�terek: Akci�parancs, k�p, eszk�ztipp, figyel�.
  public ToolButton(String command, ImageIcon img, String tip, ActionListener listener) {
    setMargin(new Insets(1,1,1,1));
    setIcon(img);
    setActionCommand(command);
    setToolTipText(tip);
    addActionListener(listener);
  }

  // Param�terek: Akci�parancs, sz�veg, eszk�ztipp, figyel�.
  public ToolButton(String command, String text, String tip, ActionListener listener) {
    setMargin(new Insets(1,1,1,1));
    setFont(new Font("Dialog",Font.PLAIN,12));
    setText(text);
    this.setActionCommand(command);
    setToolTipText(tip);
    addActionListener(listener);
  }
}
