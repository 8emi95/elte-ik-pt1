/*
 * Mintaprogramok/5. fejezet
 * KomponensHierarchia.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class BevitelDialog extends JDialog implements ActionListener {
  Container cp = getContentPane();
  JButton btOk, btMegse;
  JPanel pn;

  BevitelDialog(JFrame owner) {
    super(owner,"Dialógus ablak",true);
    setLocation(owner.getWidth()-250,150);

    setResizable(false);
    cp.setBackground(Color.lightGray);
    cp.setLayout(new GridLayout(2,1));

    pn = new JPanel();
    cp.add(pn);
    pn.add(new JLabel("Címke: "));
    pn.add(new JTextField(15));

    pn = new JPanel();
    cp.add(pn);
    pn.add(btOk = new JButton("Nyomógomb1"));
    pn.add(btMegse = new JButton("Nyomógomb2"));
    btOk.addActionListener(this);
    btMegse.addActionListener(this);
    pack();
    show();
  }

  public void actionPerformed(ActionEvent e) {
    hide();
  }
}

public class KomponensHierarchia extends JFrame {
  private Container cp = getContentPane();
  private JMenuBar mb;
  private JMenu mLista;
  private JLabel lb;
  private JButton bt;
  private JTextField tf;
  private JTextArea ta;
  private JComboBox cob;
  private JList lst;
  private JCheckBox cb;
  private JRadioButton rb1, rb2;
  private ButtonGroup bg;
  private JScrollBar sb;

  public KomponensHierarchia() {
    setTitle("Komponensek");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocation(10,10);
    setJMenuBar(mb = new JMenuBar());
    mb.add(new JMenu("Menü1"));
    mb.add(mLista = new JMenu("Menü2"));
    mLista.add(new JMenuItem("Almenü1"));
    mLista.add(new JMenuItem("Almenü2"));
    mLista.add(new JMenuItem("Almenü3"));

    cp.setLayout(new FlowLayout());

    cp.add(lb = new JLabel("Címke"));
    cp.add(bt = new JButton("Nyomógomb"));
    cp.add(tf = new JTextField("Szövegmezõ",8));
    tf.select(1,3);
    cp.add(ta = new JTextArea("Szövegterület",5,8));

    cp.add(cob = new JComboBox());
    cob.addItem("1. választás");
    cob.addItem("2. választás");
    cob.addItem("3. választás");
    cob.setEditable(true);
    cob.setSelectedIndex(1);

    String[] szovegek = new String[] {"1. listaelem",
        "2. listaelem","3. listaelem","4. listaelem",
        "5. listaelem",};
    cp.add(lst = new JList(szovegek));
    lst.setSelectedIndex(1);

    cp.add(cb = new JCheckBox("Ellenõrzõ mezõ"));
    cb.setSelected(true);

    bg = new ButtonGroup();
    cp.add(rb1 = new JRadioButton("Rádió1"));
    cp.add(rb2 = new JRadioButton("Rádió2"));
    bg.add(rb1);
    bg.add(rb2);

    cp.add(sb = new JScrollBar());

    pack();
    show();
    JWindow w = new JWindow(this);
    w.setBounds(50,150,150,100);
    w.getContentPane().add(new JLabel(new ImageIcon(
        "icons/dukePainter.gif"),JLabel.CENTER));
    w.show();
    new BevitelDialog(this);
  }

  public static void main (String args[]) {
    new KomponensHierarchia();
  } // main
}
