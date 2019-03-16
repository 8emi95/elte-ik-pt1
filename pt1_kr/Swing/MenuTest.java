
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** 
 * @version 2017. m�jus 16.
 * 
 * encoding: windows-1250
 */
class MenuFrame extends JFrame implements ActionListener {
  JMenuBar mb = new JMenuBar();
  // A Felvitel men�
  JMenu mFelvitel = new JMenu("Felvitel");
  JMenu mHallgatok = new JMenu("Hallgat�k");  
  JMenuItem miFiuk = new JMenuItem("Fi�k",'F');
  JMenuItem miLanyok = new JMenuItem("L�nyok",'L');
  JMenuItem miTanarok = new JMenuItem("Tan�rok", 'T');
  JMenuItem miKilepes = new JMenuItem("Kil�p�s", 'K');
  // A Lista men�
  JMenu mLista = new JMenu("Lista");  
  JMenuItem miLista1 = new JMenuItem("Lista1");
  JMenuItem miLista2 = new JMenuItem("Lista2");
  JCheckBoxMenuItem cbmiNyomtatora = new JCheckBoxMenuItem("Nyomtat�ra");
  // A Sz�n men�
  JMenu mSzin = new JMenu("Sz�n");
  JRadioButtonMenuItem rbmiFeher = new JRadioButtonMenuItem("Feh�r");
  JRadioButtonMenuItem rbmiSarga = new JRadioButtonMenuItem("S�rga");
  JRadioButtonMenuItem rbmiPiros = new JRadioButtonMenuItem("Piros");
  ButtonGroup bg = new ButtonGroup();
  // A S�g� men�
  JMenu mSugo = new JMenu("S�g�");
  ImageIcon iiHasznalat = new ImageIcon("icons/help.gif");
  JMenuItem miHasznalat = new JMenuItem("Haszn�lat", iiHasznalat);
  JMenuItem miNevjegy = new JMenuItem("N�vjegy");

  Container cp = getContentPane();
  
  public MenuFrame(String title) {
    super(title);
    setDefaultCloseOperation(EXIT_ON_CLOSE);    
    setBounds(300, 200, 400, 200);        
    setJMenuBar(mb);
    // A Felvitel men�       
    mb.add(mFelvitel);        
    mFelvitel.add(mHallgatok);
    mHallgatok.add(miFiuk);
    mHallgatok.add(miLanyok);
    mFelvitel.add(miTanarok);
    mFelvitel.addSeparator();
    mFelvitel.add(miKilepes);
    
    miFiuk.addActionListener(this);    // A men�pontokat a keret figyeli
    miLanyok.addActionListener(this);  //
    miTanarok.addActionListener(this); //
    miKilepes.addActionListener(this); //
    // A Lista men�    
    mb.add(mLista);
    mLista.add(miLista1);
    mLista.add(miLista2);
    mLista.addSeparator();
    mLista.add(cbmiNyomtatora);
    
    miLista1.addActionListener(this);       // A men�pontokat a keret figyeli
    miLista2.addActionListener(this);       //
    cbmiNyomtatora.addActionListener(this); //
    // A Sz�n men�
    mb.add(mSzin);
    mSzin.add(rbmiFeher);
    mSzin.add(rbmiSarga);
    mSzin.add(rbmiPiros);
    bg.add(rbmiFeher); // ButtonGroup
    bg.add(rbmiSarga);
    bg.add(rbmiPiros);
    
    rbmiFeher.addActionListener(this); // A men�pontokat a keret figyeli
    rbmiSarga.addActionListener(this); //
    rbmiPiros.addActionListener(this); //
    // A S�g� men�
    mb.add(mSugo);
    mSugo.add(miHasznalat);
    mSugo.add(miNevjegy);

    miHasznalat.addActionListener(this); // A men�pontokat a keret figyeli
    miNevjegy.addActionListener(this);   //
    
    setVisible(true);   
  } // konstruktor

  private void lista(String title, int x, int y, int width, int height) {
    JFrame frList = new JFrame(title);
    frList.setLocation(x, y);
    frList.setSize(width, height);
    frList.setVisible(true);
  }

  /**
   * A men�pontok esem�nykezel� met�dusa.
   * @param e ActionEvent
   */
  public void actionPerformed(ActionEvent e) {
    String valasztas = e.getActionCommand();
    switch (valasztas) { // Java SE 7-t�l felfel� lehet String t�pus� a szelektor kifejez�s
      case "Fi�k":
        System.out.println("Fi�k felvitele");            
        break;
      case "L�nyok":
        System.out.println("L�nyok felvitele");            
        break;
      case "Tan�rok":
        System.out.println("Tan�rok felvitele");            
        break;
      case "Kil�p�s":
        System.exit(0);
        break;               
      case "Lista1":
        lista("Lista1", getX() + 10, getY() + 10, 250, 100);        
        break;
      case "Lista2":
        lista("Lista2", getX() + 50, getY() + 10, 300, 200);
        break;
      case "Nyomtat�ra":
        if (cbmiNyomtatora.isSelected())
          System.out.println("Nyomtat�ra");
        else
          System.out.println("Nem nyomtat�ra");            
        break;
      case "Feh�r":
        cp.setBackground(Color.WHITE);
        break;
      case "S�rga":
        cp.setBackground(Color.YELLOW);
        break;
      case "Piros":
        cp.setBackground(Color.RED);
        break;
      case "Haszn�lat":
      case "N�vjegy":
        JOptionPane.showMessageDialog(this, valasztas);
        break;
    } // switch
  } // actionPerformed()
} // class MenuFrame

public class MenuTest {    
  public static void main(String[] args) {
    //FontSetter.setFont("Dialog", Font.BOLD, args); // (name, style, size)
    new MenuFrame("Men� pr�ba");
  }
} // class MenuTest
