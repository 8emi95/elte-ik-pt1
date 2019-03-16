import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tojások extends JFrame
{
    private int         változás = 30;  // méretváltozás mértéke

    private RajzPanel   rajz;           // a tojások megjelenítési helye

    private StatusBar   státuszsor;

    private AbstractAction  növelés = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            rajz.méretváltás(változás);
            státuszsor.setText(0, "Legnagyobb tojás: " + rajz.maxMéret());
        }
    };

    private AbstractAction  csökkenés = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            rajz.méretváltás(-változás);
            státuszsor.setText(0, "Legnagyobb tojás: " + rajz.maxMéret());
        }
    };

    private AbstractAction  változásállítás = new AbstractAction("Változás mértéke")
    {
        public void actionPerformed(ActionEvent e)
        {
            String  str = JOptionPane.showInputDialog("Változás mértéke:");
            if ( str == null )  return;
            try
            {
                változás = Integer.parseInt(str);
                státuszsor.setText(1, "Változás: " + változás);
            }
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

        növel.setText("Növelés");
        növel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, Event.CTRL_MASK));
        növel.setMnemonic('N');
        csökkent.setText("Csökkentés");
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

        státuszsor = new StatusBar(2);
        státuszsor.setText(0, "Legnagyobb tojás: 140");
        státuszsor.setText(1, "Változás: 30");
        státuszsor.setWidth(0, 100);
        státuszsor.setWidth(1, 100);

        setJMenuBar(menü);
        setSize(400, 300);
        setLayout(new BorderLayout());
        rajz = new RajzPanel(140);
        add("North", eszköztár());
        add("Center", rajz);
        add("South", státuszsor);
        addWindowListener(kilépésvezérlő);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Tojások.class.getResource("tojás.png")));
        setTitle("Tojások");
        setVisible(true);
    }

	private JToolBar eszköztár()
	{
		JToolBar	bar = new JToolBar();
		JButton		b;
		b = bar.add(növelés);
		b.setIcon(new ImageIcon(Tojások.class.getResource("növel.png")));
		b.setToolTipText("Növelés");
		b = bar.add(csökkenés);
		b.setIcon(new ImageIcon(Tojások.class.getResource("csökkent.png")));
		b.setToolTipText("Csökkentés");
		return bar;
	}

    public static void main(String[] args)
    {
        new Tojások();
    }
}
