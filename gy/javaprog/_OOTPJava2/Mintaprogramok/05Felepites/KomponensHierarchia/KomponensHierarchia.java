/*
 * Mintaprogramok/5. fejezet
 * KomponensHierarchia.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
    super(owner,"Dial�gus ablak",true);
    setLocation(owner.getWidth()-250,150);

    setResizable(false);
    cp.setBackground(Color.lightGray);
    cp.setLayout(new GridLayout(2,1));

    pn = new JPanel();
    cp.add(pn);
    pn.add(new JLabel("C�mke: "));
    pn.add(new JTextField(15));

    pn = new JPanel();
    cp.add(pn);
    pn.add(btOk = new JButton("Nyom�gomb1"));
    pn.add(btMegse = new JButton("Nyom�gomb2"));
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
    mb.add(new JMenu("Men�1"));
    mb.add(mLista = new JMenu("Men�2"));
    mLista.add(new JMenuItem("Almen�1"));
    mLista.add(new JMenuItem("Almen�2"));
    mLista.add(new JMenuItem("Almen�3"));

    cp.setLayout(new FlowLayout());

    cp.add(lb = new JLabel("C�mke"));
    cp.add(bt = new JButton("Nyom�gomb"));
    cp.add(tf = new JTextField("Sz�vegmez�",8));
    tf.select(1,3);
    cp.add(ta = new JTextArea("Sz�vegter�let",5,8));

    cp.add(cob = new JComboBox());
    cob.addItem("1. v�laszt�s");
    cob.addItem("2. v�laszt�s");
    cob.addItem("3. v�laszt�s");
    cob.setEditable(true);
    cob.setSelectedIndex(1);

    String[] szovegek = new String[] {"1. listaelem",
        "2. listaelem","3. listaelem","4. listaelem",
        "5. listaelem",};
    cp.add(lst = new JList(szovegek));
    lst.setSelectedIndex(1);

    cp.add(cb = new JCheckBox("Ellen�rz� mez�"));
    cb.setSelected(true);

    bg = new ButtonGroup();
    cp.add(rb1 = new JRadioButton("R�di�1"));
    cp.add(rb2 = new JRadioButton("R�di�2"));
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
