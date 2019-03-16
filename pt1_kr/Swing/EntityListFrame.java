
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @author Keszthelyi Zsolt
 * @version 2017. május 14.
 * 
 * stereotype: boundary, control
 * encoding: windows-1250
 */
public class EntityListFrame extends JFrame implements
    ListSelectionListener {
  // Üres lista esetén is megjelenik északon:
  private JLabel lbSzemely = new JLabel(" ");
  
  private DefaultListModel<Szemely> lmdSzemelyek = new DefaultListModel<>();
  private JList<Szemely> lstSzemelyek = new JList<>(lmdSzemelyek); // Generikus típus
  private JScrollPane spSzemelyek = new JScrollPane(lstSzemelyek);

  public EntityListFrame() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setBounds(200, 200, 350, 300);
    setTitle("Egyedek tárolása listában");
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

    add(lbSzemely, BorderLayout.NORTH);
    add(spSzemelyek, BorderLayout.CENTER);

    setVisible(true);
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
    } // if
  } // valueChanged()
  
  public static void main(String[] args) {
    new EntityListFrame();
  }  
} // class EntityListFrame
