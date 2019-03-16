/*
 * Projekt: KissDraw
 *
 * Csomag: drawing
 * ToolToggleButton.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// JToggleButton, melynek l�trehoz�skor kezd� param�tereket lehet adni.
public class ToolToggleButton extends JToggleButton {
  // Param�terek: Akci�parancs, k�p, eszk�ztipp, figyel�.
  public ToolToggleButton(String command, ImageIcon img, String tip, ButtonGroup bg, ActionListener listener) {
    setActionCommand(command);
    setIcon(img);
    setToolTipText(tip);
    bg.add(this);
    addActionListener(listener);
    setMargin(new Insets(0,0,0,0));
  }

  // Param�terek: Akci�parancs, sz�veg, eszk�ztipp, figyel�.
  public ToolToggleButton(String command, String text, String tip, ButtonGroup bg, ActionListener listener) {
    setFont(new Font("Dialog",Font.PLAIN,12));
    setActionCommand(command);
    setText(text);
    setToolTipText(tip);
    bg.add(this);
    addActionListener(listener);
    setMargin(new Insets(0,0,0,0));
  }
}
