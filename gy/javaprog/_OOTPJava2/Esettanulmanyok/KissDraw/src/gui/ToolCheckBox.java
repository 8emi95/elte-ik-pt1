/*
 * Projekt: KissDraw
 *
 * Csomag: drawing
 * ToolCheckBox.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// JCheckbox, melynek létrehozáskor kezdõ paramétereket lehet adni.
public class ToolCheckBox extends JCheckBox {
  // Paraméterek: Akcióparancs, szöveg, eszköztipp, figyelõ.
  public ToolCheckBox(String command, String text, String tip, ActionListener listener) {
    super(text);
    setMargin(new Insets(0,0,0,0));
    setFont(new Font("Dialog",Font.PLAIN,12));
    setActionCommand(command);
    setToolTipText(tip);
    addActionListener(listener);
  }
}
