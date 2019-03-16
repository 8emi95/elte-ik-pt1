/*
 * Feladatmegoldások/11. fejezet
 * Projekt: KomponensFel
 * Csomag: extra.controls
 * ColorChoice.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Színeket lehet választani. A választandó színek szövegesek,
 * a kiválasztott szín Color osztályú.
 */

package extra.controls;

import javax.swing.JComboBox;
import java.awt.*;
import java.awt.event.*;

public class ColorChoice extends JComboBox {
  String[] strColors = {
    "white","lightGray","black","red","pink","orange","mustard",
    "green","magenta","cyan","blue"
  };
  Color[] colors = {
    Color.white,
    Color.lightGray,
    Color.black,
    new Color(255,100,100),  // piros
    Color.pink,
    Color.orange,
    new Color(200,180,130),  // mustár
    new Color(180,230,180),  // zöld
    new Color(130,130,130),  // lila
    new Color(40,170,180),   // turkiz
    new Color(120,120,200)   // kék
  };

  public ColorChoice() {
    super();
    for (int i=0; i<strColors.length; i++)
      addItem(strColors[i]);
  }

  public Color getSelectedColor() {
    return colors[getSelectedIndex()];
  }
} // ColorStringChoice
