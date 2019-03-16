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

    private MenuToolToggleItem  kitöltött;

    private int     választott;
    private static final Szín[]     töltőszínek = { new Szín(Color.gray, "Szürke"),
                                                    new Szín(Color.white, "Fehér"),
                                                    new Szín(Color.green, "Zöld") };
    private MenuToolToggleItem[]  szín;

    private AbstractAction  kitöltés = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            if ( kitöltött.isSelected() )   rajz.tölt(töltőszínek[választott].szín());
            else                            rajz.tölt(null);
        }
    };

    private AbstractAction  színező = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            for ( int i = 0; i < szín.length; i++ )
                if ( szín[i].isSource(e) )
                {
                    if ( kitöltött.isSelected() )   rajz.tölt(töltőszínek[i].szín());
                    választott = i;
                    return;
                }
        }
    };

    public Tojások()
    {
        választott = 0;
        kitöltött = new MenuToolToggleItem(kitöltés);
        szín = new MenuToolToggleItem[töltőszínek.length];

        státuszsor = new StatusBar(2);
        státuszsor.setText(0, "Legnagyobb tojás: 140");
        státuszsor.setText(1, "Változás: 30");
        státuszsor.setWidth(0, 100);
        státuszsor.setWidth(1, 100);

        setJMenuBar(menü());
        setSize(400, 300);
        setLayout(new BorderLayout());
        rajz = new RajzPanel(140);
        add("North", eszköztár());
        add("Center", new JScrollPane(rajz));
        add("South", státuszsor);
        addWindowListener(kilépésvezérlő);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Tojások.class.getResource("tojás.png")));
        setTitle("Tojások");
        setVisible(true);
        szín[választott].setSelected(true);
        kitöltött.setSelected(true);
    }

    private JMenuBar menü()
    {
        JMenuBar    menü = new JMenuBar();
        JMenu       tevékenységek = new JMenu("Tevékenységek");
        JMenuItem   növel = new JMenuItem(növelés);
        JMenuItem   csökkent = new JMenuItem(csökkenés);
        JMenuItem   változtat = new JMenuItem(változásállítás);
        JMenuItem   kilép = new JMenuItem(kilépés);
        JMenu       attribútumok = new JMenu("Attribútumok");

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

        JCheckBoxMenuItem   cbmi = new JCheckBoxMenuItem("Kitöltött");
        cbmi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, Event.CTRL_MASK));
        cbmi.setMnemonic('K');
        attribútumok.add(cbmi);     kitöltött.setMenuItem(cbmi);
        attribútumok.setMnemonic('A');
        attribútumok.addSeparator();
        ButtonGroup színek = new ButtonGroup();
        for ( int i = 0; i < töltőszínek.length; i++ )
        {
            szín[i] = new MenuToolToggleItem(színező);
            JRadioButtonMenuItem    mi = new JRadioButtonMenuItem(töltőszínek[i].név());
            mi.setMnemonic(töltőszínek[i].név().charAt(0));
            szín[i].setMenuItem(mi);
            attribútumok.add(mi);  színek.add(mi);
        }
        menü.add(attribútumok);
        return menü;
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
        bar.addSeparator();
        JCheckBox   cb = new JCheckBox(new ImageIcon(Tojások.class.getResource("üres.png")));
        bar.add(cb);
        cb.setSelectedIcon(new ImageIcon(Tojások.class.getResource("töltött.png")));
        cb.setToolTipText("Töltött/Üres");
        kitöltött.setToolItem(cb);
        bar.addSeparator();
        ButtonGroup színek = new ButtonGroup();
        for ( int i = 0; i < töltőszínek.length; i++ )
        {
            JRadioButton    rb = new JRadioButton(ikon(i));
            rb.setSelectedIcon(jelöltikon(i));
            rb.setToolTipText(töltőszínek[i].név());
            szín[i].setToolItem(rb);
            bar.add(rb);  színek.add(rb);
        }
		return bar;
	}

    private ImageIcon ikon(int i)
    {
        java.awt.image.BufferedImage    kép = new java.awt.image.BufferedImage(16, 16, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics    g = kép.getGraphics();
        g.setColor(töltőszínek[i].szín());
        g.fillOval(2, 2, 12, 12);
        return new ImageIcon(kép);
    }

    private ImageIcon jelöltikon(int i)
    {
        java.awt.image.BufferedImage    kép = new java.awt.image.BufferedImage(16, 16, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics    g = kép.getGraphics();
        g.setColor(töltőszínek[i].szín());
        g.fillOval(2, 2, 12, 12);
        g.setColor(Color.black);
        g.drawRect(0, 0, 15, 15);
        return new ImageIcon(kép);
    }

    public static void main(String[] args)
    {
        new Tojások();
    }
}
