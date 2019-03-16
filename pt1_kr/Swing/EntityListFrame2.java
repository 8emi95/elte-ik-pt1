
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * List�ban keres.
 * 
 * @author Keszthelyi Zsolt
 * @version 2017. m�jus 14.
 * 
 * stereotype: boundary, control
 * encoding: windows-1250
 */
public class EntityListFrame2 extends JFrame implements
    ListSelectionListener, ActionListener {
  // �res lista eset�n is megjelenik �szakon:  
  private JLabel lbSzemely = new JLabel(" ");

  private DefaultListModel<Szemely> lmdSzemelyek = new DefaultListModel<>();
  private JList<Szemely> lstSzemelyek = new JList<>(lmdSzemelyek); // Generikus t�pus
  private JScrollPane spSzemelyek = new JScrollPane(lstSzemelyek);
  
  private JPanel pnKeres = new JPanel();
  private JLabel lbKeres = new JLabel("N�v:");
  private JTextField tfKeres = new JTextField(15);
  
  public EntityListFrame2() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setBounds(200, 200, 400, 300);
    setTitle("Keres�s a list�ban");
    Font font = new Font("Serif", Font.BOLD, 22);
    
    lbSzemely.setFont(font);
    lbSzemely.setForeground(Color.BLUE);

    // Egyedeket tesz�nk a kont�nerbe:
    lmdSzemelyek.addElement(new Szemely("Christina", "New York"));
    lmdSzemelyek.addElement(new Szemely("Zsolt", "Budapest"));
    lmdSzemelyek.addElement(new Szemely("Kimberly", "Denver"));
    lmdSzemelyek.addElement(new Szemely("Peter", "Sydney"));
    lmdSzemelyek.addElement(new Szemely("Olga", "Moscow"));        
    lmdSzemelyek.addElement(new Szemely("Catherine", "London"));
    
    lstSzemelyek.setFont(font);
    lstSzemelyek.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    lstSzemelyek.addListSelectionListener(this); // A keret figyeli a list�t
    
    // ListSelectionEvent-et dob. Ha az index -1, nem csin�l semmit.
    lstSzemelyek.setSelectedIndex(lmdSzemelyek.getSize() - 1);
    
    lbKeres.setFont(font);
    pnKeres.add(lbKeres);
    
    tfKeres.setFont(font);
    tfKeres.addActionListener(this);
    pnKeres.add(tfKeres);
        
    add(lbSzemely, BorderLayout.NORTH);
    add(spSzemelyek, BorderLayout.CENTER);
    add(pnKeres, BorderLayout.SOUTH);

    setVisible(true);
    tfKeres.requestFocus();
  } // konstruktor

  @Override
  public void valueChanged(ListSelectionEvent e) {
    if (!e.getValueIsAdjusting()) { // M�r nincs folyamatban a kiv�laszt�s,
        // eg�rgomb felengedve. Biztos�tja, hogy csak egyszer fusson le
        // az esem�nykezel� k�d. Ha eg�rrel kattintunk egy listaelemre,
        // valueChanged k�tszer fut le.
      Toolkit.getDefaultToolkit().beep();
      // Ha a JList t�pusparam�ter n�lk�l dekler�lva (nyers t�pus):
      // System.out.println(((Szemely)lstSzemelyek.getSelectedValue()).getNev());
      
      // Ha a JList<Szemely> t�pusparam�terrel dekler�lva (generikus t�pus),
      // akkor nem kell a t�pusk�nyszer�t�s:      
      System.out.println(lstSzemelyek.getSelectedValue().getNev());
      // Nyers t�pus �s generikus t�pus eset�n is m�k�dik:
      // Nyers t�pus eset�n is j�l m�k�dik a k�s�i k�t�s miatt:
      lbSzemely.setText(lstSzemelyek.getSelectedValue().toString());      
    }
  } // valueChanged()

  /**
   * Megh�v�dik, ha a tfKeres beviteli mez�n Enter-t �tnek.
   * @param e ActionEvent 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String nev = tfKeres.getText();
    // Hasonl�t� objektum. Csak a nev mez�t kell be�ll�tani.    
    Szemely keresettSzemely = new Szemely(nev, "");
    // keresettSzemely.equals(elementData[i])-t h�vogatja:
    int index = lmdSzemelyek.indexOf(keresettSzemely);
    if (index == -1) // Nincs tal�lat
      JOptionPane.showMessageDialog(this, "Nincs ilyen n�v: " + nev);
    else
      lstSzemelyek.setSelectedIndex(index);
  } // actionPerformed()
  
  public static void main(String[] args) {
    new EntityListFrame2();
  }  
} // class EntityListFrame2
