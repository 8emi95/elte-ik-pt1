
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Listában keres.
 * 
 * @author Keszthelyi Zsolt
 * @version 2017. május 14.
 * 
 * stereotype: boundary, control
 * encoding: windows-1250
 */
public class EntityListFrame2 extends JFrame implements
    ListSelectionListener, ActionListener {
  // Üres lista esetén is megjelenik északon:  
  private JLabel lbSzemely = new JLabel(" ");

  private DefaultListModel<Szemely> lmdSzemelyek = new DefaultListModel<>();
  private JList<Szemely> lstSzemelyek = new JList<>(lmdSzemelyek); // Generikus típus
  private JScrollPane spSzemelyek = new JScrollPane(lstSzemelyek);
  
  private JPanel pnKeres = new JPanel();
  private JLabel lbKeres = new JLabel("Név:");
  private JTextField tfKeres = new JTextField(15);
  
  public EntityListFrame2() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setBounds(200, 200, 400, 300);
    setTitle("Keresés a listában");
    Font font = new Font("Serif", Font.BOLD, 22);
    
    lbSzemely.setFont(font);
    lbSzemely.setForeground(Color.BLUE);

    // Egyedeket teszünk a konténerbe:
    lmdSzemelyek.addElement(new Szemely("Christina", "New York"));
    lmdSzemelyek.addElement(new Szemely("Zsolt", "Budapest"));
    lmdSzemelyek.addElement(new Szemely("Kimberly", "Denver"));
    lmdSzemelyek.addElement(new Szemely("Peter", "Sydney"));
    lmdSzemelyek.addElement(new Szemely("Olga", "Moscow"));        
    lmdSzemelyek.addElement(new Szemely("Catherine", "London"));
    
    lstSzemelyek.setFont(font);
    lstSzemelyek.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    lstSzemelyek.addListSelectionListener(this); // A keret figyeli a listát
    
    // ListSelectionEvent-et dob. Ha az index -1, nem csinál semmit.
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
    if (!e.getValueIsAdjusting()) { // Már nincs folyamatban a kiválasztás,
        // egérgomb felengedve. Biztosítja, hogy csak egyszer fusson le
        // az eseménykezelõ kód. Ha egérrel kattintunk egy listaelemre,
        // valueChanged kétszer fut le.
      Toolkit.getDefaultToolkit().beep();
      // Ha a JList típusparaméter nélkül deklerálva (nyers típus):
      // System.out.println(((Szemely)lstSzemelyek.getSelectedValue()).getNev());
      
      // Ha a JList<Szemely> típusparaméterrel deklerálva (generikus típus),
      // akkor nem kell a típuskényszerítés:      
      System.out.println(lstSzemelyek.getSelectedValue().getNev());
      // Nyers típus és generikus típus esetén is mûködik:
      // Nyers típus esetén is jól mûködik a késõi kötés miatt:
      lbSzemely.setText(lstSzemelyek.getSelectedValue().toString());      
    }
  } // valueChanged()

  /**
   * Meghívódik, ha a tfKeres beviteli mezõn Enter-t ütnek.
   * @param e ActionEvent 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String nev = tfKeres.getText();
    // Hasonlító objektum. Csak a nev mezõt kell beállítani.    
    Szemely keresettSzemely = new Szemely(nev, "");
    // keresettSzemely.equals(elementData[i])-t hívogatja:
    int index = lmdSzemelyek.indexOf(keresettSzemely);
    if (index == -1) // Nincs találat
      JOptionPane.showMessageDialog(this, "Nincs ilyen név: " + nev);
    else
      lstSzemelyek.setSelectedIndex(index);
  } // actionPerformed()
  
  public static void main(String[] args) {
    new EntityListFrame2();
  }  
} // class EntityListFrame2
