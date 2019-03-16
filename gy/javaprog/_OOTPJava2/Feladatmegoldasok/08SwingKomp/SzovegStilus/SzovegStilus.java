/*
 * Feladatmegold�sok/8. fejezet
 * SzovegStilus.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class SzovegStilus extends JFrame implements DocumentListener, ActionListener {
  private String[] strColors =
    {"black","white","red","magenta","orange"};
  private Color[] colors = {Color.black,Color.white,
    Color.red,Color.magenta,Color.orange};

  private JTextField tfText;
  private JComboBox cbFontName;
  private JComboBox cbFontSize;
  private JCheckBox chBold, chItalic;
  private JComboBox cbFontColor;
  private JRadioButton rbLeft, rbCenter, rbRight;
  private JLabel lbText;

  public SzovegStilus() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    JPanel pnEszkozsor = new JPanel();
    getContentPane().add(pnEszkozsor,"North");

    // A sz�veg tartalma:
    pnEszkozsor.add(tfText = new JTextField("Mintasz�veg",20));

    // Font n�v:
    pnEszkozsor.add(cbFontName = new JComboBox());
    cbFontName.addItem("Dialog");
    cbFontName.addItem("Monospaced");
    cbFontName.addItem("SansSerif");

    // Font m�ret:
    pnEszkozsor.add(cbFontSize = new JComboBox());
    for (int i=10; i<=50; i=i+2)
      cbFontSize.addItem(new Integer(i));
    cbFontSize.setSelectedItem(new Integer(30));

    // Font st�lus:
    pnEszkozsor.add(chBold = new JCheckBox("Bold"));
    pnEszkozsor.add(chItalic = new JCheckBox("Italic"));

    // Font sz�n:
    pnEszkozsor.add(cbFontColor = new JComboBox());
    for (int i=0; i<strColors.length; i++)
      cbFontColor.addItem(strColors[i]);

    // Font igaz�t�s:
    ButtonGroup bg = new ButtonGroup();
    pnEszkozsor.add(rbLeft = new JRadioButton("Left",false));
    pnEszkozsor.add(rbCenter = new JRadioButton("Center",true));
    pnEszkozsor.add(rbRight = new JRadioButton("Right",false));
    bg.add(rbLeft);
    bg.add(rbCenter);
    bg.add(rbRight);

    // A sz�veg:
    getContentPane().add(lbText=new JLabel(" "),"South");
    lbText.setBackground(Color.lightGray);

    // Keret hozz�ad�sa a vez�rl�k figyel�l�ncaihoz:
    tfText.getDocument().addDocumentListener(this);
    cbFontName.addActionListener(this);
    cbFontSize.addActionListener(this);
    chBold.addActionListener(this);
    chItalic.addActionListener(this);
    rbLeft.addActionListener(this);
    rbCenter.addActionListener(this);
    rbRight.addActionListener(this);
    cbFontColor.addActionListener(this);

    updateText();
    show();
  }

  // A font st�lus�nak �ssze�ll�t�sa:
  int fontStyle(boolean bold, boolean italic) {
    int style = 0;
    if (bold)
      style += Font.BOLD;
    if (italic)
      style += Font.ITALIC;
    return style;
  }

  // Sz�veg �ll�t�sa az �sszes kontroll leolvas�sa alapj�n:
  public void updateText() {
    lbText.setText(tfText.getText());
    Integer iObj = (Integer)cbFontSize.getSelectedItem();

    lbText.setFont(new Font(
      (String)cbFontName.getSelectedItem(),
      fontStyle(chBold.isSelected(),chItalic.isSelected()),
      iObj.intValue())
    );
    if (rbLeft.isSelected())
      lbText.setHorizontalAlignment(JLabel.LEFT);
    else if (rbCenter.isSelected())
      lbText.setHorizontalAlignment(JLabel.CENTER);
    else if (rbRight.isSelected())
      lbText.setHorizontalAlignment(JLabel.RIGHT);
    lbText.setForeground(colors[cbFontColor.getSelectedIndex()]);
    pack();
  }

  // B�rmilyen v�ltoz�s eset�n a sz�veget m�dos�tjuk:
  public void insertUpdate(DocumentEvent e) {
    updateText();
  }

  public void removeUpdate(DocumentEvent e) {
    updateText();
  }

  public void changedUpdate(DocumentEvent e) {
  }

  public void actionPerformed(ActionEvent e) {
    updateText();
  }

  public static void main (String args[]) {
    new SzovegStilus();
  } // main
} // SzovegStilus
