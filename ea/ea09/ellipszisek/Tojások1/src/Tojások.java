import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tojások extends JFrame
{
    private int         változás = 30;  // méretváltozás mértéke

    private RajzPanel   rajz;           // a tojások megjelenítési helye

    private AbstractAction  növelés = new AbstractAction("Növelés")
    {
        public void actionPerformed(ActionEvent e)
        {
            rajz.méretváltás(változás);
        }
    };

    private AbstractAction  csökkenés = new AbstractAction("Csökkentés")
    {
        public void actionPerformed(ActionEvent e)
        {
            rajz.méretváltás(-változás);
        }
    };

    private AbstractAction  változásállítás = new AbstractAction("Változás mértéke")
    {
        public void actionPerformed(ActionEvent e)
        {
            String  str = JOptionPane.showInputDialog("Változás mértéke:");
            if ( str == null )  return;
            try { változás = Integer.parseInt(str); }
            catch (Exception ex) {}
        }
    };

    private AbstractAction  kilépés = new AbstractAction("Kilépés")
    {
        public void actionPerformed(ActionEvent e)  { kilép(); }
    };

    private WindowAdapter   kilépésvezérlő = new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)    { kilép(); }
    };

    private void kilép()    { System.exit(0); }

    public Tojások()
    {
        JMenuBar    menü = new JMenuBar();
        JMenu       tevékenységek = new JMenu("Tevékenységek");
        JMenuItem   növel = new JMenuItem(növelés);
        JMenuItem   csökkent = new JMenuItem(csökkenés);
        JMenuItem   változtat = new JMenuItem(változásállítás);
        JMenuItem   kilép = new JMenuItem(kilépés);

        növel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, Event.CTRL_MASK));
        növel.setMnemonic('N');
        csökkent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, Event.CTRL_MASK));
        csökkent.setMnemonic('C');
        változtat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
        változtat.setMnemonic('V');
        kilép.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.ALT_MASK));
        kilép.setMnemonic('K');
        tevékenységek.setMnemonic('T');

        tevékenységek.add(növel);
        tevékenységek.add(csökkent);
        tevékenységek.addSeparator();
        tevékenységek.add(változtat);
        tevékenységek.addSeparator();
        tevékenységek.add(kilép);
        menü.add(tevékenységek);

        setJMenuBar(menü);
        setSize(400, 300);
        rajz = new RajzPanel(140);
        add(rajz);
        addWindowListener(kilépésvezérlő);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Tojások.class.getResource("tojás.png")));
        setTitle("Tojások");
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Tojások();
    }
}
