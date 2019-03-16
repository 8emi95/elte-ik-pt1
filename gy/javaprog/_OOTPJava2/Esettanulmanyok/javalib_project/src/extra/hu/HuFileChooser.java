/*
 * Csomag: extra.hu
 * HuFileChooser.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2003.02.01.
 *
 * Magyar FileChooser
 */

package extra.hu;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class HuFileChooser extends JFileChooser {

  public HuFileChooser(String currentDirectoryPath) {
    super(currentDirectoryPath);
  }

  public HuFileChooser() {
  }

  public int showOpenDialog(Component parent) {
    return showDialog(parent,"Megnyit�s");
  }

  public int showSaveDialog(Component parent) {
    return showDialog(parent, "Ment�s");
  }

  public int showDialog(Component parent,String title) {
    // Megkeress�k az angol nyelv� komponenseket, hogy �tnevezhess�k magyarra:
    JLabel lbLookIn = findLabel(this, "Look In");
    if (lbLookIn != null)
      lbLookIn.setText("Hely:");

    JLabel lbSaveIn = findLabel(this, "Save In");
    if (lbSaveIn != null)
      lbSaveIn.setText("Hely:");

    JLabel lbFileName = findLabel(this, "File Name");
    if (lbFileName != null)
      lbFileName.setText("F�jln�v:");

    JLabel lbFileType = findLabel(this, "Files of");
    if (lbFileType != null)
      lbFileType.setText("F�jlt�pusok:");

    JButton btCancel = findButton(this, "Cancel");
    if (btCancel != null) {
      btCancel.setText("M�gse");
      btCancel.setToolTipText("F�jldial�gus elvet�se");
    }

    validate();
    int option = super.showDialog(parent,title);
    return option;
  }

  // Megkeresi a komponensf�n a label c�mk�j� JLabel-t. Ha nincs, null-t ad vissza:
  protected JLabel findLabel(JComponent comp, String text) {
    if (comp instanceof JLabel) {
      JLabel label = (JLabel)comp;
      String str = label.getText();
      if (str!=null && str.startsWith(text))
        return label;
    }
    else if (comp instanceof JPanel || comp instanceof JFileChooser){
      for (int i=0; i<comp.getComponentCount(); i++) {
        JComponent child = (JComponent)comp.getComponent(i);
        JComponent c = findLabel(child,text);
        if (c!=null)
          return (JLabel) c;
      }
    }
    return null;
  }

 // Megkeresi a komponensf�n a button c�mk�j� JButton-t. Ha nincs, null-t ad vissza:
  protected JButton findButton(JComponent comp, String text) {
    if (comp instanceof JButton) {
      JButton button = (JButton)comp;
      String str = button.getText();
      if (str!=null && str.startsWith(text))
        return button;
    }
    else if (comp instanceof JPanel || comp instanceof JFileChooser){
      for (int i=0; i<comp.getComponentCount(); i++) {
        JComponent child = (JComponent)comp.getComponent(i);
        JComponent c = findButton(child,text);
        if (c!=null)
          return (JButton) c;
      }
    }
    return null;
  }

}
