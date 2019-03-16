
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** 
 * @version 2017. május 16.
 * 
 * encoding: windows-1250
 */
class MenuFrame extends JFrame implements ActionListener {
  JMenuBar mb = new JMenuBar();
  // A Felvitel menü
  JMenu mFelvitel = new JMenu("Felvitel");
  JMenu mHallgatok = new JMenu("Hallgatók");  
  JMenuItem miFiuk = new JMenuItem("Fiúk",'F');
  JMenuItem miLanyok = new JMenuItem("Lányok",'L');
  JMenuItem miTanarok = new JMenuItem("Tanárok", 'T');
  JMenuItem miKilepes = new JMenuItem("Kilépés", 'K');
  // A Lista menü
  JMenu mLista = new JMenu("Lista");  
  JMenuItem miLista1 = new JMenuItem("Lista1");
  JMenuItem miLista2 = new JMenuItem("Lista2");
  JCheckBoxMenuItem cbmiNyomtatora = new JCheckBoxMenuItem("Nyomtatóra");
  // A Szín menü
  JMenu mSzin = new JMenu("Szín");
  JRadioButtonMenuItem rbmiFeher = new JRadioButtonMenuItem("Fehér");
  JRadioButtonMenuItem rbmiSarga = new JRadioButtonMenuItem("Sárga");
  JRadioButtonMenuItem rbmiPiros = new JRadioButtonMenuItem("Piros");
  ButtonGroup bg = new ButtonGroup();
  // A Súgó menü
  JMenu mSugo = new JMenu("Súgó");
  ImageIcon iiHasznalat = new ImageIcon("icons/help.gif");
  JMenuItem miHasznalat = new JMenuItem("Használat", iiHasznalat);
  JMenuItem miNevjegy = new JMenuItem("Névjegy");

  Container cp = getContentPane();
  
  public MenuFrame(String title) {
    super(title);
    setDefaultCloseOperation(EXIT_ON_CLOSE);    
    setBounds(300, 200, 400, 200);        
    setJMenuBar(mb);
    // A Felvitel menü       
    mb.add(mFelvitel);        
    mFelvitel.add(mHallgatok);
    mHallgatok.add(miFiuk);
    mHallgatok.add(miLanyok);
    mFelvitel.add(miTanarok);
    mFelvitel.addSeparator();
    mFelvitel.add(miKilepes);
    
    miFiuk.addActionListener(this);    // A menüpontokat a keret figyeli
    miLanyok.addActionListener(this);  //
    miTanarok.addActionListener(this); //
    miKilepes.addActionListener(this); //
    // A Lista menü    
    mb.add(mLista);
    mLista.add(miLista1);
    mLista.add(miLista2);
    mLista.addSeparator();
    mLista.add(cbmiNyomtatora);
    
    miLista1.addActionListener(this);       // A menüpontokat a keret figyeli
    miLista2.addActionListener(this);       //
    cbmiNyomtatora.addActionListener(this); //
    // A Szín menü
    mb.add(mSzin);
    mSzin.add(rbmiFeher);
    mSzin.add(rbmiSarga);
    mSzin.add(rbmiPiros);
    bg.add(rbmiFeher); // ButtonGroup
    bg.add(rbmiSarga);
    bg.add(rbmiPiros);
    
    rbmiFeher.addActionListener(this); // A menüpontokat a keret figyeli
    rbmiSarga.addActionListener(this); //
    rbmiPiros.addActionListener(this); //
    // A Súgó menü
    mb.add(mSugo);
    mSugo.add(miHasznalat);
    mSugo.add(miNevjegy);

    miHasznalat.addActionListener(this); // A menüpontokat a keret figyeli
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
   * A menüpontok eseménykezelõ metódusa.
   * @param e ActionEvent
   */
  public void actionPerformed(ActionEvent e) {
    String valasztas = e.getActionCommand();
    switch (valasztas) { // Java SE 7-tõl felfelé lehet String típusú a szelektor kifejezés
      case "Fiúk":
        System.out.println("Fiúk felvitele");            
        break;
      case "Lányok":
        System.out.println("Lányok felvitele");            
        break;
      case "Tanárok":
        System.out.println("Tanárok felvitele");            
        break;
      case "Kilépés":
        System.exit(0);
        break;               
      case "Lista1":
        lista("Lista1", getX() + 10, getY() + 10, 250, 100);        
        break;
      case "Lista2":
        lista("Lista2", getX() + 50, getY() + 10, 300, 200);
        break;
      case "Nyomtatóra":
        if (cbmiNyomtatora.isSelected())
          System.out.println("Nyomtatóra");
        else
          System.out.println("Nem nyomtatóra");            
        break;
      case "Fehér":
        cp.setBackground(Color.WHITE);
        break;
      case "Sárga":
        cp.setBackground(Color.YELLOW);
        break;
      case "Piros":
        cp.setBackground(Color.RED);
        break;
      case "Használat":
      case "Névjegy":
        JOptionPane.showMessageDialog(this, valasztas);
        break;
    } // switch
  } // actionPerformed()
} // class MenuFrame

public class MenuTest {    
  public static void main(String[] args) {
    //FontSetter.setFont("Dialog", Font.BOLD, args); // (name, style, size)
    new MenuFrame("Menü próba");
  }
} // class MenuTest
