/*
 * Projekt: KissDraw
 *
 * Csomag: drawing
 * ToolButton.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// JButton, melynek létrehozáskor kezdõ paramétereket lehet adni.
public class ToolButton extends JButton {
  // Paraméterek: Akcióparancs, kép, eszköztipp, figyelõ.
  public ToolButton(String command, ImageIcon img, String tip, ActionListener listener) {
    setMargin(new Insets(1,1,1,1));
    setIcon(img);
    setActionCommand(command);
    setToolTipText(tip);
    addActionListener(listener);
  }

  // Paraméterek: Akcióparancs, szöveg, eszköztipp, figyelõ.
  public ToolButton(String command, String text, String tip, ActionListener listener) {
    setMargin(new Insets(1,1,1,1));
    setFont(new Font("Dialog",Font.PLAIN,12));
    setText(text);
    this.setActionCommand(command);
    setToolTipText(tip);
    addActionListener(listener);
  }
}
