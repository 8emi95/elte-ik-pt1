/*
 * Mintaprogramok/Esettanulmányok
 * Projekt: KissEditor
 * Csomag: kisseditor
 * FontChooser.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2003.04.01.
 */

package kisseditor;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class FontChooser extends JDialog implements ActionListener {
  private Container cp = getContentPane();
  // A környezet betûinek begyûjtése:
  private String[] fontNames =
      java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
  private JComboBox cbFonts = new JComboBox(fontNames);
  private JComboBox cbSize = new JComboBox();
  // Ebben a két szóban minden hosszú magyar magánhangzó elõfordul:
  private JLabel lbMinta = new JLabel("Árvíztûrõ tükörfúrógép",JLabel.CENTER);
  private JButton btOK = new JButton("OK");
  private JButton btMegse = new JButton("Cancel");
  private Font actFont;
  private static boolean ok;

  public FontChooser(JFrame owner, Font font) {
    super(owner,"Font",true);
    this.actFont = font;
    setBounds(100,100,400,200);

    // Font és méret állítása:
    JPanel pn = new JPanel();
    cp.add(pn,"North");
    pn.add(cbFonts);
    cbFonts.setEditable(true);
    cbFonts.setSelectedItem(actFont.getName());
    pn.add(cbSize);
    cbSize.setEditable(false);
    for (int i = 8; i <= 60; i+=2)
      cbSize.addItem(new Integer(i));
    cbSize.setSelectedItem(new Integer(actFont.getSize()));

    // Mintaszöveg:
    pn = new JPanel();
    cp.add(pn);
    pn.setBorder(BorderFactory.createTitledBorder("Sample"));
    pn.setBackground(Color.white);
    pn.setLayout(new BorderLayout());
    pn.add(lbMinta);
    lbMinta.setFont(actFont);

    // Vezérlõpanel: OK, Mégse
    pn = new JPanel();
    cp.add(pn,"South");
    pn.add(btOK);
    pn.add(btMegse);
    btOK.addActionListener(this);
    btMegse.addActionListener(this);
    cbFonts.addActionListener(this);
    cbSize.addActionListener(this);
  }

  public Font getAktFont() {
    return actFont;
  }

  public static Font showDialog(JFrame frame, Font initialFont) {
    FontChooser fc = new FontChooser(frame, initialFont);
    fc.show();
    if (ok)
      return fc.getAktFont();
    else
      return initialFont;
  }

  public void actionPerformed(ActionEvent e) {
    int size;
    try {
      Integer iObj = (Integer)cbSize.getSelectedItem();
      size = iObj.intValue();
      actFont = new Font((String)cbFonts.getSelectedItem(),Font.PLAIN,size);
    }
    catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(this,"Size must be a number!");
    }
    lbMinta.setFont(actFont);
    if (e.getSource()==btOK) {
      ok = true;
      hide();
    }
    else if (e.getSource()==btMegse) {
      ok = false;
      hide();
    }
  }
}
