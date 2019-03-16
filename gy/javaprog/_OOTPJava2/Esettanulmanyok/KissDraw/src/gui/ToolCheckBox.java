/*
 * Projekt: KissDraw
 *
 * Csomag: drawing
 * ToolCheckBox.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// JCheckbox, melynek l�trehoz�skor kezd� param�tereket lehet adni.
public class ToolCheckBox extends JCheckBox {
  // Param�terek: Akci�parancs, sz�veg, eszk�ztipp, figyel�.
  public ToolCheckBox(String command, String text, String tip, ActionListener listener) {
    super(text);
    setMargin(new Insets(0,0,0,0));
    setFont(new Font("Dialog",Font.PLAIN,12));
    setActionCommand(command);
    setToolTipText(tip);
    addActionListener(listener);
  }
}
