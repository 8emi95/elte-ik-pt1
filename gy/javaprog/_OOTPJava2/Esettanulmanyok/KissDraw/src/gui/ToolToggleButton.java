/*
 * Projekt: KissDraw
 *
 * Csomag: drawing
 * ToolToggleButton.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// JToggleButton, melynek létrehozáskor kezdõ paramétereket lehet adni.
public class ToolToggleButton extends JToggleButton {
  // Paraméterek: Akcióparancs, kép, eszköztipp, figyelõ.
  public ToolToggleButton(String command, ImageIcon img, String tip, ButtonGroup bg, ActionListener listener) {
    setActionCommand(command);
    setIcon(img);
    setToolTipText(tip);
    bg.add(this);
    addActionListener(listener);
    setMargin(new Insets(0,0,0,0));
  }

  // Paraméterek: Akcióparancs, szöveg, eszköztipp, figyelõ.
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
