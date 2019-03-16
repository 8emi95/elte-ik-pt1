
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @version 2017. május 16.
 * 
 * encoding: windows-1250
 */
public class ColorChooserTest extends JFrame
    implements ActionListener {
  private JButton btSzin = new JButton("Színválasztás");
  
  public ColorChooserTest() {
    setTitle("ColorChooser");
    setBounds(150, 150, 300, 150);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(btSzin, BorderLayout.CENTER);
    btSzin.addActionListener(this);
    setVisible(true);
  } // konstruktor

  public void actionPerformed(ActionEvent ev) {
    Color color = JColorChooser.showDialog(this, "A gomb színe",
      btSzin.getBackground());
    if (color != null)
      btSzin.setBackground(color);
  }

  public static void main(String[] args) {
    //FontSetter.setFont("Dialog", Font.BOLD, args);    
    new ColorChooserTest();
  }
} // class ColorChooserTest
